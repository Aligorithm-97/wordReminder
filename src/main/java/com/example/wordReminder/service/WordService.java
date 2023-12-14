package com.example.wordReminder.service;

import com.example.wordReminder.model.Words;

import java.util.List;

public interface WordService  {
    void addWord(Words words);

    List<Words> getWords();

    void remindWordsThroughEmail();
}
