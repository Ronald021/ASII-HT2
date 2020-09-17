package gt.com.antiguaburger.antiguaburgerweb.prints;


import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 
 */
public class PrintHTML implements IPrinter {

    /**
     * Default constructor
     */
    public PrintHTML() {
    }



    @Override
    public void print(OrderEntity order) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        int i=1;
        int sum=0;
        try
        {
            fichero = new FileWriter("/tmp/order.html");
            pw = new PrintWriter(fichero);
            pw.println("<html>\n" +
                    "<head>\n" +
                    "<title>Antigua Burger </title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1 align=\"center\" >Antigua Burger order </h1>\n" +
                    "<hr>\n <table style=\"width:20%\">");
            pw.println("<tr><td>=================== </td> <td>============================ </td></tr>");
            pw.println(" <tr> \n <td> <strong> order </strong> </td> <td> "+order.getOrder()+" </td> \n </tr>");
            pw.println(" <tr> \n <td> <strong> cashier </strong> </td> <td> "+order.getCashier()+" </td> \n </tr>");
            pw.println(" <tr> \n <td> <strong> username </strong> </td> <td> "+order.getUsername()+" </td> \n </tr>");
            pw.println(" <tr> \n <td> <strong> date </strong> </td> <td> "+order.getDate()+" </td> \n </tr>");
            pw.println(" <tr> \n <td> <strong> customer </strong> </td> <td> "+order.getCustomer()+" </td> \n </tr>");
            pw.println(" <tr> \n <td> <strong> taxId </strong> </td> <td> "+order.getTaxid()+" </td> \n </tr>");
            pw.println("<tr><td>=================== </td> <td>============================ </td></tr>");
            pw.println(" <tr> \n <td> <strong> menu </strong> </td> <td> "+order.getType()+" </td> \n </tr>");
            // pw.println("<tr>\n   <td> <strong> item </strong> </strong> </td> \n <td>  <strong> option  </strong> </td> \n </tr>");
            for(String value : order.getItems()){
                pw.println("<tr> <td>---</td> \n <td> "+value+ "</td> </tr>");
                i++;
            }
            i=1;
            for(String value : order.getData()){
                pw.println("<tr> <td> <strong> extra "+i+" </strong></td> <td>"+value+"</td>");
                i++;
            }
            pw.println("<tr><td>==================== </td> <td>============================ </td></tr>");
            pw.println("<tr> <td> <strong> Total </strong> </td> <td>"+(order.getTotal())+"</td> </tr>");
            pw.println("<tr><td>==================== </td> <td>============================ </td></tr>");
            pw.println("</body> \n </html> ");

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