package com.fitzel;

import java.io.IOException;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{

    private int index;

    @Override
    public void mazeDimension() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        if (rows > 1)
        {

        }
        else
        {

            while (rows < 2) {
                System.out.println("Wrong choice, try again ");
                rows = scanner.nextInt();
            }
        }
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();
        if (columns > 1)
        {

        }
        else
        {

            while (columns < 2) {
                System.out.println("Wrong choice, try again ");
                columns = scanner.nextInt();
            }
        }

        setMazeRows(rows);
        setMazeColumns(columns);
    }

    @Override
    public void readInput() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int symbol;

        for (int i = 0; i < getMazeRows(); i++){
            for (int j = 0; j < getMazeColumns(); j++){
                System.out.println("Enter '1' if you want a free path or '2' if you want a wall at following position: " + (i + 1) + " " + (j + 1));
                symbol = scanner.nextInt();
                if (symbol == 1 || symbol == 2)
                {

                }
                else
                {

                    while (symbol < 1 || symbol > 2) {
                        System.out.println("Wrong choice, try again ");
                        symbol = scanner.nextInt();
                    }
                }
                maze[i][j] = (symbol == 1) ? '.' : '#';
            }
        }

        System.out.println("Enter the row index of your start position.");
        index = scanner.nextInt();
        checkPosition(1);
        setStartIndexRow(index-1);

        System.out.println("Enter the column index of your start position.");
        index = scanner.nextInt();
        checkPosition(2);
        setStartIndexColumn(index-1);

        System.out.println("Enter the row index of your target position");
        index = scanner.nextInt();
        checkPosition(1);
        setEndIndexRow(index-1);

        System.out.println("Enter the column index of your target position");
        index = scanner.nextInt();
        checkPosition(2);
        setEndIndexColumn(index-1);

        addSymbol(getStartIndexRow(), getStartIndexColumn(), 'S');
        addSymbol(getEndIndexRow(), getEndIndexColumn(), 'X');

    }

    private void checkPosition(int dir){
        Scanner scanner = new Scanner(System.in);
        if (isValid(index, dir))
        {

        }
        else
        {

            while (!isValid(index ,dir)) {
                System.out.println("Position out of bounds, try again ");
                index = scanner.nextInt();
            }
        }
    }

    private boolean isValid(int pos, int dir){
        if (dir == 1)
            return (pos <= getMazeRows() && pos > 0);
        else
            return (pos <= getMazeColumns() && pos > 0);
    }
}
