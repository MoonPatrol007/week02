
package graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javaReview02.JavaReview02;

/**
 * @author hector_juarez
 *
 */
public class Graph {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		
		// Displays the Graph information and the lines
		printLine(65);
		System.out.println("GRAPH:	\n\tPositive sign (+) = Hi and Negative sign (-) = Lo");
		printLine(65);
		System.out.println("   1  5  10  15  20  25  30  35  40  45  50");
		System.out.println("   |   |   |   |   |   |   |   |   |   |   |");
		printLine(65);
		System.out.println();
		

		
		JavaReview02 s = new JavaReview02();
	//	System.out.println(s.extracted());
		
		
		
		System.out.println();
		printLine(65);
		System.out.println("   |   |   |   |   |   |   |   |   |   |   |");
		System.out.println("   1  5  10  15  20  25   30  35  40  45  50");
		printLine(65);

	} // End of Main Method
	
	/**
	 * Method to print lines in the console as a separator
	 * @param dashes
	 */
	private static void printLine(int dashes) {
		for (int i = 1; i <= dashes; i++) {
			System.out.print("-");

		}
		System.out.print("\n");

	}

}
