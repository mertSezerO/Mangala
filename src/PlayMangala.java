import java.util.Scanner;
public class PlayMangala {

	public static void main(String[] args) {

		Mangala mangala = new Mangala();
		Scanner input = new Scanner(System.in);
		int hole_num =0;
		mangala.printEndOfMove();
		while(!mangala.isFinished()) {
			if(mangala.getIsRepeating()) {
				if(mangala.getUser1()) {
					System.out.println("User 1 Enter a new hole number:");
					hole_num = input.nextInt()-1;
				}		
				if(mangala.getUser2()) {
					System.out.println("User 2 Enter a new hole number:");
				    hole_num = 7-input.nextInt();
				}	
			}
			else {
				if(mangala.getUser1()) {
					System.out.println("User 1 Enter hole number:");
				    hole_num = input.nextInt()-1;
				}	
				if(mangala.getUser2()) {
					System.out.println("User 2 Enter hole number:");
					hole_num = 7-input.nextInt();
				}
			}
			mangala.atMove(hole_num);
		}
		input.close();
	}
}
