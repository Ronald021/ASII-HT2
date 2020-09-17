package gt.com.antiguaburger.antiguaburgerweb.dao;

import gt.com.antiguaburger.antiguaburgerweb.controller.ConectionService;
import gt.com.antiguaburger.antiguaburgerweb.controller.IGetItems;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExtrasDao implements IGetItems {
    @Override
    public OrderEntity llenar(String id) {
        OrderEntity order=new OrderEntity();
        int price;
        String lleno=null;
        Connection conexion = null;
        ResultSet rs =null;
        try{
            ConectionService con= ConectionService.getInstance();
            conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT name,price FROM Extras where id="+id);
            rs=statement.executeQuery();
            while (rs.next()) {
                lleno = rs.getString("name");
                price = rs.getInt("price");
                order.setExtras(lleno);
                order.setTotal(price);
            }
            conexion.close();
            rs.close();
        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        }finally {
            try
            {
                conexion.close();
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return order;
    }
}