package gt.com.antiguaburger.antiguaburgerweb.servlet;

import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cashier;
        cashier = request.getParameter("user");
        request.getSession(true).setAttribute("user",cashier);
        response.sendRedirect("/antiguaBweb-1.0-SNAPSHOT/menu.html");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()){
            out.println(request.getSession(false).getAttribute("user"));
            System.out.println(request.getSession(false).getAttribute("user"));
        }

    }
}
