import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running){
            System.out.println("1 - Relational calculator\n" +
                    "2 - Vector calculator\n" +
                    "3 - Complex calculator\n" +
                    "4 - Exit program\n");
            int userInput = Integer.parseInt(scanner.nextLine());


            while (userInput != 1 || userInput != 2 || userInput != 3 || userInput != 4){
                System.out.println("Die Eingabe ist ungültig!");
                System.out.println("Gib eine gültige Zahl ein!");
                userInput = Integer.parseInt(scanner.nextLine());

            }

            double[] allNum = numInput();
            int op = operations();
            Number a = new Number(allNum[0], allNum[1]);
            Number b = new Number(allNum[2], allNum[3]);
            switch (userInput){
                case 1:
                     switch (op){
                         case 1:
                             AbstractCalculator rationalC = rationalC();
                             rationalC.add(a, b);
                             break;
                         case 2:
                             break;
                         case 3:
                             break;
                         case 4:
                             break;
                         case 5:
                             break;
                     }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Das programm wird Beendet!");
                    running = false;
                    System.exit(0);
                    break;
                default:
            }
        }


        Number a = new Number(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));
        Number b = new Number(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));

        //rationalCalc.add(a, b);
    }

    public static AbstractCalculator rationalC(){
        AbstractCalculator rationalCalc = new RationalCalculator((x, y) -> {
            double zaehler = x.getA()*y.getB()+y.getA()*x.getB();
            double nenner = x.getB()*y.getB();

            Brueche brueche = new Brueche(zaehler, nenner);
            brueche.kuerzen();
            System.out.println(zaehler +"/"+ nenner);
            return new Number(zaehler, nenner);

        }, (x,y) -> {

            return x;}, (x,y) -> {
            return x;},(x,y) -> {
            return x;});
        return rationalCalc;
    }

    public static double[] numInput(){
        Scanner scanner = new Scanner(System.in);
        double[] allNumbs = new double[4];
        System.out.println("Enter number x a> ");
        allNumbs[0] = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number x b> ");
        allNumbs[1] = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number y a> ");
        allNumbs[2] = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter number y b> ");
        allNumbs[3] = Double.parseDouble(scanner.nextLine());


        return allNumbs;
        /*while (userInput != 1 || userInput != 2 || userInput != 3 || userInput != 4){
            System.out.println("Die Eingabe ist ungültig!");
            System.out.println("Gib eine gültige Zahl ein!");
            userInput = Integer.parseInt(scanner.nextLine());

        }*/
    }

    public static int operations(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - add");
        System.out.println("2 - subtract");
        System.out.println("3 - multiply");
        System.out.println("4 - divide");
        System.out.println("5 - enter numbers again");
        int op = Integer.parseInt(scanner.nextLine());
        return op;
    }

}
