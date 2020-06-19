package com.cocktailbar.cocktailbar.service;

import com.cocktailbar.cocktailbar.entity.Cocktail;
import com.cocktailbar.cocktailbar.repository.CocktailRepoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocktailService {
    private CocktailRepoJPA cocktailRepoJPA;

    @Autowired
    public CocktailService(CocktailRepoJPA cocktailRepoJPA) {
        this.cocktailRepoJPA = cocktailRepoJPA;
    }

    public List<Cocktail> getAll() {
        return cocktailRepoJPA.findAll();
    }

    public Cocktail getByName(String drinkName) {
        return cocktailRepoJPA.findByStrDrink(drinkName);
    }
}
