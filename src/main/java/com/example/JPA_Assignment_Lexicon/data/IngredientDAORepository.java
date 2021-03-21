package com.example.JPA_Assignment_Lexicon.data;

import com.example.JPA_Assignment_Lexicon.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class IngredientDAORepository implements IngredientDAO {

    private final EntityManager em;

    @Autowired
    public IngredientDAORepository(EntityManager em){
        this.em = em;
    }


    @Override
    @Transactional
    public Ingredient create(Ingredient ingredient) {
        return ingredient;
    }

    @Override
    public Ingredient findByName(String ingredient) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Ingredient findById(Integer ingredientId) {

return em.find(Ingredient.class,ingredientId);

            //return em.find(Student.class, studentId);

    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        return null;
    }

    @Override
    public void delete(Integer ingredientId) {

    }
}
