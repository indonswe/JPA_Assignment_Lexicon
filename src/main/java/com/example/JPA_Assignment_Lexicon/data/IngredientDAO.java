package com.example.JPA_Assignment_Lexicon.data;

import com.example.JPA_Assignment_Lexicon.entity.Ingredient;

import java.util.Collection;

public interface IngredientDAO {
    Ingredient create(Ingredient ingredient);
    Ingredient findByName(String ingredient);
    Ingredient findById(Integer ingredient);
    Ingredient update(Ingredient ingredient);
    void delete(Integer ingredientId);
}
