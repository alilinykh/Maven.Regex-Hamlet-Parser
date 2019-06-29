import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String replace1 (String input, String replace) {
        String rslt = "";
        String patternString = "(?i)" + input;
        Pattern patt = Pattern.compile(patternString);
        Matcher matcher = patt.matcher(hamletData);

        rslt = matcher.replaceAll(replace);
        return rslt;
    }


    public String getHamletData(){
        return hamletData;
    }

}
