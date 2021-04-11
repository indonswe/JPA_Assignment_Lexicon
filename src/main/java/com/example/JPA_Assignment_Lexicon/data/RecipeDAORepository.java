package com.example.JPA_Assignment_Lexicon.data;

import com.example.JPA_Assignment_Lexicon.entity.Ingredient;
import com.example.JPA_Assignment_Lexicon.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
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
    @Transactional
    public Recipe findByRecipeName(String recipeName) {

        List<Recipe> answer = new ArrayList();
        Recipe name = null;
        answer = em
                .createQuery("SELECT s FROM Recipe s WHERE UPPER(s.recipeName) = UPPER(?1)", Recipe.class)
                .setParameter(1,recipeName)
                .getResultList();

        for (Recipe i :answer) {
            name = i;
        }

        return name;
        /*List<Ingredient> answer = new ArrayList();
        Ingredient name = null;
        answer = em
                .createQuery("SELECT s FROM Ingredient s WHERE UPPER(s.ingredientName) = UPPER(?1)", Ingredient.class)
                .setParameter(1,ingredientName)
                .getResultList();


        for (Ingredient i :answer) {
            name = i;
        }

        return name;*/
    }

    @Override
    public Recipe update(Recipe recipe) {
        return null;
    }

    @Override
    public void delete(Integer recipeId) {

    }

    @Override
    @Transactional
    public Collection<Recipe> findAllRecipesContainingIngredient(String ingredientName) {
        Collection<Recipe> answer = new ArrayList();
        answer = em.createQuery("SELECT s FROM Recipe s WHERE UPPER(s.ingredientName) = UPPER(?1)", Recipe.class)
                .setParameter(1,ingredientName)
                .getResultList();
        /*answer = em
                .createQuery("SELECT s FROM Recipe s WHERE UPPER(s.ingredientName) = UPPER(?1)", Recipe.class)
                .setParameter(1,ingredientName)
                .getResultList();*/
        /*Book book = entityManager.createQuery("""
    select b
    from Book b
    where b.isbn = :isbn
    """,
                Book.class)
                .setParameter("isbn", "978-9730228236")
                .getSingleResult();

        answer = em
                .createQuery("SELECT s FROM Recipe s WHERE UPPER(s.ingredientName) = UPPER(?1)", Recipe.class)
                .setParameter(1,ingredientName)
                .getResultList();*/

        return answer;

    }

    @Override
    public Collection<Recipe> findAllRecipesOfCategory() {
        return null;
    }

}
