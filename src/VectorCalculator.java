public class VectorCalculator  extends AbstractCalculator{

    public VectorCalculator(CalculateOperation add, CalculateOperation subtract, CalculateOperation multiply, CalculateOperation divide) {
        super(add, subtract, multiply, divide);
    }

    @Override
    public Number add(Number a, Number b) {
        return add.calc(a,b);
    }

    @Override
    public Number subtract(Number a, Number b) {
        return null;
    }

    @Override
    public Number multiply(Number a, Number b) {
        return null;
    }

    @Override
    public Number divide(Number a, Number b) {
        return null;
    }
}
