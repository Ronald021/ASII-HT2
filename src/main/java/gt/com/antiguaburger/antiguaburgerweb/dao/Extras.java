package gt.com.antiguaburger.antiguaburgerweb.dao;

import gt.com.antiguaburger.antiguaburgerweb.controller.ConectionService;
import gt.com.antiguaburger.antiguaburgerweb.controller.IGetItems;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Extras implements IGetItems {
	@Override
    public OrderEntity llenar(String id) {
        OrderEntity order = new OrderEntity();
        String lleno = null;
        int price=0;
        try{
            Connection conn = ConectionService.getConnection();
            String query = "SELECT name,price FROM Extras where id = "+id;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            lleno = rs.getString("name");
            price = rs.getInt("price");
            order.setExtras(lleno);
            order.setTotal(price);


            st.close();
        }catch (SQLException e){
            System.err.println("Ups! ");
            System.err.println(e.getMessage());
        }finally {
            // st.close();
        }
        return order;
    }
}