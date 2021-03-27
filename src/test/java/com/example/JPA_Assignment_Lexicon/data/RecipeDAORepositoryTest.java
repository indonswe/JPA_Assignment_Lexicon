package com.example.JPA_Assignment_Lexicon.data;

import com.example.JPA_Assignment_Lexicon.entity.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureTestEntityManager
@Transactional
@DirtiesContext

class RecipeDAORepositoryTest {

    @Autowired
    private RecipeDAO testObject;
    @Autowired
    private TestEntityManager em;

    private Ingredient persistedIngredient;


    @BeforeEach
    void setUp() {
        Ingredient unpersisted = new Ingredient("Deca-durabolin");
        persistedIngredient = em.persistAndFlush(unpersisted);
        Recipe recipe = new Recipe();
        RecipeCategory recipeCategory = new RecipeCategory();
        RecipeIngredient recipeIngredient = new RecipeIngredient(5.0,unpersisted,recipe);
        //public RecipeIngredient(double amount, Measurement measurement, Ingredient ingredient, Recipe recipe) {

            RecipeInstruction recipeInstruction =
                new RecipeInstruction("Put everything together and hope for the best");
    }

    @AfterEach
    void tearDown() {
        em.flush();
    }

    @Test
    void create() {
        Ingredient ing = new Ingredient("Peppar");
        Ingredient result = testObject.create(ing);
        assertNotNull(result);
        assertNotNull(result.getIngredientId());

    }

    @Test
    void findById() {
    }

    @Test
    void findByRecipeName() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void findAllRecipesContainingIngredient() {
    }

    @Test
    void findAllRecipesOfCategory() {
    }
}