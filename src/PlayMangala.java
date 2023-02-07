import java.util.Scanner;
public class PlayMangala {

	public static void main(String[] args) {

		Mangala mangala = new Mangala();
		Scanner input = new Scanner(System.in);
		int hole_num =0;
		mangala.printEndOfMove();
		while(!mangala.isFinished()) {
			try{
				if(mangala.getIsRepeating()) {
					if(mangala.getUser1()) {
						System.out.println("User 1 Enter a new hole number:");
						hole_num = input.nextInt()-1;
						if(hole_num<0 || hole_num>5)
							throw new HoleNumberException();
					}		
					if(mangala.getUser2()) {
						System.out.println("User 2 Enter a new hole number:");
						hole_num = 7-input.nextInt();
						if(hole_num<0 || hole_num>5)
							throw new HoleNumberException();
					}	
				}
				else {
					if(mangala.getUser1()) {
						System.out.println("User 1 Enter hole number:");
						hole_num = input.nextInt()-1;
						if(hole_num<0 || hole_num>5)
							throw new HoleNumberException();
					}	
					if(mangala.getUser2()) {
						System.out.println("User 2 Enter hole number:");
						hole_num = 7-input.nextInt();
						if(hole_num<0 || hole_num>5)
							throw new HoleNumberException();
					}
				}
				mangala.atMove(hole_num);
			}
			catch(EmptyHoleException e){
				System.out.println(e.getMessage());
				mangala.printEndOfMove();
			}
			catch(HoleNumberException e){
				System.out.println(e.getMessage());
				mangala.printEndOfMove();
			}
		}
		input.close();
	}
}
