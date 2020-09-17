package gt.com.antiguaburger.antiguaburgerweb.controller;

import java.util.LinkedList;
import java.util.List;

public class OrderDecorator extends OrderBuilderDecorator{


    @Override
    public List<String> getDecoratorMenu(List<String> comida, List<String> option) {
    List<String> lista = new LinkedList<>();
        for(int a =0; a<option.size();a++){
            if(option.get(a) != null){
            lista.add(comida.get(a)+" ["+option.get(a)+"]");
            }else {
                lista.add(comida.get(a)+" ");
            }
        }
        return lista;
    }

}
