package com.example.JPA_Assignment_Lexicon.data;

import com.example.JPA_Assignment_Lexicon.entity.Ingredient;
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

class IngredientDAORepositoryTest {

    @Autowired
    private IngredientDAO testObject;
    @Autowired private TestEntityManager em;

    private Ingredient persistedIngredient;

    @BeforeEach
    void setUp() {
        Ingredient unpersisted = new Ingredient(null,"Deca-durabolin");
        persistedIngredient = em.persistAndFlush(unpersisted);
    }

    @AfterEach
    void tearDown() {
        em.flush();
    }

    @Test
    void create() {
        Ingredient ing = new Ingredient(null,"Peppar");
        Ingredient result = testObject.create(ing);
        assertNotNull(result);
        assertNotNull(result.getIngredientId());

    }

    @Test
    void findByName() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    /*@Autowired
    private BookDAO testObject;
    @Autowired private TestEntityManager em;

    private Book persistedBook;

    @BeforeEach
    void setUp() {
        Book unpersisted = new Book(null,"Karl", "Marxx", 333);
        persistedBook = em.persistAndFlush(unpersisted);
    }

    @AfterEach
    void tearDown() {
        em.flush();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
        Book book = new Book(null,"Karl", "Marxx", 5);

        Book result = testObject.create(book);
        assertNotNull(result);
        assertNotNull(result.getBookId());
    }*/
}