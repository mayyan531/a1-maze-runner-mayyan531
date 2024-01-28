package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConvertMaze {// methods to convert the maze to a 2d array, identify the starting and end points, row length column length
    private int[][] mazeArr;
    private int rows;
    private int columns;
    private int entryRow;
    private int exitRow;

    private void makeMazeArr(String mazeFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(mazeFile));
        String line;

        while ( (line = reader.readLine()) != null){// gets column and row length
            if (columns == 0){
                columns = line.length();
            }
            rows++;
        }

        mazeArr = new int[rows][columns];

        reader.close();

        reader = new BufferedReader(new FileReader(mazeFile));

        int row = 0;

        while ((line = reader.readLine()) != null){
            for (int column = 0; column < line.length(); column++) {
                if (line.charAt(column) == '#') {
                    mazeArr[row][column]= 1; //wall
                } else if (line.charAt(column) == ' ') {
                    mazeArr[row][column]= 0; //pass
                }
            }
            row++;
        }

        for (int i = 0; i<rows; i++){
            if (mazeArr[i][0]==0){
                entryRow = i;
                break;
            }
        }
        for (int i = 0; i<rows; i++){
            if (mazeArr[i][columns-1]==0){
                exitRow = i;
                break;
            }
        }
    }
    public int[][] getMazeArr(String mazeFile) throws IOException {
        makeMazeArr(mazeFile);
        return mazeArr;
    }

    public int getEntryRow(){
        return entryRow;
    }

    public int getExitRow(){
        return exitRow;
    }

    public int getColumns(){ return columns; }

}


