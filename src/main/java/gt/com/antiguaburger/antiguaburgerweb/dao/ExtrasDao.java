package gt.com.antiguaburger.antiguaburgerweb.dao;

import gt.com.antiguaburger.antiguaburgerweb.controller.IGetItems;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;
import gt.com.antiguaburger.antiguaburgerweb.controller.ConectionService;
import java.sql.*;

public class ExtrasDao implements IGetItems {
	@Override
    public OrderEntity llenar(String id) {
        OrderEntity order=new OrderEntity();
        int price;
        String lleno=null;
        try{
            ConectionService con= ConectionService.getInstance();
            Connection conexion = con.getConnection();
            PreparedStatement statement = conexion.prepareStatement("SELECT name,price FROM Extras where id="+id);
            ResultSet rs=statement.executeQuery();
            while (rs.next()) {
                lleno = rs.getString("name");
                price = rs.getInt("price");
                order.setExtras(lleno);
                order.setPriceE(price);
            }
            conexion.close();
        }catch (SQLException e){
            System.err.println("ERROR FATAL! ");
            System.err.println(e.getMessage());
        }finally {
            // st.close();
        }
        return order;
    }
}
