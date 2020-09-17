package gt.com.antiguaburger.antiguaburgerweb.servlet;

import com.google.gson.Gson;
import gt.com.antiguaburger.antiguaburgerweb.controller.ComboBuilder;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderWebEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderWebEntity web = new OrderWebEntity();
        OrderEntity order = new OrderEntity();
        List<String> option = new ArrayList<>();
        List<String> copt = new ArrayList<>();
        List<String> ext = new ArrayList<>();
        List<String> cext = new ArrayList<>();

        String cashier = request.getParameter("cashier");
        String id = request.getParameter("idmenu");
        String customer = request.getParameter("customer");
        String taxid = request.getParameter("taxid");

        option.add(request.getParameter("opt1"));
        option.add(request.getParameter("opt2"));
        option.add( request.getParameter("opt3"));
        option.add( request.getParameter("opt4"));
        option.add( request.getParameter("opt5"));
        ext.add(request.getParameter("extra1"));
        cext.add( request.getParameter("cextra1"));
        ext.add(request.getParameter("extra2"));
        cext.add( request.getParameter("cextra2"));
        ext.add(request.getParameter("extra3"));
        cext.add( request.getParameter("cextra3"));
        ext.add(request.getParameter("extra4"));
        cext.add( request.getParameter("cextra4"));
        ext.add(request.getParameter("extra5"));
        cext.add( request.getParameter("cextra5"));
        ext.add(request.getParameter("extra6"));
        cext.add( request.getParameter("cextra6"));

        web.setIdmenu(id);
        web.setIdoption(option);
        web.setIdExtra(ext);
        web.setCantextra(cext);
        web.setCashier(cashier);
        web.setNit(taxid);
        web.setUser(customer);

        ComboBuilder cm = new ComboBuilder();
         try {
            order = cm.buildc(web);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Gson gson = new Gson();
        String data = gson.toJson(order);
        System.out.println(data);
        request.getSession(true).setAttribute("order",order);

        response.sendRedirect("/antiguaBweb-1.0-SNAPSHOT/bill.html");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()){
            Gson gson = new Gson();
            String data = gson.toJson(request.getSession(false).getAttribute("order"));
            out.println(data);
        }
    }
}
