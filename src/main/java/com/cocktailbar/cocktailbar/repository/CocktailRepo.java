package com.cocktailbar.cocktailbar.repository;

import com.cocktailbar.cocktailbar.entity.Cocktail;

import java.util.List;

public interface CocktailRepo {

    void insertCocktail(Cocktail cocktail);

    default void addCocktail(Cocktail cocktail) {
        insertCocktail(cocktail);
    }

    void addToViewed(Cocktail cocktail);

    Cocktail getCocktailById(Long id);

    void clearList();

    List<Cocktail> getAll();
    List<Cocktail> getAllViewed();
}
