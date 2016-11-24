class DUniform {
    final static int M = 25, N = 10;  // MxN
    public static void insertData(DataSet d) {
        for (int i=0; i<N; i++) {
            d.addData((int)(Math.random()*N));
        }
    }
    public static void main(String[] args) {
        DataSet a = new DataSet();  //all data
        DataSet m = new DataSet();  //row averages
        for (int i=0; i<M; i++) {
            DataSet d = new DataSet();
            insertData(d); d.calculate(); 
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
