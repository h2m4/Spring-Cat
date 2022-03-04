package com.springcat.Controller;

import com.springcat.Model.Cat;
import com.springcat.Model.JdbcCatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class ShowCatsController {

    private final JdbcCatRepository catReo;

    @Autowired
    public ShowCatsController(JdbcCatRepository catReo) {
        this.catReo = catReo;
    }

    @GetMapping("/cats")
    public String showCats(Model model) {
        List<Cat> cats = new ArrayList<>();
        catReo.findAll().forEach(i->cats.add(i));
        model.addAttribute("cats", cats);
        return "cats";
    }

}
