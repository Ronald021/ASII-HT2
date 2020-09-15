package gt.com.antiguaburger.antiguaburgerweb.controller;


import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderDecorator extends OrderBuilderDecorator{


    @Override
    public List<String> getDecoratoralgo(List<String> comida, List<String> option) {
    List<String> lista = new LinkedList<>();
        for(int a =0; a<option.size();a++){
            lista.add(comida.get(a)+" ["+option.get(a)+"]");
        }
        return lista;
    }

}
