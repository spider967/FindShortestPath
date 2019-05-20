package com.fitzel;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
        ArrayList<Node> arrayOfNodes = new ArrayList<>();

        visited[startPosX][startPosY] = true;
        Node node = new Node(startPosX, startPosY, 0);
        node.setPredecessorPosX(-1);
        node.setPredecessorPosY(-1);
        queue.add(node);
        arrayOfNodes.add(node);

        int min_distance = Integer.MAX_VALUE;

        while (!queue.isEmpty()){

            node = queue.poll();

            startPosX = node.getPosX();
            startPosY = node.getPosY();
            int distance = node.getDistance();

            if (startPosX == targetPosX && startPosY == targetPosY){
                for (int k = 0; k < distance; k++){
                    for (int i = 0; i < arrayOfNodes.size(); i++){
                        if (node.getPredecessorPosX() == arrayOfNodes.get(i).getPosX() && node.getPredecessorPosY() == arrayOfNodes.get(i).getPosY()) {
                            path += translateMove(node.getPosX(), node.getPosY(), node.getPredecessorPosX(), node.getPredecessorPosY());
                            node = arrayOfNodes.get(i);
                        }
                    }
                }

                min_distance = distance;
                minPath = path;
                break;
            }

            for (int k = 0; k < 4; k++){
                if (isValid(maze, visited, startPosX + row[k], startPosY + col[k])){
                    visited[startPosX + row[k]][startPosY + col[k]] = true;
                    node = new Node(startPosX + row[k], startPosY + col[k], distance + 1);
                    node.setPredecessorPosX(startPosX);
                    node.setPredecessorPosY(startPosY);
                    queue.add(node);
                    arrayOfNodes.add(node);
                }
            }

        }
        return min_distance;
    }

    private String translateMove(int posX, int posY, int precPosX, int precPosY){
        if (posY == precPosY){
            if (posX > precPosX)
                return "d,";
            else
                return "u,";
        }
        if (posX == precPosX){
            if (posY > precPosY)
                return "r,";
            else
                return "l,";
        }
        return "";
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
