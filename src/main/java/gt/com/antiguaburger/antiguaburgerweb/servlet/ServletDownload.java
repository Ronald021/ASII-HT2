package gt.com.antiguaburger.antiguaburgerweb.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/downloadServlet")
public class ServletDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("download");

        String fileName = "/tmp/order."+id;
        String fileType = "text/plain";

        response.setContentType(fileType);

        // Make sure to show the download dialog
        response.setHeader("Content-disposition","attachment; filename=order."+id);

        File my_file = new File(fileName);

        // This should send the file to browser
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(my_file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
