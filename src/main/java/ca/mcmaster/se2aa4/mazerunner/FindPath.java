package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;
import java.util.Arrays;

public class FindPath {// finds the path using right hand rule
    ConvertMaze maze = new ConvertMaze();
    private boolean isPath(int[][] mazeArr, int row, int column) {
        return mazeArr[row][column] == 0;
    }

    public String findPath(String mazeFilePath) throws IOException {
        int[][] mazeArr = maze.getMazeArr(mazeFilePath);
        int entryRow = maze.getEntryRow();
        int exitRow = maze.getExitRow();
        int direction = 2;// 1234 north east south west
        StringBuilder path= new StringBuilder();
        char forwards = 'F';
        char right = 'R';
        char left = 'L';

        int[] currPos = {entryRow,0};

        int[] exitPos = {exitRow, maze.getColumns()-1};

        System.out.println("direction is" + direction);

        while (!Arrays.equals(currPos, exitPos)){
            if (direction ==1){//north
                if (isPath(mazeArr,currPos[0],currPos[1]+1)){//check right
                    direction = 2;
                    path.append(right);
                    currPos[1]++;
                    path.append(forwards);
                }
                else if (isPath(mazeArr,currPos[0]-1,currPos[1])){//forwards
                    currPos[0]--;
                    path.append(forwards);
                }
                else{//left
                    direction =4;
                    path.append(left);
                }
                System.out.println("direction is" + direction);
                System.out.println(path);
                System.out.println("Current position is"+ currPos[0] + currPos[1]);

            }
            else if (direction ==2){//east
                if (isPath(mazeArr,currPos[0]+1,currPos[1])){//check right
                    direction =3;
                    path.append(right);
                    currPos[0]++;
                    path.append(forwards);
                    System.out.println("direction is" + direction);
                }
                else if (isPath(mazeArr,currPos[0],currPos[1]+1)){//forwards
                    currPos[1]++;
                    path.append(forwards);
                    System.out.println("direction is" + direction);
                }
                else{//left
                    direction =1;
                    path.append(left);
                }
                System.out.println(path);
                System.out.println("Current position is"+ currPos[0] + currPos[1]);
                System.out.println("Exit position is"+ exitPos[0] + exitPos[1]);

            }
            else if (direction ==3){//south
                if (isPath(mazeArr,currPos[0],currPos[1]-1)){//check right
                    direction =4;
                    path.append(right);
                    currPos[1]--;
                    path.append(forwards);
                }
                else if (isPath(mazeArr,currPos[0]+1,currPos[1])){//forwards
                    currPos[0]++;
                    path.append(forwards);
                }
                else{//left
                    direction = 2;
                    path.append(left);
                }
                System.out.println("direction is" + direction);
                System.out.println(path);
                System.out.println("Current position is"+ currPos[0] + currPos[1]);

            }
            else if (direction == 4){//west
                if (isPath(mazeArr,currPos[0]-1,currPos[1])){//check right
                    direction = 1;
                    path.append(right);
                    currPos[0]--;
                    path.append(forwards);
                }
                else if (isPath(mazeArr,currPos[0],currPos[1]-1)){//forwards
                    currPos[1]--;
                    path.append(forwards);
                }
                else{//left
                    direction =3;
                    path.append(left);
                }
                System.out.println("direction is" + direction);
                System.out.println(path);
                System.out.println("Current position is"+ currPos[0] + currPos[1]);
            }
        }
        return path.toString();
    }

    public static void main(String[] args) throws IOException {
        String mazeFilePath = "./examples/small.maz.txt"; // Provide the path to your maze file
        FindPath mazeConverter = new FindPath();

        System.out.println(mazeConverter.findPath(mazeFilePath));
    }
}
