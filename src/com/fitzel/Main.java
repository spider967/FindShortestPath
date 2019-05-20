package com.fitzel;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

    	System.out.println("Choose how you want to load data (enter '1' or '2') ");
    	System.out.println("1. load from file");
    	System.out.println("2. load from console");

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		int distance = 0;
		String reversePath = "";

		if (choice == 1 || choice == 2)
		{

		}
		else
		{

			while (choice < 1 || choice > 2) {
				System.out.println("Wrong choice, try again ");
				choice = scanner.nextInt();
			}
		}

		if (choice == 1) {
			FindPathInputReaderFile readerFile = new FindPathInputReaderFile();

			readerFile.loadData();

			distance = readerFile.findShortestPath(readerFile.getStartIndexRow(), readerFile.getStartIndexColumn(), readerFile.getEndIndexRow(),
					readerFile.getEndIndexColumn());
			reversePath = readerFile.getPath();
		}
		if (choice == 2){
			FindPathInputReaderStdIn readerStdIn = new FindPathInputReaderStdIn();

			readerStdIn.loadData();

			distance = readerStdIn.findShortestPath(readerStdIn.getStartIndexRow(), readerStdIn.getStartIndexColumn(), readerStdIn.getEndIndexRow(),
					readerStdIn.getEndIndexColumn());
			reversePath = readerStdIn.getPath();
		}



		if(distance != Integer.MAX_VALUE) {

			reversePath = reversePath.substring(0, reversePath.length()-1);
			StringBuilder path = new StringBuilder();
			path.append(reversePath);
			path = path.reverse();
			System.out.println("The shortest path from start position to target position "
					+ "has length " + distance);
			System.out.println("and the path is " + path);
		}
		else {
			System.out.println("Target position can't be reached from start position");
		}


    }
}
