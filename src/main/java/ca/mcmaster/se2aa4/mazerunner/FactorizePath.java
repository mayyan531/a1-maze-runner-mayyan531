package ca.mcmaster.se2aa4.mazerunner;

import java.io.IOException;

public class FactorizePath {//converts the path to a factorized path

    FindPath canonPath = new FindPath();

    public String factorizePath(String mazeFile) throws IOException {
        String canPath = canonPath.findPath(mazeFile);
        int len = canPath.length();
        StringBuilder factorizedPath = new StringBuilder();

        for (int i = 0; i<len; i++){
            char cur = canPath.charAt(i);
            int count = 1;

            while (i + 1 < len && canPath.charAt(i + 1) == cur){
                i++;
                count++;
            }

            if(count==1){
                factorizedPath.append(cur);
            }
            else{
                factorizedPath.append(count).append(cur);
            }

        }
        return factorizedPath.toString();
    }
}
