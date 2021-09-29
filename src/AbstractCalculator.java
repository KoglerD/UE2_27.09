public abstract class AbstractCalculator {
    protected CalculateOperation add;
    protected CalculateOperation subtract;
    protected CalculateOperation multiply;
    protected CalculateOperation divide;

    public abstract Number add(Number a, Number b);
    public abstract Number subtract(Number a, Number b);
    public abstract Number multiply(Number a, Number b);
    public abstract Number divide(Number a, Number b);

    public CalculateOperation getAdd() {
        return add;
    }

    public void setAdd(CalculateOperation add) {
        this.add = add;
    }

    public CalculateOperation getSubtract() {
        return subtract;
    }

    public void setSubtract(CalculateOperation subtract) {
        this.subtract = subtract;
    }

    public CalculateOperation getMultiply() {
        return multiply;
    }

    public void setMultiply(CalculateOperation multiply) {
        this.multiply = multiply;
    }

    public CalculateOperation getDivide() {
        return divide;
    }

    public void setDivide(CalculateOperation divide) {
        this.divide = divide;
    }
}
