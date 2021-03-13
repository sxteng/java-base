/*
//以下两段程序的差别
public final class Accumulator {
    private double result = 0.0D;
    public void addAll(@NonNull double[] values) {
        for(double value : values) {
            result += value;
        }
    }
    ...
}

public final class Accumulator {
    private double result = 0.0D;
    public void addAll(@NonNull double[] values) {
        double sum = 0.0D;
        for(double value : values) {
            sum += value;
        }
        result += sum;
    }
    ...
}*/
