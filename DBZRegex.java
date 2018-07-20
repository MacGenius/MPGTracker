import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBZRegex {
    public static void main(String[] args) {
        //Input/Output
        final String INPUT_FILE = "DBZ.txt";
        //final String OUTPUT_FILE ="Excel.txt";

        try {
            //access the input file
            File inputData = new File(INPUT_FILE);
            Scanner inputFile = new Scanner(inputData);
            //Access the output file
           // FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
           // PrintWriter outputFile = new PrintWriter(outputDataFile);

            // get the entire input file and store as a single string
            String content = new Scanner(new File(INPUT_FILE)).useDelimiter("\\Z").next();

            // removes all blank lines and tabs from the string we just made
            String adjusted = content.replaceAll("(?m)^[ \t]*\r?\n", "");
            System.out.println(adjusted); // print to show it works

            Pattern p = Pattern.compile(Pattern.quote("^\\s*Let's list off our fighters:\\s+(.*)") +
                    "(.*?)" + Pattern.quote("Freezer"), Pattern.DOTALL);
            //Pattern p = Pattern.compile("Let's list off our fighters:");
            //Pattern q = Pattern.compile("Freezer");
            Matcher m = p.matcher(adjusted);

            if (m.find()) {
                System.out.println(m.group());
            }
            //System.out.println(m.start());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

}
