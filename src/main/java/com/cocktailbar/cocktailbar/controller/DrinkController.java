package com.cocktailbar.cocktailbar.controller;

import com.cocktailbar.cocktailbar.entity.Cocktail;
import com.cocktailbar.cocktailbar.service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DrinkController {
    private final CocktailService cocktailService;

    @Autowired
    public DrinkController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("/drink/{id}")
    public String getDrinkInfoPage(@PathVariable("id") Long id, Model model) {
        Cocktail cocktail = cocktailService.getCocktailById(id);
        cocktailService.addCocktailToViewed(cocktail);
        model.addAttribute("ingredients", cocktailService.getIngredientMeasures(cocktail));
        model.addAttribute("cocktail", cocktail);
        return "drink_info";
    }
}
