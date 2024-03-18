package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "トップページ");
        return "index";
    }

    @RequestMapping("/{num}")
    public String index(@PathVariable int num, Model model) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            res += i;
        }
        model.addAttribute("msg", "test: " + res);
        return "index";
    }
}