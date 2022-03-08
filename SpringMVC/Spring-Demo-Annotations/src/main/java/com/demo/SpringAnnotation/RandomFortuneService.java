package com.demo.SpringAnnotation;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{


    private String[] data = {"Fortune favors the brave",
                             "Fortune favors the prepared mind",
                             "Behind every great fortune lies a great crime",
                             "Fortune befriends the bold"};


    Random myRandom = new Random();

    @Override
    public String getFortune() {
        int index = myRandom.nextInt(data.length);
        String fortune = data[index];
        return fortune;
    }
}
