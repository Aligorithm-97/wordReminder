package com.example.wordReminder.controller;

import com.example.wordReminder.model.Words;
import com.example.wordReminder.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/word")
@RequiredArgsConstructor
public class WordsController {
    private final WordService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/add")
    public String addWord(@RequestBody Words words) {
        service.addWord(words);
        return "ok";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getAll")
    public List<Words> getWords() {
        return  service.getWords();
    }
}
