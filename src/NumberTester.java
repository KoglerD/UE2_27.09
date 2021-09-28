import java.beans.XMLDecoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberTester {

    private File file;
    private int[] firstNumber;
    private int[] secondNumber;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private ArrayList<String> documentList;

    public NumberTester(String fileName) {
        this.file = new File(fileName);

        boolean documentIsNotEmpty = true;
        if (file.exists()) {

            try (final BufferedReader br = new BufferedReader(new FileReader(file))) {

                int firstLineCounter = 0;
                String line = br.readLine();
                firstLineCounter = Integer.parseInt(line);
                firstNumber = new int[firstLineCounter];
                secondNumber = new int[firstLineCounter];
                int index = 0;
                while (line != null && firstLineCounter != 0) {
                    line = br.readLine();
                    String[] split = line.split(" ");

                    firstNumber[index] = Integer.parseInt(split[0]);
                    secondNumber[index] = Integer.parseInt(split[1]);
                    index++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Datei " + file.getName() + " ist nicht vorhanden");
        }
    }


    public NumberTest getOddTester() {
        return oddTester;
    }

    public NumberTest getPrimeTester() {
        return primeTester;
    }

    public NumberTest getPalindromeTester() {
        return palindromeTester;
    }

    public ArrayList<String> getDocumentList() {
        return documentList;
    }

    public void setOddTester(NumberTest oddTester) {
        this.oddTester = oddTester;
    }

    public void setPrimeTester(NumberTest primeTester) {
        this.primeTester = primeTester;
    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        this.palindromeTester = palindromeTester;
    }

    public void testFile() {
        for (int i = 0; i < firstNumber.length; i++) {
            if (firstNumber[i] == 1) {

            } else if (firstNumber[i] == 1) {

            } else if (firstNumber[i] == 1) {

            } else {
                
            }
        }
    }
}
