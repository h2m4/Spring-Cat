package com.springcat.Controller;

import com.springcat.Model.Cat;
import com.springcat.Model.JdbcCartRepository;
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
public class CartViewController {
//    @Autowired
//    private EmailSender emailSender;

    private JdbcCartRepository cartRepository;


    @Autowired
    public CartViewController(JdbcCartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("/cart")
    public String showCart(Model model) {
        log.info("go to cart page");
        model.addAttribute("catsInCart", catsInCart());
//        model.addAttribute("gift", new Gift());
        return "cart";
    }

    public List<Cat> catsInCart() {
        List<Cat> cats = new ArrayList<>();
        cartRepository.findAll().forEach(i->cats.add(i));
        return cats;
    }

//    @PostMapping ("/cart")
//    public String sendEmail(@ModelAttribute ("gift") Gift gift) {
//        log.info("gift:"+gift);
//        String destinationEmail = gift.getEmail();
//        String subject = gift.getComment();
//        emailSender.sendEmailWithAttachment(catsInCart(), destinationEmail, subject);
//        return "redirect:/cats";
//    }

}
