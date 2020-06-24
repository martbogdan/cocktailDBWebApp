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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    private static final String API_BASE_URL = "https://www.thecocktaildb.com";
    private static final String DRINK_FIND = "/api/json/v1/1/search.php";
    private static final String SEARCH_NAME = "?s=";

    @Autowired
    CocktailService cocktailService;

    //private List<Cocktail> cocktailList = new ArrayList<>();

    @GetMapping("/search")
    public String getSearchPage(Model model){
        model.addAttribute("cocktailsjson", cocktailService.getAll());
        return "search_page";
    }

    @GetMapping("/search/found")
    public String getSearchPage( @RequestParam String drinkname, Model model) {
        cocktailService.clearTmpDB();
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("cocktailsjson", cocktailService.getAll());
        return "redirect:/search";
    }

}
