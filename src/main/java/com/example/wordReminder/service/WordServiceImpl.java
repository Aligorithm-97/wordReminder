package com.example.wordReminder.service;

import com.example.wordReminder.model.Words;
import com.example.wordReminder.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {
    private static final Logger logger = LoggerFactory.getLogger(WordService.class);
    private final WordRepository wordRepository;
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.host}")
    private String host;

    @Override
    public void addWord(Words words) {
        wordRepository.insert(words);
    }

    @Override
    public List<Words> getWords() {
        return wordRepository.findAll();
    }

    @Override
    public void remindWordsThroughEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(host);
        message.setTo("alitemurtas1997@gmail.com");
        message.setSubject("WordReminder");
        List<Words> all = wordRepository.findAll();
        Set<Number> wordRowNumber = new HashSet<>();
        List<Words> wordsAll = new ArrayList<>();
        List<String> wordStrings = new ArrayList<>();
        Random r = new Random();
        int size = all.size();
        for (int i = 0; i < 20; i++) {
            int result = r.nextInt(size);
            wordRowNumber.add(result);
        }
        for (int i = 0; i < wordRowNumber.size(); i++) {
            Words words = all.get((int) wordRowNumber.toArray()[i]);
            wordsAll.add(words);
        }
        for (Words words : wordsAll) {
            wordStrings.add(words.getWord()+" = "+words.getMeaningOfTheWord()+"<br/>");
        }
        message.setText(wordStrings.toString().replace("["," ").replace("]"," "));
        javaMailSender.send(message);
    }
}
