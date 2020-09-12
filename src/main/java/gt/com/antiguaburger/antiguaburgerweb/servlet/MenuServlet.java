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
    OrderWebEntity web = new OrderWebEntity();
    OrderEntity order = new OrderEntity();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = ".";
        List<String> option = new ArrayList<>();
        List<String> copt = new ArrayList<>();
        List<String> ext = new ArrayList<>();
        List<String> cext = new ArrayList<>();



        String idmenu = request.getParameter("idmenu");
        option.add(request.getParameter("opt1"));
        option.add(request.getParameter("opt2"));
        option.add( request.getParameter("opt3"));
        copt.add(request.getParameter("copt1"));
        copt.add( request.getParameter("copt2"));
        copt.add(request.getParameter("copt3"));
        ext.add(request.getParameter("extra1"));
        ext.add( request.getParameter("extra2"));
        ext.add( request.getParameter("extra3"));
        cext.add( request.getParameter("cextra1"));
        cext.add( request.getParameter("cextra2"));
        cext.add( request.getParameter("cextra3"));

        web.setIdmenu(idmenu);
        web.setIdoption(option);
        web.setCantoption(copt);
        web.setIdExtra(ext);
        web.setCantextra(cext);
        web.setUser(user);

        ComboBuilder cm = new ComboBuilder();
    try {
            order = cm.buildc(web);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Gson gson = new Gson();
        String data = gson.toJson(order);
        System.out.println(data);
        response.sendRedirect("/antiguaBweb-1.0-SNAPSHOT/bill.html");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()){
            Gson gson = new Gson();
            String data = gson.toJson(order);
            out.println(data);
        }
    }
}
