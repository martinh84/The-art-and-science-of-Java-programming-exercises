import acm.program.*;
import java.io.*;
import java.util.*;
import acm.graphics.*;
import acm.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Question from The art and science of Java An Introduction to  Computer Science. Eric S. Roberts
 * Chapter 11. Exercise 1.
 * Because individual contest judges may have some bias, it is common practice to throw out the highest
 * and lowest score before computing the average. Write a program that reads in scores from a panel of
 * seven judges and then computes the average of the five scores that remain after discarding the 
 * highest and lowest.
 * 
 * My initial attempt was to go for an array, but they lack the ability to remove elements and are not dynamic
 * 
 * I also attempted to remove the higher and lower elements in the same mthod, but found that it was cleaner
 * to separate - plus removing one element (higher), then another (lower) was changing the size of the 
 * ArrayList and adding more complexity
 * @author marti
 */

public class Main extends ConsoleProgram {
	
			
	public void run() {
		setFont("helvetica-36");
		ArrayList<Double> judges = new ArrayList<Double>();
		println("This program takes 7 scores, removes the extremes and returns the average");
		judgesScores(judges);
		removeHighest(judges);
		removeLowest(judges);
		println(judges);
		double finalScore = averageScore(judges);
		println("The average score was : " + finalScore);
		}
	
	/*Takes input from the user and adds to ArrayList*/
	private ArrayList<Double> judgesScores(ArrayList judges) {
		for(int i = 0; i < N_JUDGES; i++) {
			double score = readDouble("Enter score for judge " + (i+1) + ": ");
			judges.add(score);
		} return judges;
	}
	
	/*loops through the ArrayList to locate the highest double, capturing its index at the same point for removal*/
	private void removeHighest(ArrayList judges) {
		int hIndex = 0;
		double highest = 0;
		for(int i = 0; i < judges.size(); i++) {
			if((Double)judges.get(i) > highest) {
				highest = (Double)judges.get(i);
				hIndex = i;
				}
			} judges.remove(hIndex);
	}
	/*loops through the ArrayList to locate the lowest double, capturing its index at the 
	 * same point for removal*/
	private void removeLowest(ArrayList judges) {
		int lIndex = 0;
		double lowest = 100000000;
		for(int i = 0; i < judges.size(); i++) {
			if((Double)judges.get(i) < lowest) {
				lowest = (Double)judges.get(i);
				lIndex = i;
				}
			} judges.remove(lIndex);
	}
	
	/* Returns the average score of the ArrayList to the main method */
	private double averageScore(ArrayList judges) {
		double total = 0;
		for(int i = 0; i <judges.size(); i++) {
			total+= (Double) judges.get(i);
		} return total / judges.size();
	}
	
	
	/* Private constant to show how many judges at the start */ 
	private static final int N_JUDGES = 7;
}
