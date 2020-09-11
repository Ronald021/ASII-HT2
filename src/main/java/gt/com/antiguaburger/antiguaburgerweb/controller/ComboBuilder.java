package gt.com.antiguaburger.antiguaburgerweb.controller;


import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderWebEntity;
import gt.com.antiguaburger.antiguaburgerweb.print.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComboBuilder {
    public OrderEntity buildc (OrderWebEntity orderw){
        IPrinter txt = new PrintTXT();
        IPrinter json = new PrintJSON();
        IPrinter html = new PrintHTML();
        IPrinter csv = new PrintCSV();
        IPrinter xml = new PrintXML();
        OrderEntity buildCombo = new OrderEntity();
        OrderDecorator deco = new OrderDecorator();
        OrderEntity items,extras = new OrderEntity();
        int total=0, totalextras=0,cantidad=1;
        List<String> options = new ArrayList<>();
        List<String> listmenu = new ArrayList<>();
        List<String> listextra = new ArrayList<>();
        List<String> aa = new ArrayList<>();


        Options opt = new Options();
        Menu menu = new Menu();
        Extras ext = new Extras();

        for(int a =0; a<orderw.getIdoption().size();a++) {
            options.add(opt.llenar(orderw.getIdoption().get(a)));
        }
        for(int a =0; a<orderw.getIdExtra().size();a++) {
            extras = ext.llenar(orderw.getIdExtra().get(a));
            listextra.add(extras.getExtras());
           //cantidad= Integer.parseInt(orderw.getCantextra().get(a));
            totalextras = totalextras + (extras.getTotal()*cantidad);
        }
        items = menu.llenar(orderw.getIdmenu());

        listmenu = items.getItems();
        Date objDate = new Date();
        buildCombo.setTime(objDate.toString());
        buildCombo.setCustomer(orderw.getUser());
        buildCombo.setTaxid(orderw.getNit());
        buildCombo.setData(listextra);
        buildCombo.setTotal(items.getTotal()+totalextras);
        buildCombo.setItems(deco.getDecoratoralgo(listmenu,options));
        txt.print(buildCombo);
        json.print(buildCombo);
        html.print(buildCombo);
        csv.print(buildCombo);
        xml.print(buildCombo);
        return buildCombo;
    }
}
