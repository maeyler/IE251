import java.util.*;

class DataSet {
    float mean, var;
    List<Number> data = new ArrayList<>();
    public DataSet() {}
    public void addData(List<Number> d) { 
        data.addAll(d); var = 0;
    }
    public void addData(Number x) {
        data.add(x); var = 0;
    }
    public void calculate() {
        final int n = data.size();
        //calculation of the mean
        float sum = 0;
        for (Number x : data) {
            sum += x.floatValue();
        }
        mean = sum/n; 
    
        //accurate calculation of the variance
        float dsq = 0;
        for (Number x : data) {
            float diff = x.floatValue() - mean; dsq += diff*diff;
        }
        var = dsq/(n-1);
    }
    public void print(String format) {
        //System.out.printf("%s values read %n", data.size());
        for (Number x : data) System.out.printf(format, x);
        System.out.printf("-> "+format+"%n", mean);
    }
    public void report() {
        if (var == 0) calculate(); 
        System.out.printf("Mean %s %n", mean);
        System.out.printf("Var  %s %n", var);
    }

    public static void main(String[] args) {
        DataSet d = new DataSet(); 
        Number[] a = { 36.45, 68.71, 37.43, 42.18, 26.72, 50.77, 39.3, 49.71 };
        d.addData(Arrays.asList(a)); d.calculate(); 
        d.print("%6.2f "); d.report();
    }
}
/* output
Mean 43.908745 
Var  159.0175 
*/
