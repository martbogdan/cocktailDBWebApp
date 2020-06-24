package com.cocktailbar.cocktailbar.repository;

import com.cocktailbar.cocktailbar.entity.Cocktail;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("tempDB")
public class CocktailTempDB implements CocktailRepo{

    private static List<Cocktail> cocktailsTMPDB = new ArrayList<>();
    private static List<Cocktail> viewedCocktails = new ArrayList<>();

    @Override
    public void insertCocktail(Cocktail cocktail) {
        cocktailsTMPDB.add(cocktail);
    }

    @Override
    public void addToViewed(Cocktail cocktail) {
        if (!viewedCocktails.contains(cocktail)) {
            viewedCocktails.add(cocktail);
        }
    }

    @Override
    public Cocktail getCocktailById(Long id) {
        return cocktailsTMPDB.stream()
                .filter(cocktail -> cocktail.getIdDrink().equals(id))
                .findAny().orElse(null);
    }

    @Override
    public void clearList() {
        cocktailsTMPDB.clear();
    }

    @Override
    public List<Cocktail> getAll() {
        return cocktailsTMPDB;
    }

    @Override
    public List<Cocktail> getAllViewed() {
        return viewedCocktails;
    }
}
