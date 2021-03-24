package com.example.JPA_Assignment_Lexicon.data;

import com.example.JPA_Assignment_Lexicon.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        em.persist(ingredient);
        return ingredient;
    }
    @Override
    @Transactional
    public Ingredient findByName(String ingredientName) {

        //return em.find(Ingredient.class,ingredientName);
        List<Ingredient> answer = new ArrayList();
        Ingredient name = null;
         answer = em
                .createQuery("SELECT s FROM Ingredient s WHERE UPPER(s.ingredientName) = UPPER(?1)", Ingredient.class)
                .setParameter(1,ingredientName)
                .getResultList();


         for (Ingredient i :answer) {
             name = i;
         }

         return name;

        /*return em
                .createQuery("SELECT s FROM Student s WHERE UPPER(s.lastName) = UPPER(?1)", Student.class)
                .setParameter(1, lastName)
                .getResultList();*/
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
