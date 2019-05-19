package com.fitzel;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
		FindPathInputReaderFile readerFile = new FindPathInputReaderFile();
		//com.fitzel.FindPathInputReaderStdIn readerStdIn = new com.fitzel.FindPathInputReaderStdIn();

		readerFile.loadData();

		int distance = readerFile.findShortestPath(readerFile.getStartIndexRow(), readerFile.getStartIndexColumn(), readerFile.getEndIndexRow(),
				readerFile.getEndIndexColumn());

		if(distance != Integer.MAX_VALUE) {
			String path = readerFile.getMinPath();
			System.out.println("The shortest path from start position to target position "
					+ "has length " + distance);
			System.out.println("and the path is " + path);
		}
		else {
			System.out.println("Target position can't be reached from start position");
		}


    }
}
