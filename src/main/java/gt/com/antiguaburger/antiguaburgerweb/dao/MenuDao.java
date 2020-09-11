package gt.com.antiguaburger.antiguaburgerweb.dao;

import gt.com.antiguaburger.antiguaburgerweb.controller.ConectionService;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class MenuDao {
    public OrderEntity llenar(String id) {
        List<String> lleno = new LinkedList<>();
        OrderEntity menu = new OrderEntity();
        int precio=0;

        try {
            ConectionService con=ConectionService.getInstance();
            Connection conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT id_menu,name FROM items WHERE id_menu="+id);
            PreparedStatement statement2 = conexion.prepareStatement("SELECT price FROM menu WHERE id_menu="+id);
            ResultSet resultSet=statement.executeQuery();
            ResultSet resultSet2=statement2.executeQuery();
            while(resultSet.next()){
                lleno.add(String.valueOf(resultSet.getString("name")));
            }
            while(resultSet2.next()){
                precio=resultSet2.getInt("price");
            }
            conexion.close();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            // throws an exception del finally v:
        }
        menu.setTotal(precio);
        menu.setItems(lleno);
        return menu;
    }

}