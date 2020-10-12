package com.cocktailbar.cocktailbar.controller;

import com.cocktailbar.cocktailbar.entity.Cocktail;
import com.cocktailbar.cocktailbar.service.CocktailService;
import com.cocktailbar.cocktailbar.service.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    private static final String API_BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1";
    private static final String DRINK_FIND = "/search.php";
    private static final String SEARCH_NAME = "?s=";
    private static final String DRINK_RANDOM = "/random.php";

    private final CocktailService cocktailService;

    @Autowired
    public SearchController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("/search")
    public String getSearchPage(Model model){
        model.addAttribute("cocktailsjson", cocktailService.getAll());
        return "search_page";
    }

    @GetMapping("/search/found")
    public String getSearchPage(@RequestParam String drinkname, Model model, RedirectAttributes attributes) {
        cocktailService.clearTmpDB();
        String message = "";
        model.addAttribute("drinkName", drinkname);
        JSONObject json;
        JSONArray jsonArray;
        try {
            json = JsonReader.readJsonFromUrl(API_BASE_URL + DRINK_FIND + SEARCH_NAME + drinkname);
            if (!json.isNull("drinks")) {
                jsonArray = json.getJSONArray("drinks");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonDrink = jsonArray.getJSONObject(i);
                    Cocktail cocktail = cocktailService.getFromJSON(jsonDrink);
                    cocktailService.addCocktail(cocktail);
                }
            } else {
                message = "Cocktails with name \'" + drinkname + "\' not found";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        attributes.addFlashAttribute("message", message);
        model.addAttribute("cocktailsjson", cocktailService.getAll());
        return "redirect:/search";
    }

    @GetMapping("/search/random")
    public String getDrinkRandom(Model model, RedirectAttributes attributes) {
        JSONObject json;
        JSONArray jsonArray;
        Cocktail cocktail = null;
        try {
            json = JsonReader.readJsonFromUrl(API_BASE_URL + DRINK_RANDOM);
            if (!json.isNull("drinks")) {
                jsonArray = json.getJSONArray("drinks");
                JSONObject jsonObject = jsonArray.getJSONObject(0);
                cocktail = cocktailService.getFromJSON(jsonObject);
                cocktailService.addCocktail(cocktail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/drink/" + cocktail.getIdDrink();
    }

}
