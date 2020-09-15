package gt.com.antiguaburger.antiguaburgerweb.print;


import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 
 */
public class PrintCSV implements IPrinter {

    /**
     * Default constructor
     */
    public PrintCSV() {
    }


    @Override
    public void print(OrderEntity order) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        int i=1;
        int sum=0;
        try
        {
            fichero = new FileWriter("/tmp/order.json");
            pw = new PrintWriter(fichero);
            pw.println("order , "+order.getOrder());
            pw.println("cashier , "+order.getCashier());
            pw.println("username , "+order.getUsername());
            pw.println("date , "+order.getDate());
            pw.println("customer , "+order.getCustomer());
            pw.println("taxId , "+order.getTaxid());
            pw.println("menu , "+order.getType());
            for(String value : order.getItems()){
                pw.println("item "+i+", "+value);
                pw.println("option, "+order.getItems().get(i-1));

                i++;
            }
            i=1;
            for(String value : order.getData()){
                pw.println("extra "+i+", "+value);
                i++;
            }
           /* for (int a = 0; a < order.getTotal(); a++) {
                sum += order.getPriceE().get(a);
            }*/
            //pw.println("Total ,"+order.getTotal());
            pw.printf(" Total: %s ",order.getTotal());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}