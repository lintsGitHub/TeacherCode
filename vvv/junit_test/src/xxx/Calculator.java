package xxx;

public class Calculator implements ICal {

    @Override
    public float add(float a, float b) {
        return a + b;
    }

    @Override
    public float sub(float a, float b) {
        return -b + a;
    }

    @Override
    public float div(float a, float b) {
        if (a == 0 && b == 0){
            return 0;
        } else if (a == 0 || b == 0) {
            return 666;
        }
        return a / b;
    }

    @Override
    public float prod(float a, float b) {
        return 0;
    }
}
