package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        try {
            logger.info("** Starting Maze Runner");

            Options options = new Options();
            options.addOption("i", true, "MAZE_FILE");
            options.addOption("p",true,"PATH_SEQUENCE");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = null;

            try {
                cmd = parser.parse(options, args);
            } catch (ParseException e) {
                logger.error("Missing Argument");
                return;
            }

            String mazeFilePath = cmd.getOptionValue("i");

            String pathSequence = cmd.getOptionValue("p");

            if(mazeFilePath==null){
                logger.error("/!\\ An error has occurred: no MAZE_FILE/!\\");
                return;
            }

            File maze = new File(mazeFilePath);
            logger.info("**** Reading the maze from file " + maze);
            BufferedReader reader = new BufferedReader(new FileReader(maze));
            String line;

            /*while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }*/

            if(pathSequence==null){

                logger.info("**** Computing path");

                FactorizePath path = new FactorizePath();

                String factorizedPath = path.factorizePath(mazeFilePath);

                System.out.println("Path is: " + factorizedPath);

                logger.info("** End of MazeRunner");
            }
            else{
                logger.info("**** Validating path");

                VerifyPath verify = new VerifyPath();

                if(verify.verifyPath(mazeFilePath,pathSequence)){
                    System.out.println(pathSequence + " is the correct path");
                }
                else{
                    System.out.println(pathSequence + " is a incorrect path");
                }
                logger.info("** End of MazeRunner");
            }

        } catch(Exception e) {
            logger.error("/!\\ An error has occurred /!\\");
        }
    }
}
