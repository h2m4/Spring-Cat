package com.springcat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatPageController {

    @GetMapping("/cat")
    public String catPage() {
        return "cat";
    }
}
