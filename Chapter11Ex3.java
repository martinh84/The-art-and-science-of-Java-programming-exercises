import acm.program.*;
import java.util.*;

/**
 * Question from The art and science of Java An Introduction to  Computer Science. Eric S. Roberts
 * Chapter 11. Exercise 2 and 3.
 * Another common statistical measure is the standard deviation, which provides an indication of 
 * how much the individual values in the distribution differ from the mean.
 * Write a method stdev(array) that takes an array of doubles and returns the standard deviation 
 * of the data distribution contained in the array.
 * 
 * I retained the mean average method used on previous exercises
 * 
 * The outcomes were tested against the Standard Deviation Calculator on Calculator.net
 *  
 * @author marti
 */

public class Main extends ConsoleProgram {
	
			
	public void run() {
		setFont("helvetica-36");
		ArrayList<Double> values = new ArrayList<Double>();
		println("This program will return the standard deviation of inputted numbers");
		println("\nTo stop entering numbers, please type -999");
		
		createArray(values);
		double mean = meanAverage(values);
		double dev = stdev(values, mean);
		println("The standard deviation to the numbers enetered is: " + dev);
		}
	
	/* Reads user input and adds to an ArrayList, using a sentinel to exit the method and return */
	private ArrayList<Double> createArray(ArrayList values) {
		while(true) {
			double num = readDouble("Enter a number: ");
			if(num == -999) break;
			values.add(num);
		} return values;
	}
			
	/* Returns the average score of the ArrayList to the main method */
	private double meanAverage(ArrayList values) {
		double total = 0;
		for(int i = 0; i <values.size(); i++) {
			total+= (Double) values.get(i);
		} return total / values.size();
	}
	
	/* Looping through the ArrayList, the difference between each value and the mean is captured, with the 
	 * total squared before returning with the standard deviation figure */
	private double stdev(ArrayList values, double mean) {
		double total = 0;
		for(int i = 0;i < values.size(); i++) {
		double diff = (Double)values.get(i) - mean;
		double square = diff*diff;
		total += square;
		}
		double answer = (total / values.size());
		return Math.sqrt(answer);
	}
	
	/* private constant to enable users to exit number entry loop and beign the calculation */
	private static final double SENTINEL = -999;
}
