/*
package gt.com.antiguaburger.antiguaburgerweb.controller;

import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderEntity;
import gt.com.antiguaburger.antiguaburgerweb.modelo.OrderWebEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MenuController {


    @GetMapping("/login")
    public String indexForm(Model model) {
        model.addAttribute("login", new OrderWebEntity());
        return "login";
    }

    @PostMapping("/login")
    public String indexSubmit(@ModelAttribute OrderWebEntity orderw, Model model) {
        model.addAttribute("index", orderw.getCashier());
        model.addAttribute("menu",new OrderWebEntity());
        return "greeting";
    }


    /*@GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("menu", new OrderWebEntity());
        return "greeting";
    }*/
/*
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute OrderWebEntity orderw, Model model) {
        OrderEntity order = new OrderEntity();
        ComboBuilder build = new ComboBuilder();
        order = build.buildc(orderw);
        model.addAttribute("header", order);
        model.addAttribute("menu", order.getItems());
        model.addAttribute("extras", order.getData());
        model.addAttribute("total", order.getTotal());
        return "result";
    }

}
*/