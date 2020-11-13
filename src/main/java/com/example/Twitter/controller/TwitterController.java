package com.example.Twitter.controller;
import com.example.Twitter.service.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    @Value("${demo.consumerKey}")
    String consumerKey;
    @Value("${demo.consumerSecret}")
    String consumerSecret;
    @Value("${demo.accessToken}")
    String accessToken;
    @Value("${demo.accessTokenSecret}")
    String accessTokenSecret;



    public Twitter getTwitterInstance()
    {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);

        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        Twitter twitter = twitterFactory.getInstance();
        return twitter;
    }

    TwitterService twitterService =  new TwitterService();


    @GetMapping(value = "/gettimeline")
    public List<String> getFeed() throws TwitterException
    {
        Twitter  twitter = getTwitterInstance();
        return twitterService.getTimeLineMessage(twitter);
    }
    @PostMapping(value = "/postMessage/{postMessage}")
    public String postTweet(@PathVariable(value = "postMessage") String postMessage) {
        Twitter twitter = getTwitterInstance();
        return twitterService.postMessage(twitter,postMessage);

    }
}
