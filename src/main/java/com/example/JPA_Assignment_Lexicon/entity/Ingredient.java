package com.example.JPA_Assignment_Lexicon.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ingredientId;
    private String ingredientName;

    public Ingredient(Integer ingredientId,
                      String ingredientName) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
    }



        /*private int appUserId;
        //@Column(unique = true)
        private String username;
        private String password;
        private LocalDate regDate;
        //@OneToOne(cascade = CascadeType.ALL)
        //@JoinColumn(name = "details_id", table = "app_user")
        //private Details userDetails;
        */
}
