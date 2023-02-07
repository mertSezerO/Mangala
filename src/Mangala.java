
class Mangala {
    private boolean user1;
    private boolean user2;
    private boolean is_repeating =false;
    private int[][] gameplan = {{0,4,4,4,4,4,4},{4,4,4,4,4,4,0}}; 
    private boolean on_change = false;
    private int on_hand ;
    private int mover ;
    
    public Mangala() {
    	user1 = true;
    	user2 = false;
    	mover = 1;
    }
    
    public void atMove(int hole_num) {
    	on_hand = gameplan[mover][hole_num];
    	if(on_hand != 0) {
    	gameplan[mover][hole_num] = 0;
    	int i= hole_num;
    	int counter =0;
    	if(on_hand ==1 && mover==1) {
    	   gameplan[mover][hole_num+1]++;
    	   on_hand--;
    	   i++;
    	   if(i!=6)
    		   counter++;
    	}
    	else if(on_hand ==1 && mover==0) {
     	   gameplan[mover][hole_num-1]++;
     	   on_hand--;
     	   i--;
     	  if(i!=0)
   		   counter++;
     	}
    	else {
    		while(on_hand>0) {
        		//user 1's holes traversing 
        		switch(mover) {
    			case 0: gameplan[mover][i] += 1;
     		            on_hand--;
    		            on_change=false;
     		            if(i==0 && counter != 0) {
     	 		          mover=1;
     	 		          on_change=true;
     		            }
     		            else {
     				       i--;
     				       counter++;
     		            }
     		            break;
     		    //user 2's holes traversing
    			case 1: gameplan[mover][i] += 1;
     		            on_hand--;
     		            on_change=false;
     		            if(i==6 && counter != 0) {
     	 		           mover=0;
     	 		           on_change=true;
     		            }
     		            else {
     			    	   i++;
     			    	   counter++;
     		            }
     		            break;
     		    default: break;
    			}
        }
        	if(!on_change && mover == 0)
        		i++;
        	if(!on_change && mover == 1)
        		i--;
    	}
    	vestedStones(i);
   		determineWhoMovesNext(i,counter);
  }
    	else
    		System.out.println("Hole has 0 stones. Select again.");
    	printEndOfMove();
 }
    public void vestedStones(int last_hole) {
   /*In this part we are checking the rule where the player takes stones if traversing process end in rival's hole 
    and has even # of stones.*/
    	if(user1 && mover==0 && last_hole != 0 && !on_change) {
    		if(gameplan[mover][last_hole] % 2 == 0) {
    			gameplan[1][6]+=gameplan[mover][last_hole];
    			gameplan[mover][last_hole]=0;
    		}
    	}
    	if(user2 && mover==1 && last_hole != 6 && !on_change) {
    		if(gameplan[mover][last_hole] % 2 == 0) {
    			gameplan[0][0]+=gameplan[mover][last_hole];
    			gameplan[mover][last_hole]=0;
    		}
    	}
    	
    /*In this part we are checking the rule where the player takes stones if traversing process end in player's hole
     and hasn't any stones before that.*/
    	if(user1 && mover==1 && last_hole != 6) {
    		if(gameplan[mover][last_hole] == 1 && gameplan[0][last_hole+1] !=0) {
    			gameplan[1][6] += gameplan[0][last_hole+1]+1;
    			gameplan[0][last_hole+1] =0;
    			gameplan[mover][last_hole] = 0;
    		}
    	}
    	if(user2 && mover==0 && last_hole != 0) {
    		if(gameplan[mover][last_hole] == 1 && gameplan[0][last_hole-1] !=0) {
    			gameplan[0][0] += gameplan[0][last_hole-1]+1;
    			gameplan[1][last_hole-1] =0;
    			gameplan[mover][last_hole] = 0;
    		}
    	}
    }
    
    public void determineWhoMovesNext(int last_hole,int counter) {
    	if(user1) {
    		if(counter != 0 && (last_hole != 6 || !on_change)) {
    		   user1 = false;	
    		   user2 =true;
    		   mover=0;
    		   setIsRepeating(false);
    		}
    		else {
    			setIsRepeating(true);
    			mover=1;
    		}
    	}
    	else {
    		if(counter != 0 && (last_hole != 0 || !on_change)) {
     		   user1 = true;	
     		   user2 = false;
     		   mover = 1;
     		   setIsRepeating(false);
     		}
    		else {
    			setIsRepeating(true);
    			mover=0;
    		}
    	}
    }
    
    public boolean isFinished() {
    	for(int i=1;i<7;i++) 
    		if(gameplan[0][i] != 0)
    			return false;
    	for(int i=0;i<6;i++)
    		if(gameplan[1][i] != 0)
    			return false;
    	return true;
    }
    
    public void printEndOfMove(){
    	for(int i=0;i<2;i++) {
    		for(int j=0;j<7;j++) {
    			System.out.print((i%2 ==0) ? (gameplan[i][j] + "|"):( "|" + gameplan[i][j]));
    		}
    		System.out.println("");
    	}
    }
    
    public boolean getUser1() {
    	return user1;
    }
    public boolean getUser2() {
    	return user2;
    }
    public boolean getIsRepeating() {
    	return is_repeating;
    }
    public void setIsRepeating(boolean bool) {
    	is_repeating = bool;
    }
}
