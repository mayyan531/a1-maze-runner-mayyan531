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
            options.addOption("i", true, "Maze File Path");

            CommandLineParser parser = new DefaultParser();
            CommandLine cmd = null;

            try {
                cmd = parser.parse(options, args);
            } catch (ParseException e) {
                System.err.println(e.getMessage());
                return;
            }

            String mazeFilePath = cmd.getOptionValue("i");

            if(mazeFilePath==null){
                logger.info("null file path");
                return;
            }

            File maze = new File(mazeFilePath);

            logger.info("**** Reading the maze from file " + maze);
            BufferedReader reader = new BufferedReader(new FileReader(maze));
            String line;
            while ((line = reader.readLine()) != null) {
                for (int idx = 0; idx < line.length(); idx++) {
                    if (line.charAt(idx) == '#') {
                        System.out.print("WALL ");
                    } else if (line.charAt(idx) == ' ') {
                        System.out.print("PASS ");
                    }
                }
                System.out.print(System.lineSeparator());
            }
        } catch(Exception e) {
            System.err.println("/!\\ An error has occured /!\\");
        }
        logger.info("**** Computing path");

        findPath path = new findPath();
        logger.info("Path is", path);

        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }
}
