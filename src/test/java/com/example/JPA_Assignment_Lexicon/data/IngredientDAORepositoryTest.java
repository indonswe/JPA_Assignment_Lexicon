package com.example.JPA_Assignment_Lexicon.data;

import com.example.JPA_Assignment_Lexicon.entity.Ingredient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @Autowired
    private TestEntityManager em;

    private Ingredient persistedIngredient;

    @BeforeEach
    void setUp() {
        Ingredient unpersisted = new Ingredient("Deca-durabolin");
        persistedIngredient = em.persistAndFlush(unpersisted);
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
    void findByName() {

        Ingredient DecaD = testObject.findByName("Deca-durabolin");
        String ingName = persistedIngredient.getIngredientName();
        //String ingName = persistedIngredient.getIngredientName();
        Ingredient result = testObject.findByName(ingName);
        assertNotNull(result);
        assertEquals(persistedIngredient, result);

    }

    @Test
    void findById() {
        Integer ingId = persistedIngredient.getIngredientId();
        Ingredient result = testObject.findById(ingId);
        assertNotNull(result);
        assertEquals(persistedIngredient, result);


       /* @Test
        @DisplayName("Given studentId findById should return entity")
        void findById() {
            Integer studentId = persistedStudent.getStudentId();

            Student result = testObject.findById(studentId);

            assertNotNull(result);
            assertEquals(persistedStudent, result);*/
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