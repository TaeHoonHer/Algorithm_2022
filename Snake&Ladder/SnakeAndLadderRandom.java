
import java.util.Random;
public class SnakeAndLadderRandom {
	public static void printDicePosition(int curPos) {
		int quotient; 
		int remainder;
		
		quotient=curPos/10; remainder=curPos%10;
		for(int k=0;k<quotient;k++){
			for (int x=0;x<10;x++){
				System.out.print("-");
			}
			System.out.println();
		}
		for(int k=1;k<remainder;k++){
			System.out.print("-");
		}
		System.out.print("*");
		for(int k=remainder;k<10;k++){
			System.out.print(" ");
		}
	}
	public static void main(String[] args)throws InterruptedException {

		
		int ladderCount=0;
		int snakeCount=0;
		Random random = new Random(); //
		for (int curPos = 0, count=0; curPos < 100; ) {
			// clear screen
			for (int i = 0; i < 80; i++) {
				System.out.println();
			}

			curPos+=random.nextInt(6)+1;
			count++;
			if(curPos==8) {curPos=55; ladderCount++;}
			else if(curPos==19) {curPos=76; ladderCount++;}
			else if(curPos==32) {curPos=92; ladderCount++;}
			else if(curPos==56) {curPos=4;  snakeCount++;}
			else if(curPos==88) {curPos=33; snakeCount++;}
			else if(curPos==97) {curPos=59; snakeCount++;}
			/*
			for(int k=0;k<curPos;k++) {
				System.out.print("*");
			}
			*/
			printDicePosition(curPos);
			System.out.println(" "+curPos+"( 주사위던진횟수 : "+count+ "   ladder: "+ladderCount+ " snake : "+ snakeCount+")" );
			Thread.sleep(700);
		
		}

	}

}
