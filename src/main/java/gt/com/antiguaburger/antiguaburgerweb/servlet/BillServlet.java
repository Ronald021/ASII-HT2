package gt.com.antiguaburger.antiguaburgerweb.servlet;

import com.google.gson.Gson;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderWebEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/bill"})
public class BillServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> test = new ArrayList<>();
        OrderWebEntity web = new OrderWebEntity();
        test.add("prueba1");
        test.add("prueba2");
        test.add("prueba3");
        test.add("prueba4");
        test.add("prueba5");
        test.add("prueba6");
        test.add("prueba7");
        test.add("prueba8");
        test.add("prueba9");
        web.setUser("asdffffffffffffffffffffffff");
        web.setNit("sdf");
        web.setIdoption(test);
        web.setIdmenu("2");
        web.setIdExtra(test);
        web.setCashier("asd");
        web.setCantoption(test);
        web.setCantextra(test);

        try (PrintWriter out = response.getWriter()){
            Gson gson = new Gson();
            String data = gson.toJson(web);
            out.println(data);
        }
    }
}
