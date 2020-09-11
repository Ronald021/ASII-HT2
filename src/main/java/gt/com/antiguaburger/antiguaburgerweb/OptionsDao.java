package gt.com.antiguaburger.antiguaburgerweb.dao;

import gt.com.antiguaburger.antiguaburgerweb.controller.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OptionsDao {
    public String llenar(String id) throws SQLException {
        String lleno = null;
            try{
            Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT name FROM options where id = "+id;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            lleno = rs.getString("name ");

            st.close();
        }catch (Exception e){
            System.err.println("Ups! ");
            System.err.println(e.getMessage());
        }finally {
            // st.close();
        }

        return lleno;
    }
}