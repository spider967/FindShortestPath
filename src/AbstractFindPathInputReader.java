import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public abstract class AbstractFindPathInputReader {

    protected char[][] maze;
    private boolean[][] visited;
    private int mazeRows;
    private int mazeColumns;
    private int startIndexRow;
    private int startIndexColumn;
    private int endIndexRow;
    private int endIndexColumn;
    private String path;
    private String minPath;

    private static final int row[] = { -1, 0, 0, 1 };
    private static final int col[] = { 0, -1, 1, 0 };

    public AbstractFindPathInputReader() {
        this.path = "";
    }

    public abstract void mazeDimension()throws IOException;

    public abstract void readInput() throws IOException;

    private static boolean isSafe(char maze[][], int visited[][], int posX, int posY){
        return !(maze[posX][posY] == '#' || visited[posX][posY] != 0);
    }

    private boolean isValid(char maze[][], boolean visited[][], int row, int column){
        return (row < mazeRows && column < mazeColumns && row >= 0 && column >= 0 && maze[row][column] != '#' && !visited[row][column]);
    }

    public void loadData() throws IOException{
        mazeDimension();
        maze = new char[mazeRows][mazeColumns];
        visited = new boolean[mazeRows][mazeColumns];
        for (int i = 0; i < mazeRows*mazeColumns; i++) {
            minPath += " ";
        }

        readInput();

        for (int i = 0; i < mazeRows; i++){
            for (int j = 0; j < mazeColumns; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
    }

    public int findShortestPath(int startPosX, int startPosY, int targetPosX, int targetPosY){

        Queue<Node> queue = new ArrayDeque<>();

        visited[startPosX][startPosY] = true;
        queue.add(new Node(startPosX, startPosY, 0));

        int min_distance = Integer.MAX_VALUE;

        while (!queue.isEmpty()){

            Node node = queue.poll();

            startPosX = node.getPosX();
            startPosY = node.getPosY();
            int distance = node.getDistance();

            if (startPosX == targetPosX && startPosY == targetPosY){
                min_distance = distance;
                break;
            }

            for (int k = 0; k < 4; k++){
                if (isValid(maze, visited, startPosX + row[k], startPosY + col[k])){
                    visited[startPosX + row[k]][startPosY + col[k]] = true;
                    queue.add(new Node(startPosX + row[k], startPosY + col[k], distance + 1));
                }
            }

        }
        return min_distance;
    }

    protected void addSymbol(int x, int y, char symbol){
        maze[x][y] = symbol;
    }

    public int getMazeRows() {
        return mazeRows;
    }

    public int getMazeColumns() {
        return mazeColumns;
    }

    public int getStartIndexRow() {
        return startIndexRow;
    }

    public int getStartIndexColumn() {
        return startIndexColumn;
    }

    public int getEndIndexRow() {
        return endIndexRow;
    }

    public int getEndIndexColumn() {
        return endIndexColumn;
    }

    public char[][] getMaze() {
        return maze;
    }

    public boolean[][] getVisited() {
        return visited;
    }

    public String getPath() {
        return path;
    }

    public String getMinPath() {
        return minPath;
    }

    protected void setMazeRows(int mazeRows) {
        this.mazeRows = mazeRows;
    }

    protected void setMazeColumns(int mazeColumns) {
        this.mazeColumns = mazeColumns;
    }

    public void setStartIndexRow(int startIndexRow) {
        this.startIndexRow = startIndexRow;
    }

    public void setStartIndexColumn(int startIndexColumn) {
        this.startIndexColumn = startIndexColumn;
    }

    public void setEndIndexRow(int endIndexRow) {
        this.endIndexRow = endIndexRow;
    }

    public void setEndIndexColumn(int endIndexColumn) {
        this.endIndexColumn = endIndexColumn;
    }
}
