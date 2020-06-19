package com.cocktailbar.cocktailbar.repository;

import com.cocktailbar.cocktailbar.entity.Cocktail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepoJPA extends JpaRepository<Cocktail, Long> {
    Cocktail findByStrDrink(String name);
}
