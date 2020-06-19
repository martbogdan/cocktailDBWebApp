package com.cocktailbar.cocktailbar.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "cocktails")
public class Cocktail {
    @Id
    Long idDrink;
    String strDrink;
    String strDrinkAlternate;
    String strDrinkES;
    String strDrinkDE;
    String strDrinkFR;
    String strDrinkZH_HANS;
    String strDrinkZH_HANT;
    String strTags;
    @Column(length = 255000)
    String strVideo;
    String strCategory;
    String strIBA;
    String strAlcoholic;
    String strGlass;
    @Column(length = 1000000)
    String instructions;
    @Column(length = 1000000)
    String instructionsES;
    @Column(length = 1000000)
    String instructionsDE;
    @Column(length = 1000000)
    String instructionsFR;
    @Column(length = 1000000)
    String instructionsZH_HANS;
    @Column(length = 1000000)
    String instructionsZH_HANT;
    @Column(length = 255000)
    String strDrinkThumb;
    String ingredient1;
    String ingredient2;
    String ingredient3;
    String ingredient4;
    String ingredient5;
    String ingredient6;
    String ingredient7;
    String ingredient8;
    String ingredient9;
    String ingredient10;
    String ingredient11;
    String ingredient12;
    String ingredient13;
    String ingredient14;
    String ingredient15;
    String measure1;
    String measure2;
    String measure3;
    String measure4;
    String measure5;
    String measure6;
    String measure7;
    String measure8;
    String measure9;
    String measure10;
    String measure11;
    String measure12;
    String measure13;
    String measure14;
    String measure15;
    String strCreativeCommonsConfirmed;
    LocalDateTime dateModified;
}
