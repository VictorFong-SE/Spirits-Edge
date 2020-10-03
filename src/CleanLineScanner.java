//Tim Czepizak tczepi2
//Martin Bragiel mbragi2
//Victor Fong vfong3
//Code for CS342 Homework
//Professor Bell
//Class : Game
//Clean Line Scanner that was shown in class
import java.util.Scanner;
public class CleanLineScanner {
    public static String getCleanLine(Scanner s) {
        String line;
        while(true){
            if(!s.hasNextLine())
                break;
            line = s.nextLine();
            int comment = line.indexOf("//");
            if(comment == 0){
                continue;
            }
            if (comment > 0){
                line = line.substring(0, comment);
            }
            line = line.trim();
            if(line.length() > 0)
                return line;
        }
        return null;
    }
}
