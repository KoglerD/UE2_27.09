import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class HalloJavamitForEach {
    public static void main(String[] args) {
        ArrayList<String> lList = new ArrayList<>();
        lList.add("Add");
        lList.add("Remove");
        lList.add("Divide");
        lList.add("Java");
        lList.add("Instance");

        for (String sString : lList) {
            System.out.println(sString);
        }

        lList.forEach((String s) -> System.out.println(s));

        Consumer<String> consumer = (String s) -> System.out.println(s);

        lList.forEach(System.out::print);
    }
}
