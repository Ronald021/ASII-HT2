package gt.com.antiguaburger.antiguaburgerweb.dao;

import gt.com.antiguaburger.antiguaburgerweb.controller.ConectionService;

import java.sql.*;

public class OptionsDao {

    public String llenar(String id) {
        String lleno= null;
        Connection conexion = null;
        PreparedStatement statement = null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
             statement = conexion.prepareStatement("SELECT * FROM options WHERE id="+id);
            ResultSet rs=statement.executeQuery();
            while (rs.next()) {
                lleno=rs.getString("name");
            }
        }catch (SQLException e){
            System.err.println("ERROR");
            System.err.println(e.getMessage());
        }finally {
            try {
                statement.close();
                conexion.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return lleno;
    }
}