package com.example.wordReminder;

import com.example.wordReminder.model.Words;
import com.example.wordReminder.repository.WordRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WordReminderApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordReminderApplication.class, args);
	}
//	@Bean
//	CommandLineRunner runner(WordRepository repository){
//		return args -> {
//			Words words =new Words();
//			words.setWord("Der Unfall");
//			words.setMeaningOfTheWord("Kaza");
//			repository.insert(words);
//		};
//	}

}
