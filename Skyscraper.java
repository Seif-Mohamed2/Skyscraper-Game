/*This porject implements simple game. 
Given 2d (4*4) array of building heights, the program verify that this setup is valid then prints out how many buidling can you see from 16 different sides.

for example: given the input:

4 3 2 1
1 4 3 2
3 2 1 4
2 1 4 3

the program outputs:

   1 2 3 3
   -------
1 |4 3 2 1| 4
2 |1 4 3 2| 3
2 |3 2 1 4| 1
2 |2 1 4 3| 2
   -------
   3 3 1 2

 */


import java.util.Scanner;
 
public class  Skyscraper {
	private int [] [] puzzle; //2d array for the main puzzzle
	private int DIM; // The dimintion of the puzzle
	private boolean valid; //boolean to verify whether the puzzle is valid or not

	//Thus function checks whether a given puzzle is valid or not
	//to be valid the puzzle has to have number from 1 to dimintion in each row and column 

	public boolean verifyPlacement(){
		int i;
		int j;
		int k;
		boolean inRange = true;
		boolean rows = true;
		boolean columns = true;
		int [] temp = new int [DIM]; 

		for (i = 0; i < DIM; i++){
			for (j = 0; j < DIM; j++ ){
				if ((puzzle [i][j] > DIM) || (puzzle [i][j] < 1))
					inRange = false;	
				}
			}
		

		for (i = 0; i < DIM; i++){
			for (k = 0; k < DIM; k++){
				temp [k] = 0;
			}

			for (j = 0; j < DIM; j++ ){
				for (k = 0; k < DIM; k++){


					if (temp[k] == puzzle[i][j]){
						rows = false;
						

					}
						 
					 
				}
				temp [j] = puzzle [i][j];
			}

		}

		for (j = 0; j < DIM; j++){
			for (k = 0; k < DIM; k++){
				temp [k] = 0;
			}

			for (i = 0; i < DIM; i++ ){
				for (k = 0; k < DIM; k++){

					if (temp[k] == puzzle[i][j]){
						columns = false;
					}
					 
				}
				temp [i] = puzzle [i][j];
			}

		}


		if ( (inRange == true)  && (rows == true)  &&  (columns == true)){
			valid = true;
		}

		else {
			valid = false;
		}

			return valid;
		
	}

	//This function simply takes the input from user and load it into the global puzzle array 
	public void loadPuzzle(){
		Scanner scnr = new Scanner (System.in);
		DIM = scnr.nextInt();

		puzzle = new int [DIM][DIM];
		int i;
		int j;

		for (i = 0; i < DIM; i++){
			for (j = 0; j < DIM; j++ ){
				puzzle [i][j] = scnr.nextInt();
			}
		}


	}
	//Prints the current puzzle in the puzzle array
	public void print(){
		int i;
		int j;

		for (i = 0; i < DIM; i++){
			for (j = 0; j < DIM; j++){
				if (j != DIM-1)
					System.out.print(puzzle[i][j] + " ");
				else
					System.out.print(puzzle[i][j]);
			}

				System.out.println();
		}
	}

	//This function prints the number of visisble buidlings from each side from the buidlings block
	//output example: 

/* 1 2 3 3
   -------
1 |4 3 2 1| 4
2 |1 4 3 2| 3
2 |3 2 1 4| 1
2 |2 1 4 3| 2
   -------
   3 3 1 2 */
	public void printWithVisibility() {
		
		System.out.print("  ");
		int i;
		int j;
		int count;
		int count2;
		int max;
		int max2;

		for (j = 0; j < DIM; j++){
			count = 0;
			max = 0;

			for (i = 0; i < DIM; i++){

				if (puzzle [i][j] > max){
					max = puzzle [i][j];
					count++;
				}
				
				}
			System.out.print(count + " ");
		}

		System.out.println();
		System.out.print("  ");

		for (i = 0; i < DIM*2 -1; i++){
			System.out.print("-");	

		}
		System.out.println();

		for (i = 0; i < DIM; i++){
			count = 0;
			max = 0;
			max2 = 0;
			count2 = 0;

			for (j = 0; j < DIM; j++){
				
				if (puzzle [i][j] > max){
					max = puzzle [i][j];
					count++;
				}

			}

			System.out.print(count);
			System.out.print("|");

			for (j = 0; j < DIM; j++){
				if (j != DIM-1)
					System.out.print(puzzle[i][j] + " ");
				else
					System.out.print(puzzle[i][j]);
			}

			System.out.print("|");

			for (j = DIM-1; j >= 0; j--){

				if (puzzle [i][j] > max2){
					max2 = puzzle [i][j];
					count2++;
				}

			}

			System.out.println(count2);

		}

		System.out.print("  ");
		for (i = 0; i < DIM*2 -1; i++){
			System.out.print("-");	

		}

		System.out.println();
		System.out.print("  ");

		for (j = 0; j < DIM; j++){
			count = 0;
			max = 0;

			for (i = DIM-1; i >= 0; i--){

				if (puzzle [i][j] > max){
					max = puzzle [i][j];
					count++;
				}
				
				}
			System.out.print(count + " ");
		}
	}


	//main function calling asking user for input and calling all other functions
	public static void main (String []args){
		Skyscraper x = new Skyscraper();
		System.out.println("Enter the puzzle dimension and then enter the puzzle");
		x.loadPuzzle();
		System.out.println();

		if (x.verifyPlacement()){

			System.out.println("This puzzle is valid");
			System.out.println();
			System.out.println("The puzzle is");
			System.out.println();
			x.print();
			System.out.println();
			System.out.println("The visibilty is: ");
			System.out.println();
			x.printWithVisibility();
		}

		else {

			System.out.println("This puzzle is not valid");
			System.out.println();
			System.out.println("The puzzle is");
			System.out.println();
			x.print();
		}
		
		



	}

}	



