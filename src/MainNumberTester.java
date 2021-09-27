public class MainNumberTester {

    public static void main(String[] args) {
        NumberTester nt = new NumberTester("Numbers.xml");

        for (String s:
             nt.getDocumentList()) {
            System.out.println(s);
        }
    }
}
