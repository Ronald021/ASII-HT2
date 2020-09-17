package gt.com.antiguaburger.antiguaburgerweb.controller;


import gt.com.antiguaburger.antiguaburgerweb.dao.ExtrasDao;
import gt.com.antiguaburger.antiguaburgerweb.dao.MenuDao;
import gt.com.antiguaburger.antiguaburgerweb.dao.OptionsDao;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderWebEntity;
import gt.com.antiguaburger.antiguaburgerweb.prints.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComboBuilder {
    public OrderEntity  buildc (OrderWebEntity orderw) throws SQLException {
        IPrinter txt = new PrintTXT();
        IPrinter json = new PrintJSON();
        IPrinter html = new PrintHTML();
        IPrinter csv = new PrintCSV();
        IPrinter xml = new PrintXML();
        OrderEntity buildCombo = new OrderEntity();
        OrderDecorator deco = new OrderDecorator();
        OrderEntity items,extras = new OrderEntity();
        GetTotalOptions optt = new GetTotalOptions();
        int totaloptions = optt.totaloptions(orderw.getIdmenu());
        int total=0, totalextras=0,cantidad=1;
        List<String> options = new ArrayList<>();
        List<String> listmenu = new ArrayList<>();
        List<String> listextra = new ArrayList<>();
        List<String> aa = new ArrayList<>();


        OptionsDao opt = new OptionsDao();
        MenuDao menu = new MenuDao();
        ExtrasDao ext = new ExtrasDao();
        System.out.println("options");
        for(int a =0; a<totaloptions;a++) {
            options.add(opt.llenar(orderw.getIdoption().get(a)));
            System.out.println(orderw.getIdoption().get(a));
        }
        System.out.println("extras");

        for(int a =0; a<orderw.getIdExtra().size();a++) {
            extras = ext.llenar(orderw.getIdExtra().get(a));
            System.out.println(orderw.getIdExtra().get(a));
            listextra.add(extras.getExtras());
            totalextras = totalextras + (extras.getTotal()*cantidad);
        }
        System.out.println("idmenu");

        items = menu.llenar(orderw.getIdmenu());
        System.out.println(orderw.getIdmenu());
        listmenu = items.getItems();
        Date objDate = new Date();

        buildCombo.setCashier(orderw.getCashier());
        buildCombo.setTime(objDate.toString());
        buildCombo.setCustomer(orderw.getUser());
        buildCombo.setTaxid(orderw.getNit());
        buildCombo.setData(listextra);
        buildCombo.setTotal(items.getTotal()+totalextras);
        buildCombo.setItems(deco.getDecoratorMenu(listmenu,options));
        txt.print(buildCombo);
        json.print(buildCombo);
        html.print(buildCombo);
        csv.print(buildCombo);
        xml.print(buildCombo);
        return buildCombo;
    }
}
