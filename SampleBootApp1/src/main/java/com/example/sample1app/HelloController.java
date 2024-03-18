package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
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
    public ModelAndView index(@PathVariable int num,
            ModelAndView mav) {
        int total = 0;
        for (int i = 1; i <= num; i++) {
            total += i;
        }
        mav.addObject("msg", num + "までの合計を計算します。");
        mav.addObject("content", "total: " + total);
        mav.setViewName("index");
        return mav;
    }
}