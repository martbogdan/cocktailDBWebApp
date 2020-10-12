package com.cocktailbar.cocktailbar.repository;

import com.cocktailbar.cocktailbar.entity.Cocktail;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

@Repository("tempDB")
public class CocktailTempDB implements CocktailRepo{
    private static final int MAX_VIEWED_LIST_SIZE = 9;
    private static List<Cocktail> cocktailsTMPDB = new ArrayList<>();
    private static LinkedList<Cocktail> viewedCocktails = new LinkedList<>();

    @Override
    public void insertCocktail(Cocktail cocktail) {
        cocktailsTMPDB.add(cocktail);
    }

    @Override
    public void addToViewed(Cocktail cocktail) {
        if (!viewedCocktails.contains(cocktail)) {
            if (viewedCocktails.size() < MAX_VIEWED_LIST_SIZE) {
                viewedCocktails.add(cocktail);
            } else {
                viewedCocktails.removeFirst();
                viewedCocktails.addLast(cocktail);
            }
        }
    }

    @Override
    public Cocktail getCocktailById(Long id) {
        return cocktailsTMPDB.stream()
                .filter(cocktail -> cocktail.getIdDrink().equals(id))
                .findAny().orElseThrow(() -> new EntityNotFoundException("Drink with id: " + id + " not found"));
    }

    @Override
    public void clearList() {
        cocktailsTMPDB.clear();
    }

    public void clearHistory() {
        viewedCocktails.clear();
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
