import java.beans.XMLDecoder;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberTester {

    private File file;
    private int firstNumber;
    private int secondNumber;
    private NumberTest oddTester;
    private NumberTest primeTester;
    private NumberTest palindromeTester;
    private int[] sNumberArray;
    private int[] fNumberArray;

    public NumberTester(String fileName) {
        this.file = new File(fileName);

        if (file.exists()) {

            try (final BufferedReader br = new BufferedReader(new FileReader(file))) {

                int firstLineCounter = 0;
                String line = br.readLine();
                firstLineCounter = Integer.parseInt(line);
                int index = 0;
                sNumberArray = new int[firstLineCounter];
                fNumberArray = new int[firstLineCounter];
                while (line != null && firstLineCounter != 0) {
                    line = br.readLine();
                    String[] split = line.split(" ");

                    firstNumber = Integer.parseInt(split[0]);
                    secondNumber = Integer.parseInt(split[1]);
                    sNumberArray[index] = secondNumber;
                    fNumberArray[index] = firstNumber;
                    if (firstNumber == 1) {
                        oddTester = (secondNumber) -> {
                            if (secondNumber % 2 == 0) {

                                return true;
                            }
                            return false;
                        };
                    } else if (firstNumber == 2) {
                        primeTester = (secondNumber) -> {
                            if (secondNumber < 2) {
                                return false;
                            }

                            ArrayList<Integer> allList = new ArrayList<>();
                            for (int i = 2; i <= secondNumber; i++) {
                                allList.add(i);
                            }

                            for (int i = 2; i < (allList.size()); i++) {
                                for (int j = 1; j < (allList.size()); j++) {
                                    if (allList.contains(i * j)) {
                                        allList.remove((Integer) (i * j));
                                    }
                                }
                            }

                            if (allList.contains(secondNumber)) {
                                return true;
                            }
                            return false;
                        };
                    } else if (firstNumber == 3) {
                        // palindrome Code von: https://www.baeldung.com/java-palindrome
                        palindromeTester = (secondNumber) -> {
                            String sNum = Integer.toString(secondNumber);
                            int length = sNum.length();
                            int forward = 0;
                            int backward = length - 1;
                            while (backward > forward) {
                                char forwardChar = sNum.charAt(forward++);
                                char backwardChar = sNum.charAt(backward--);
                                if (forwardChar != backwardChar)
                                    return false;
                            }
                            return true;
                        };
                    } else {
                        System.out.println("In der Datei sind ungueltige Zahlen vorhanden!");
                    }
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
        boolean od = false;
        boolean pr = false;
        boolean pa = false;
        for (int i = 0; i < sNumberArray.length; i++) {

            if (fNumberArray[i] == 1){
                od = oddTester.testNumber(sNumberArray[i]);
                if (od == true){
                    System.out.println("GERADE");
                }else{
                    System.out.println("UNGERADE");
                }
            }else if(fNumberArray[i] == 2){
                pr = primeTester.testNumber(sNumberArray[i]);
                if (pr == true){
                    System.out.println("PRIME");
                }else{
                    System.out.println("NOPRIME");
                }
            }else if (fNumberArray[i] == 3){
                pa = palindromeTester.testNumber(sNumberArray[i]);
                if (pa == true){
                    System.out.println("PALINDROME");
                }else{
                    System.out.println("NOPALINDROME");
                }
            }
        }


    }
}
