package com.cocktailbar.cocktailbar.controller;

import com.cocktailbar.cocktailbar.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("cocktails", cocktailService.getAll());
        return "index";
    }
}
