package gt.com.antiguaburger.antiguaburgerweb.controller;


import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;

import java.util.ArrayList;
import java.util.List;

public class OrderDecorator extends OrderBuilderDecorator{


    @Override
    public List<String> getDecoratoralgo(List<String> comida, List<String> option) {
    List<String> lista = new ArrayList<>();
        for(int a =0; a<option.size();a++){
            lista.add(comida.get(a+1)+" ["+option.get(a)+"]");
        }
        return lista;
    }

}
