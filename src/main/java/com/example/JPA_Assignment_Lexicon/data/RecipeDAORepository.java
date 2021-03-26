package com.example.JPA_Assignment_Lexicon.data;

import com.example.JPA_Assignment_Lexicon.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

public class RecipeDAORepository implements RecipeDAO {
    private EntityManager em;
    @Autowired
    public RecipeDAORepository(EntityManager em){
        this.em = em;
    }

    @Override
    @Transactional
    public Recipe create(Recipe recipe) {
        em.persist(recipe);
        return recipe;
    }

    @Override
    public Recipe findById(Recipe recipeId) {
        return em.find(Recipe.class, recipeId);
    }

    @Override
    public Recipe findByRecipeName(String recipeName) {
        return null;
    }

    @Override
    public Recipe update(Recipe recipe) {
        return null;
    }

    @Override
    public void delete(Integer recipeId) {

    }

    @Override
    public Collection<Recipe> findAllRecipesContainingIngredient() {
        return null;
    }

    @Override
    public Collection<Recipe> findAllRecipesOfCategory() {
        return null;
    }
}
