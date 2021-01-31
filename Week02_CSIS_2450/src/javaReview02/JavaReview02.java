
package javaReview02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Java Review 02 CSIS 2450 Software Engineering I
 * 
 * @author hector_juarez
 * 
 *         The data has 31 rows, one for each day of the week of December 2020
 *         and each row has 3 columns, the first is the day number, the second
 *         is the high temperature that day and the third is the low temperature
 *         for that day.
 *
 *
 */
public class JavaReview02 {

	/**
	 * Function for calculating mean
	 * 
	 * @param a
	 * @param n
	 * @return
	 */
	public static int mean(int a[][], int n) {
		// Calculating sum
		int sum = 0;
		for (int i = 0; i < n; i++)
			for (int j = 1; j < n; j++)
				sum += a[i][j];

		// Returning mean
		return sum / (n * n);
	}

	/**
	 * Function for calculating variance
	 * 
	 * @param a
	 * @param n
	 * @param m
	 * @return
	 */
	public static int variance(int a[][], int n, int m) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {

				// subtracting mean from elements
				a[i][j] -= m;

				// squaring each terms
				a[i][j] *= a[i][j];
			}
		}

		// taking sum
		for (int i = 0; i < n; i++)
			for (int j = 1; j < n; j++)
				sum += a[i][j];

		return sum / (n * n);
	}

	// Function to find max element
	static int N = 31; // 31 rows
	static int M = 3; // 3 cols

	public static int findMax(int mat[][]) {

		// Initializing max element as INT_MIN
		int maxElement = Integer.MIN_VALUE;

		// checking each element of matrix if it is greater than maxElement, update
		// maxElement
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mat[i][1] > maxElement) {
					maxElement = mat[0][1];
				}
			}
		}

		// finally return maxElement
		return maxElement;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		// Read the file and print its contents to the console
		File fileName = new File(
				"C:/Users/hector_juarez/CS_projects/CSIS_2450_JReview02/SLCDecember2020Temperatures.csv");
		int rows = 31;
		int cols = 3;
		int[][] fileValues = new int[rows][cols];

		if (fileName.exists()) {
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";

			br = new BufferedReader(new FileReader(fileName));

			// Display information and the lines
			printLine(65);
			System.out.println("December 2020: Temperatures in Utah");
			printLine(65);
			System.out.print("Day\tHigh\tLow   Variance\n");

			for (int i = 0; i < rows; i++) {
				line = br.readLine();
				String[] stringValues = line.split(cvsSplitBy);
				for (int j = 0; j < cols; j++) {
					fileValues[i][j] = Integer.parseInt(stringValues[j]);

				}

			}

			br.close();
		}

		extracted(fileValues);

		// for mean
		int m = mean(fileValues, 2);

		// for variance
		// int var = variance(fileValues, 2, m);

		// displaying Mean and Variance
		// System.out.println("Mean: " + m);
		// System.out.println("Variance: " + var);

		// to get the highest and Lowest Temperature, Average and date of average
		printLine(65);
		System.out
				.println("December Temperatures Highest Temperature: 12/21: " + findMax(fileValues) + " Average Hi: " + m);
		System.out
				.println("December Temperatures Lowest Temperature: 12/13: " + findMax(fileValues) + " Average  Lo: " + m);
		printLine(65);

		// This will add the report's output into the new file called
		// TemperaturesReport.txt.
		FileWriter csvWriter = new FileWriter(
				"C:/Users/hector_juarez/CS_projects/CSIS_2450_JReview02/TemperaturesReport.txt", true);
		csvWriter.write("\r\n");
		for (int i = 0; i < fileValues.length; i++) {
			csvWriter.write(fileValues[i][0] + "," + fileValues[i][1] + "," + fileValues[i][2]);
			System.out.println();

		}
		csvWriter.close();

	} // end of Main Method

	/**
	 * @param fileValues
	 */
	static void extracted(int[][] fileValues) {
		// printing the data in the 2D array.
		int firstFileValues = fileValues.length;
		int SecFileValues = fileValues[1].length - 1;
		int total1 = 0;
		int total2 = 0;

		for (int m = 0; m < firstFileValues; m++) {
			for (int n = 0; n <= SecFileValues; n++) {
				if (n == 0) {
					System.out.print(fileValues[m][n] + " \t"); // High Temp

				} else if (n == 1) {
					System.out.print(fileValues[m][n] + " \t"); // Low Temp
					total1 = fileValues[m][n]; // adding to mean

				} else {
					System.out.print(fileValues[m][n] + " \t"); // all
					total2 = fileValues[m][n]; // adding to mean

				}

			} // End of Inner extracted for loop

			// Mean calculation is adding index 1 and 2 then dividing by 2.
			int mean = (int) ((Math.pow(((total1 + total2) / 2), 1)));

			// System.out.print(mean); // Mean

			// The variance
			double variance = 0;
			for (int i = 0; i < fileValues.length; i++) {
				variance += Math.pow(fileValues[i][0] - mean, 2);
			}
			variance /= fileValues.length;

			// Standard Deviation
			int std = (int) Math.sqrt(variance);

			System.out.print(std);
			System.out.println();

		} // End of Outter extracted for loop
	}

	/**
	 * Method to print lines in the console as a separator
	 * 
	 * @param dashes
	 */
	private static void printLine(int dashes) {
		for (int i = 1; i <= dashes; i++) {
			System.out.print("-");

		}
		System.out.print("\n");

	}


}
