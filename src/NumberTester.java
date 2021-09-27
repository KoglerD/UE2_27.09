import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberTester {

    private int firstNumber;
    private int secondNumber;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private ArrayList<String> documentList;

    public NumberTester(String fileName) {
        File file = new File(fileName);
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
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
        boolean documentIsNotEmpty = true;
        if (file.exists()) {

            try (final BufferedReader br = new BufferedReader(new FileReader(file))) {
                while (documentIsNotEmpty) {
                    String line = br.readLine();
                    String[] split = line.split(" ");
                    firstNumber = Integer.parseInt(split[0]);
                    secondNumber = Integer.parseInt(split[1]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("Datei " + file.getName() + " ist nicht vorhanden");
        }
    }
}
