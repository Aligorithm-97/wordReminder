package com.example.wordReminder.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Words")
@Getter
@Setter
public class Words {
    @Id
    private String id;
    private String word;
    private String meaningOfTheWord;


}
