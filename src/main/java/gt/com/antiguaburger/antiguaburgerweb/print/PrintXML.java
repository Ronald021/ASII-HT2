package gt.com.antiguaburger.antiguaburgerweb.print;


import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 
 */
public class PrintXML implements IPrinter {

    /**
     * Default constructor
     */
    public PrintXML() {
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
            pw.println("<xml><titulo> <texto> Antigua Burger order </texto> </titulo>");
            pw.println(" <header> \n <texto> order "+order.getOrder()+" </texto>");
            pw.println(" <texto>  cashier "+order.getCashier()+" </texto> ");
            pw.println(" <texto> username "+order.getUsername()+" </texto> ");
            pw.println(" <texto> date" +order.getDate()+" </texto> ");
            pw.println(" <texto> customer "+order.getCustomer()+" </texto>  ");
            pw.println(" <texto> taxId "+order.getTaxid()+" </texto> \n </header>");

            pw.println(" <menu> \n <texto>"+order.getType()+"</texto> ");
            // pw.println("<tr>\n   <td> <strong> item </strong> </strong> </td> \n <td>  <strong> option  </strong> </td> \n </tr>");
            for(String value : order.getItems()){
                pw.println("<texto> "+value+" "+order.getItems().get(i-1)+"</texto>");
                i++;
            }
            pw.println("</menu> <extras>");
            i=1;
            for(String value : order.getData()){
                pw.println("<texto> "+value+"</texto>");
                i++;
            }
            /*
            for (int a = 0; a < ex.getPriceE().size(); a++) {
                sum += ex.getPriceE().get(a);
            }*/
            int total = order.getTotal();
            pw.println("</extras> <total> <texto> Total "+total+"</texto> </total>  </xml>");

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