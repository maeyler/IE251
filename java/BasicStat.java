class BasicStat {
    public static void main(String[] args) throws Exception {
        final String[] a =  //read clipboard into array
          java.awt.Toolkit.getDefaultToolkit().getSystemClipboard()
            .getData(java.awt.datatransfer.DataFlavor.stringFlavor)
            .toString().replace(',', '.').split("\\p{Space}");
        final int n = a.length;
        System.out.printf("%s values read %n", n);
        
        //calculate mean and variance
        float sum = 0;
        float ssq = 0;
        for (String s : a) {
            System.out.println(s);
            float x = Float.parseFloat(s);
            sum += x;
            ssq += x*x;
        }
        final float m = sum/n; 
        System.out.printf("Mean %s %n", m);
        System.out.printf("Var2 %s %n", (ssq - sum*m)/(n-1));
        
        //more accurate calculation of variance
        float dsq = 0;
        for (String s : a) {
            float x = Float.parseFloat(s);
            dsq += (x-m)*(x-m);
        }
        System.out.printf("Var  %s %n", dsq/(n-1));
    }
}
