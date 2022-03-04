package com.springcat.Controller;


import com.springcat.Model.Cart;
import com.springcat.Model.Cat;
import com.springcat.Model.JdbcCartRepository;
import com.springcat.Model.JdbcCatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ShowCatsController {

    private final JdbcCatRepository catReo;
    private final JdbcCartRepository cartRepository;

    @Autowired
    public ShowCatsController(JdbcCatRepository catReo, JdbcCartRepository cartRepository) {
        this.catReo = catReo;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/cats")
    public String showCats(Model model) {
        List<Cat> cats = new ArrayList<>();
        catReo.findAll().forEach(i->cats.add(i));
        model.addAttribute("cats", cats);
        return "cats";
    }

    @PostMapping("/cats")
    public String addToCart(Cart cart) {
        log.info("selected cats: "+cart.getSelectedCats());
        cartRepository.addCats(cart.getSelectedCats());
        return "redirect:/cats";
    }
}
