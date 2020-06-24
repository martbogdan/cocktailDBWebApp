package com.cocktailbar.cocktailbar.controller;

import com.cocktailbar.cocktailbar.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private CocktailService cocktailService;

    @Autowired
    public MainController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("cocktails", cocktailService.getAllViewed());
        return "index";
    }

    @GetMapping("/clear")
    public String getMAinPageClear(Model model) {
        if (cocktailService.getAllViewed().size() > 0) {
            cocktailService.clearHistory();
        }
        return "redirect:/";
    }
}
