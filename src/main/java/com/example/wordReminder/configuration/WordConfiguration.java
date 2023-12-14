package com.example.wordReminder.configuration;

import com.example.wordReminder.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class WordConfiguration {
    private final WordService wordService;

    @Scheduled(cron = "0 0 */1 * * ?")
    public void scheduledTask(){
        wordService.remindWordsThroughEmail();
        System.out.println("Words Sent!");
    }
//    @Scheduled(fixedDelay = 10_000)
//    public void scheduledTask2(){
//        wordService.remindWordsThroughEmail();
//        System.out.println("Words Sent!");
//    }
}
