package com.tests;

import com.fitzel.FindPathInputReaderFile;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FindPathTest {

    @Test
    public void mazeDimensionsTest() throws IOException {
        FindPathInputReaderFile reader = new FindPathInputReaderFile();
        reader.loadData();
        int numberOfRows = 10;
        int numberOfColumns = 26;
        int calculatedNumberOfRows = reader.getMazeRows();
        int calculatedNumberOfColumns = reader.getMazeColumns();

        Assert.assertEquals(numberOfRows, calculatedNumberOfRows);
        Assert.assertEquals(numberOfColumns, calculatedNumberOfColumns);
    }

    @Test
    public void matrixTest() throws IOException {
        FindPathInputReaderFile reader = new FindPathInputReaderFile();
        reader.loadData();

        char[][] maze = new char[][] {
                {'.','#','.','.','#','.','.','.','.','.','.','.','.','.','.','.','.','.','.','#','.','.','.','.','.','.'},
                {'.','#','S','.','.','.','#','.','.','.','.','.','.','#','#','.','.','#','#','#','.','.','#','#','#','.'},
                {'.','.','.','#','#','.','#','.','.','#','.','.','.','#','#','.','.','#','#','#','.','.','#','.','#','.'},
                {'.','.','.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','.','.','#','.','.','#','#','#','.'},
                {'.','#','#','.','.','#','#','.','.','#','#','.','.','.','.','.','#','.','.','.','.','.','.','.','.','.'},
                {'.','#','.','.','.','.','#','.','.','.','.','.','#','.','.','#','#','.','.','#','.','.','#','.','.','.'},
                {'.','#','.','.','#','.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','.','.','#','.','.','#'},
                {'.','.','.','.','.','.','.','.','.','.','.','#','.','#','#','.','#','.','.','.','#','.','#','.','.','.'},
                {'.','#','.','#','.','.','.','#','.','.','.','#','.','.','.','.','X','.','.','.','.','.','#','.','.','.'},
                {'.','.','.','#','#','#','#','#','.','.','.','.','.','.','.','.','#','.','.','.','.','.','.','.','.','.'},
        };

        char[][] loadedMaze = reader.getMaze();

        Assert.assertEquals(maze, loadedMaze);
    }

    @Test
    public void pathBuildingTest() throws IOException {
        FindPathInputReaderFile reader = new FindPathInputReaderFile();
        String path = "r,r,r,u,r,r,r,r,r,r,r,d,d,d,r,r,d,d,d,r,d,d,r";
        reader.loadData();
        reader.findShortestPath(reader.getStartIndexRow(), reader.getStartIndexColumn(), reader.getEndIndexRow(), reader.getEndIndexColumn());
        StringBuilder calculatedPathReverse = new StringBuilder();
        calculatedPathReverse.append(reader.getMinPath());
        calculatedPathReverse.reverse();
        String calculatedPath = calculatedPathReverse.substring(1, calculatedPathReverse.length());

        Assert.assertEquals(path, calculatedPath);
    }

    @Test
    public void findShortestPathTest()throws IOException {
        FindPathInputReaderFile reader = new FindPathInputReaderFile();
        int shortestPath = 23;
        reader.loadData();
        int calculatedShortestPath = reader.findShortestPath(reader.getStartIndexRow(), reader.getStartIndexColumn(), reader.getEndIndexRow(), reader.getEndIndexColumn());
        Assert.assertEquals(shortestPath, calculatedShortestPath);
    }

}
