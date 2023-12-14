package com.example.wordReminder.repository;

import com.example.wordReminder.model.Words;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends MongoRepository<Words,Long> {
}
