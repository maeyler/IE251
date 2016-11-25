import java.awt.Toolkit;

class ClipboardData {
    public static void main(String[] args) throws Exception {
        final String[] a =  //read Clipboard into array
          Toolkit.getDefaultToolkit().getSystemClipboard()
            .getData(java.awt.datatransfer.DataFlavor.stringFlavor)
            .toString().replace(',', '.').split("\\p{Space}");

        if (a.length == 0) throw new RuntimeException("No data");
        Sample d = new Sample(); 
        for (String s : a)
            d.addData(Float.parseFloat(s));
        d.calculate(); 
        d.print("%6.2f "); d.report();
    }
}

/* sample data
36.45 68.71 37.43 42.18 26.72 50.77 39.3 49.71
8 values read 
Mean 43.908745 
Var  159.0175 
*/
