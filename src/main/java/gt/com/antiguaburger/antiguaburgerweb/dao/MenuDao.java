package gt.com.antiguaburger.antiguaburgerweb.dao;

import gt.com.antiguaburger.antiguaburgerweb.controller.ConectionService;
import gt.com.antiguaburger.antiguaburgerweb.controller.ConectionService;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MenuDao {
    public OrderEntity llenar(String id) {
        List<String> lleno = new LinkedList<>();
        OrderEntity menu = new OrderEntity();
        int precio=0;
        Connection conexion = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;

        try {
            ConectionService con=ConectionService.getInstance();
            conexion = con.getConnection();
            statement = conexion.prepareStatement("SELECT id_menu,name FROM items WHERE id_menu="+id);
            statement2 = conexion.prepareStatement("SELECT price FROM menu WHERE id_menu="+id);
            ResultSet resultSet=statement.executeQuery();
            ResultSet resultSet2=statement2.executeQuery();
            while(resultSet.next()){
                lleno.add(String.valueOf(resultSet.getString("name")));
            }
            while(resultSet2.next()){
                precio=resultSet2.getInt("price");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try
            {
                conexion.close();
                statement.close();
                statement2.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        menu.setTotal(precio);
        menu.setItems(lleno);
        return menu;
    }

}