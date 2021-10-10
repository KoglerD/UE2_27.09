import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("1 - Relational calculator\n" +
                    "2 - Vector calculator\n" +
                    "3 - Complex calculator\n" +
                    "4 - Exit program\n");
            int userInput = Integer.parseInt(scanner.nextLine());

            if (userInput == 4) {

                System.out.println("Das programm wird Beendet!");
                running = false;
                System.exit(0);
            }
            while (userInput != 1 && userInput != 2 && userInput != 3) {
                System.out.println("Die Eingabe ist ungültig!");
                System.out.println("Gib eine gültige Zahl ein!");
                userInput = Integer.parseInt(scanner.nextLine());
            }

            double[] allNum = numInput();
            int op = operations();
            Number a = new Number(allNum[0], allNum[1]);
            Number b = new Number(allNum[2], allNum[3]);
            Number conclusion = new Number(0, 0);
            while (op == 5) {
                allNum = numInput();
                op = operations();
                a = new Number(allNum[0], allNum[1]);
                b = new Number(allNum[2], allNum[3]);
            }
            switch (userInput) {
                case 1:
                    switch (op) {
                        case 1:
                            AbstractCalculator rationalC = rationalC();
                            conclusion = rationalC.add(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());

                            break;
                        case 2:
                            rationalC = rationalC();
                            conclusion = rationalC.subtract(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());
                            break;
                        case 3:
                            rationalC = rationalC();
                            conclusion = rationalC.multiply(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());
                            break;
                        case 4:
                            rationalC = rationalC();
                            conclusion = rationalC.divide(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());
                            break;
                        case 5:
                            allNum = numInput();
                            break;
                    }
                    break;
                case 2:
                    switch (op) {
                        case 1:
                            AbstractCalculator vectorCalc = vectorCalc();
                            conclusion = vectorCalc.add(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());

                            break;
                        case 2:
                            vectorCalc = vectorCalc();
                            conclusion = vectorCalc.subtract(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());
                            break;
                        case 3:
                            vectorCalc = vectorCalc();
                            conclusion = vectorCalc.multiply(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());
                            break;
                        case 4:
                            vectorCalc = vectorCalc();
                            conclusion = vectorCalc.divide(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());
                            break;
                        case 5:
                            allNum = numInput();
                            break;
                    }
                    break;
                case 3:
                    switch (op) {
                        case 1:
                            AbstractCalculator complexCalc = complexCalc();
                            conclusion = complexCalc.add(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());

                            break;
                        case 2:
                            complexCalc = complexCalc();
                            conclusion = complexCalc.subtract(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());
                            break;
                        case 3:
                            complexCalc = complexCalc();
                            conclusion = complexCalc.multiply(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());
                            break;
                        case 4:
                            complexCalc = complexCalc();
                            conclusion = complexCalc.divide(a, b);
                            System.out.println("Solution: ");
                            System.out.println("a = " + conclusion.getA());
                            System.out.println("b = " + conclusion.getB());
                            break;
                        case 5:
                            allNum = numInput();
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Das programm wird Beendet!");
                    running = false;
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }


        Number a = new Number(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));
        Number b = new Number(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));

        //rationalCalc.add(a, b);
    }

    public static AbstractCalculator rationalC() {
        AbstractCalculator rationalCalc = new RationalCalculator((x, y) -> {
            double zaehler = x.getA() * y.getB() + y.getA() * x.getB();
            double nenner = x.getB() * y.getB();

            Number num = kuerzen(nenner, zaehler);
            System.out.println(zaehler + "/" + nenner);
            return num;

            //Brueche brueche = new Brueche(zaehler, nenner);
            //brueche.ggt(zaehler, nenner);
            //brueche.kuerzen();

        }, (x, y) -> {
            double zaehler = x.getA() * y.getB() - y.getA() * x.getB();
            double nenner = x.getB() * y.getB();

            Number num = kuerzen(nenner, zaehler);
            System.out.println(zaehler + "/" + nenner);
            return num;
        }, (x, y) -> {
            double zaehler = x.getA() * y.getA();
            double nenner = x.getB() * y.getB();

            Number num = kuerzen(nenner, zaehler);
            System.out.println(zaehler + "/" + nenner);
            return num;
        }, (x, y) -> {
            double zaehler = x.getA() * y.getB();
            double nenner = x.getB() * y.getA();

            Number num = kuerzen(nenner, zaehler);
            System.out.println(zaehler + "/" + nenner);
            return num;
        });
        return rationalCalc;
    }

    public static AbstractCalculator vectorCalc() {
        AbstractCalculator vectorCalc = new VectorCalculator((x, y) -> {
            double zaehler = x.getA() + y.getA();
            double nenner = x.getB() + y.getB();

            Number num = kuerzen(nenner, zaehler);
            System.out.println(zaehler + "/" + nenner);
            return num;

        }, (x, y) -> {
            double zaehler = x.getA() - y.getA();
            double nenner = x.getB() - y.getB();
            Number num = kuerzen(nenner, zaehler);
            System.out.println(zaehler + "/" + nenner);
            return num;
        }, (x, y) -> {
            double zaehler = x.getA() * y.getA();
            double nenner = x.getB() * y.getB();
            Number num = kuerzen(nenner, zaehler);
            System.out.println(zaehler + "/" + nenner);
            return num;
        }, (x, y) -> {
            double zaehler = x.getA() / y.getA();
            double nenner = x.getB() / y.getB();
            Number num = kuerzen(nenner, zaehler);
            System.out.println(zaehler + "/" + nenner);
            return num;
        });
        return vectorCalc;
    }

    public static AbstractCalculator complexCalc() {
        AbstractCalculator complexCalc = new ComplexCalculator((x, y) -> {
            double zaehler = x.getA() + y.getA();
            double nenner = x.getB() + y.getB();
            System.out.println(zaehler + "/" + nenner);
            return new Number(zaehler, nenner);

        }, (x, y) -> {
            double zaehler = x.getA() - y.getA();
            double nenner = x.getB() - y.getB();
            System.out.println(zaehler + "/" + nenner);
            return new Number(zaehler, nenner);
        }, (x, y) -> {
            double zaehler = x.getA() * y.getA() - x.getB() * y.getB();
            double nenner = x.getA() * y.getB() + x.getB() * y.getA();
            System.out.println(zaehler + "/" + nenner);
            return new Number(zaehler, nenner);
        }, (x, y) -> {
            double zaehler = x.getB() * y.getA() - x.getA() * y.getB();
            double nenner = (Math.pow(y.getA(), 2.0) + Math.pow(y.getB(), 2.0));
            System.out.println(zaehler + "/" + nenner);
            return new Number(zaehler, nenner);
        });
        return complexCalc;
    }

    public static double[] numInput() {
        Scanner scanner = new Scanner(System.in);
        double[] allNumbs = new double[4];
        System.out.print("\nEnter number x a> ");
        allNumbs[0] = Double.parseDouble(scanner.nextLine());
        System.out.print("\nEnter number x b> ");
        allNumbs[1] = Double.parseDouble(scanner.nextLine());
        System.out.print("\nEnter number y a> ");
        allNumbs[2] = Double.parseDouble(scanner.nextLine());
        System.out.print("\nEnter number y b> ");
        allNumbs[3] = Double.parseDouble(scanner.nextLine());


        return allNumbs;
        /*while (userInput != 1 || userInput != 2 || userInput != 3 || userInput != 4){
            System.out.println("Die Eingabe ist ungültig!");
            System.out.println("Gib eine gültige Zahl ein!");
            userInput = Integer.parseInt(scanner.nextLine());

        }*/
    }

    public static int operations() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - add");
        System.out.println("2 - subtract");
        System.out.println("3 - multiply");
        System.out.println("4 - divide");
        System.out.println("5 - enter numbers again");
        int op = Integer.parseInt(scanner.nextLine());
        return op;
    }

    public static Number kuerzen(double nenner, double zaehler){
        for (int i = 0; i < nenner; i++) {
            for (int j = 0; j < nenner; j++) {
                if(nenner%j == 0){
                    if(zaehler%j == 0){
                        nenner /= j;
                        zaehler /= j;
                    }
                }
            }
        }
        return new Number(zaehler, nenner);
    }

}
