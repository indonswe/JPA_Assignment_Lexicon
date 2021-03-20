package com.example.JPA_Assignment_Lexicon.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RecipeInstruction {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String recipeInstructionId;
    private String recipeInstruction;

    public RecipeInstruction(String recipeInstructionId,
                             String recipeInstruction) {
        this.recipeInstructionId = recipeInstructionId;
        this.recipeInstruction = recipeInstruction;
    }
}
