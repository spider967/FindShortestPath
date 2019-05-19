import java.io.IOException;
import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader{

    @Override
    public void mazeDimension() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = scanner.nextInt();

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
                maze[i][j] = (symbol == 1) ? '.' : '#';
            }
        }

        System.out.println("Enter the row index of your start position.");
        int index = scanner.nextInt();
        setStartIndexRow(index-1);
        System.out.println("Enter the column index of your start position.");
        index = scanner.nextInt();
        setStartIndexColumn(index-1);
        System.out.println("Enter the row index of your target position");
        index = scanner.nextInt();
        setEndIndexRow(index-1);
        System.out.println("Enter the column index of your target position");
        index = scanner.nextInt();
        setEndIndexColumn(index-1);

        addSymbol(getStartIndexRow(), getStartIndexColumn(), 'S');
        addSymbol(getEndIndexRow(), getEndIndexColumn(), 'X');

    }
}
