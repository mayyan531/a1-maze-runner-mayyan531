package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;
import java.util.Objects;

public class VerifyPath {
    FactorizePath shortPath = new FactorizePath();
    FindPath longPath = new FindPath();

    public boolean verifyPath(String mazeFile, String inputPath) throws IOException {
        String sPath = shortPath.factorizePath(mazeFile);
        String lPath = longPath.findPath(mazeFile);

        return Objects.equals(inputPath, sPath) || Objects.equals(inputPath, lPath);//verifies if either path is the input
    }
}
