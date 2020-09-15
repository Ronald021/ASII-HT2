package gt.com.antiguaburger.antiguaburgerweb.print;


import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 
 */
public class PrintTXT implements IPrinter {

    /**
     * Default constructor
     */
    public PrintTXT() {
    }



    @Override
    public void print(OrderEntity order) {
        int sum =0;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("/tmp/order.txt");
            pw = new PrintWriter(fichero);
            pw.println("=========================================================");
            pw.printf(" Orden: %d \n Cajero: %s (%s) \n Fecha/Hora: %s \n cliente: %s \n NIT: %s \n",
                    order.getOrder(),order.getCashier(),order.getUsername(),order.getDate(),order.getCustomer(), order.getTaxid());
            pw.println("=========================================================");
            pw.println(order.getType());
            for(int i =0; i<order.getItems().size();i++){
                    pw.printf(order.getItems().get(i)+"\n");
            }
            pw.println("\n=========================================================");
            pw.println(" Extras");
            for(int i =0; i<order.getData().size();i++){
                pw.printf("\t - %s \n",order.getData().get(i));
            }
            pw.println("=========================================================");
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