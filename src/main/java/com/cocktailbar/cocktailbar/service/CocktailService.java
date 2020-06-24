package com.cocktailbar.cocktailbar.service;

import com.cocktailbar.cocktailbar.entity.Cocktail;
import com.cocktailbar.cocktailbar.repository.CocktailRepo;
import com.cocktailbar.cocktailbar.repository.CocktailRepoJPA;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CocktailService {

    private final CocktailRepo cocktailRepo;

    @Autowired
    public CocktailService(@Qualifier("tempDB") CocktailRepo cocktailRepo) {
        this.cocktailRepo = cocktailRepo;
    }

    public void addCocktail(Cocktail cocktail) {
        cocktailRepo.insertCocktail(cocktail);
    }

    public void addCocktailToViewed(Cocktail cocktail) {
        cocktailRepo.addToViewed(cocktail);
    }

    public Cocktail getCocktailById(Long id) {
        return cocktailRepo.getCocktailById(id);
    }

    public void clearTmpDB() {
        cocktailRepo.clearList();
    }

    public List<Cocktail> getAll() {
        return cocktailRepo.getAll();
    }

    public List<Cocktail> getAllViewed() {
        return cocktailRepo.getAllViewed();
    }

    public Cocktail getFromJSON(JSONObject jsonDrink) {
        Cocktail cocktail = new Cocktail();

        cocktail.setIdDrink(Long.parseLong(jsonDrink.getString("idDrink")));
        cocktail.setStrDrink(jsonDrink.getString("strDrink"));
        cocktail.setStrAlcoholic(jsonDrink.getString("strAlcoholic"));
        cocktail.setStrGlass(jsonDrink.getString("strGlass"));
        cocktail.setInstructions(jsonDrink.getString("strInstructions"));
        cocktail.setStrDrinkThumb(jsonDrink.getString("strDrinkThumb"));
        cocktail.setStrCategory(jsonDrink.getString("strCategory"));

        cocktail.setIngredient1(jsonDrink.get("strIngredient1") != null ? String.valueOf(jsonDrink.get("strIngredient1")) : null);
        cocktail.setIngredient2(jsonDrink.get("strIngredient2") != null ? String.valueOf(jsonDrink.get("strIngredient2")) : null);
        cocktail.setIngredient3(jsonDrink.get("strIngredient3") != null ? String.valueOf(jsonDrink.get("strIngredient3")) : null);
        cocktail.setIngredient4(jsonDrink.get("strIngredient4") != null ? String.valueOf(jsonDrink.get("strIngredient4")) : null);
        cocktail.setIngredient5(jsonDrink.get("strIngredient5") != null ? String.valueOf(jsonDrink.get("strIngredient5")) : null);
        cocktail.setIngredient6(jsonDrink.get("strIngredient6") != null ? String.valueOf(jsonDrink.get("strIngredient6")) : null);
        cocktail.setIngredient7(jsonDrink.get("strIngredient7") != null ? String.valueOf(jsonDrink.get("strIngredient7")) : null);
        cocktail.setIngredient8(jsonDrink.get("strIngredient8") != null ? String.valueOf(jsonDrink.get("strIngredient8")) : null);
        cocktail.setIngredient9(jsonDrink.get("strIngredient9") != null ? String.valueOf(jsonDrink.get("strIngredient9")) : null);
        cocktail.setIngredient10(jsonDrink.get("strIngredient10") != null ? String.valueOf(jsonDrink.get("strIngredient10")) : null);
        cocktail.setIngredient11(jsonDrink.get("strIngredient11") != null ? String.valueOf(jsonDrink.get("strIngredient11")) : null);
        cocktail.setIngredient12(jsonDrink.get("strIngredient12") != null ? String.valueOf(jsonDrink.get("strIngredient12")) : null);
        cocktail.setIngredient13(jsonDrink.get("strIngredient13") != null ? String.valueOf(jsonDrink.get("strIngredient13")) : null);
        cocktail.setIngredient14(jsonDrink.get("strIngredient14") != null ? String.valueOf(jsonDrink.get("strIngredient14")) : null);
        cocktail.setIngredient15(jsonDrink.get("strIngredient15") != null ? String.valueOf(jsonDrink.get("strIngredient15")) : null);

        cocktail.setMeasure1(jsonDrink.get("strMeasure1") != null ? String.valueOf(jsonDrink.get("strMeasure1")) : null);
        cocktail.setMeasure2(jsonDrink.get("strMeasure2") != null ? String.valueOf(jsonDrink.get("strMeasure2")) : null);
        cocktail.setMeasure3(jsonDrink.get("strMeasure3") != null ? String.valueOf(jsonDrink.get("strMeasure3")) : null);
        cocktail.setMeasure4(jsonDrink.get("strMeasure4") != null ? String.valueOf(jsonDrink.get("strMeasure4")) : null);
        cocktail.setMeasure5(jsonDrink.get("strMeasure5") != null ? String.valueOf(jsonDrink.get("strMeasure5")) : null);
        cocktail.setMeasure6(jsonDrink.get("strMeasure6") != null ? String.valueOf(jsonDrink.get("strMeasure6")) : null);
        cocktail.setMeasure7(jsonDrink.get("strMeasure7") != null ? String.valueOf(jsonDrink.get("strMeasure7")) : null);
        cocktail.setMeasure8(jsonDrink.get("strMeasure8") != null ? String.valueOf(jsonDrink.get("strMeasure8")) : null);
        cocktail.setMeasure9(jsonDrink.get("strMeasure9") != null ? String.valueOf(jsonDrink.get("strMeasure9")) : null);
        cocktail.setMeasure10(jsonDrink.get("strMeasure10") != null ? String.valueOf(jsonDrink.get("strMeasure10")) : null);
        cocktail.setMeasure11(jsonDrink.get("strMeasure11") != null ? String.valueOf(jsonDrink.get("strMeasure11")) : null);
        cocktail.setMeasure12(jsonDrink.get("strMeasure12") != null ? String.valueOf(jsonDrink.get("strMeasure12")) : null);
        cocktail.setMeasure13(jsonDrink.get("strMeasure13") != null ? String.valueOf(jsonDrink.get("strMeasure13")) : null);
        cocktail.setMeasure14(jsonDrink.get("strMeasure14") != null ? String.valueOf(jsonDrink.get("strMeasure14")) : null);
        cocktail.setMeasure15(jsonDrink.get("strMeasure15") != null ? String.valueOf(jsonDrink.get("strMeasure15")) : null);
        return cocktail;
    }

    public List<IngredientMeasure> getIngredientMeasures(Cocktail cocktail) {
        List<IngredientMeasure> list = new ArrayList<>();
        list.add(new IngredientMeasure(cocktail.getIngredient1(), cocktail.getMeasure1()));
        list.add(new IngredientMeasure(cocktail.getIngredient2(), cocktail.getMeasure2()));
        list.add(new IngredientMeasure(cocktail.getIngredient3(), cocktail.getMeasure3()));
        list.add(new IngredientMeasure(cocktail.getIngredient4(), cocktail.getMeasure4()));
        list.add(new IngredientMeasure(cocktail.getIngredient5(), cocktail.getMeasure5()));
        list.add(new IngredientMeasure(cocktail.getIngredient6(), cocktail.getMeasure6()));
        list.add(new IngredientMeasure(cocktail.getIngredient7(), cocktail.getMeasure7()));
        list.add(new IngredientMeasure(cocktail.getIngredient8(), cocktail.getMeasure8()));
        list.add(new IngredientMeasure(cocktail.getIngredient9(), cocktail.getMeasure9()));
        list.add(new IngredientMeasure(cocktail.getIngredient10(), cocktail.getMeasure10()));
        list.add(new IngredientMeasure(cocktail.getIngredient11(), cocktail.getMeasure11()));
        list.add(new IngredientMeasure(cocktail.getIngredient12(), cocktail.getMeasure12()));
        list.add(new IngredientMeasure(cocktail.getIngredient13(), cocktail.getMeasure13()));
        list.add(new IngredientMeasure(cocktail.getIngredient14(), cocktail.getMeasure14()));
        list.add(new IngredientMeasure(cocktail.getIngredient15(), cocktail.getMeasure15()));

        list.removeIf(ingredientMeasure -> ingredientMeasure.getIngredient().equals("null"));
        return list;
    }

    public class IngredientMeasure {
        private String ingredient;
        private String measure;

        public IngredientMeasure(String ingredient, String measure) {
            this.ingredient = ingredient;
            if (!ingredient.equals("null") && measure.equals("null")) {
                this.measure = "";
            } else {
                this.measure = measure;
            }
        }

        public String getIngredient() {
            return ingredient;
        }

        public String getMeasure() {
            return measure;
        }
    }
}
