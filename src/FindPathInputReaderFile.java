import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FindPathInputReaderFile extends AbstractFindPathInputReader{

    @Override
    public void mazeDimension() throws IOException {

        String line;
        File myFile = new File("maze.txt");
        Scanner scanner = new Scanner(myFile);

        int rows = 0;
        int columns = 0;
        while (scanner.hasNextLine()){
            rows++;
            line = scanner.nextLine();
            columns = line.length();
        }
        setMazeRows(rows);
        setMazeColumns(columns);

    }

    @Override
    public void readInput() throws IOException {

        char symbol;
        String line;
        File myFile = new File("maze.txt");
        Scanner scanner = new Scanner(myFile);


        for (int i = 0; i < getMazeRows(); i++){
            line = scanner.nextLine();
            for (int j = 0; j < getMazeColumns(); j++){
                symbol = line.charAt(j);
                addSymbol(i, j, symbol);
                if (symbol == 'S'){
                    setStartIndexRow(i);
                    setStartIndexColumn(j);
                }
                if (symbol == 'X'){
                    setEndIndexRow(i);
                    setEndIndexColumn(j);
                }
            }
        }

    }

}
