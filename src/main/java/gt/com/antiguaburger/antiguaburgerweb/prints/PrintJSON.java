package gt.com.antiguaburger.antiguaburgerweb.prints;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 
 */
public class PrintJSON implements IPrinter {

    /**
     * Default constructor
     */
    public PrintJSON() {
    }


    @Override
    public void print(OrderEntity order) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {

            fichero = new FileWriter("/tmp/order.json");
            pw = new PrintWriter(fichero);

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            String or = gson.toJson((order));
            pw.println(or);
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