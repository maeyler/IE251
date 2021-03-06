class DUniform {
    final static int M = 25, N = 10;  // MxN
    public static void insertData(Sample d) {
        for (int i=0; i<N; i++) 
            d.addData((int)(Math.random()*N));
        d.calculate(); 
    }
    public static void main(String[] args) {
        Sample a = new Sample();  //all data
        Sample m = new Sample();  //row averages
        for (int i=0; i<M; i++) {
            Sample d = new Sample();
            insertData(d); 
            d.print("%3s "); 
            a.addData(d.data);
            m.addData(d.mean);
        }
        System.out.println("* All data");
        a.calculate(); a.report();
        System.out.println("* Row averages");
        m.calculate(); m.report();
    }
}
