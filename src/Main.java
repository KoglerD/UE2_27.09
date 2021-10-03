import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Number a = new Number(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));
        Number b = new Number(Double.parseDouble(scanner.nextLine()), Double.parseDouble(scanner.nextLine()));
        AbstractCalculator rationalCalc = new RationalCalculator((x, y) -> {
            double zaehler = x.getA()*y.getB()+y.getA()*a.getB();
            double nenner = x.getB()*y.getB();

            double biggest = 0;
            if (zaehler >= nenner){
                biggest = zaehler;
            }else{
                biggest = nenner;
            }
            for (int i = 0; i < biggest; i++) {
                if (zaehler % i == nenner % i){
                    zaehler /= i;
                    nenner /= i;
                }
            }
            System.out.println(zaehler +"/"+ nenner);
            return new Number(zaehler, nenner);

        }, (x,y) -> {

            return x;}, (x,y) -> {
            return x;},(x,y) -> {
            return x;});

        rationalCalc.add(a, b);
    }

}
