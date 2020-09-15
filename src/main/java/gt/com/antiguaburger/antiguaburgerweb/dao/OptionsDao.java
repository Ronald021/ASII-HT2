package gt.com.antiguaburger.antiguaburgerweb.dao;

import gt.com.antiguaburger.antiguaburgerweb.controller.ConectionService;
import gt.com.antiguaburger.antiguaburgerweb.controller.ConectionService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OptionsDao {

    public String llenar(String id) {
        String lleno= null;
        try{
            ConectionService con= ConectionService.getInstance();
            Connection conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM options WHERE id="+id);
            ResultSet rs=statement.executeQuery();
            while (rs.next()) {
                lleno=rs.getString("name");
            }
        }catch (SQLException e){
            System.err.println("ERROR");
            System.err.println(e.getMessage());
        }finally {
            // st.close();
        }
        return lleno;
    }
}