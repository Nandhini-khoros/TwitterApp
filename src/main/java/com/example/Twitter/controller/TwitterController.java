package com.example.Twitter.controller;
import com.example.Twitter.service.TwitterService;
import org.springframework.web.bind.annotation.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.List;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    Twitter twitter= TwitterFactory.getSingleton();
    TwitterService twitterService =  new TwitterService();
    @GetMapping("/gettimeline")
    public List<String> getFeed() throws TwitterException
    {

        return twitterService.getMessage(twitter);
    }
    @PostMapping( "/postMessage/{postMessage}")
    public String postTweet(@PathVariable(value = "postMessage") String postMessage) {
        return twitterService.tweetPost(twitter,postMessage);

    }
}
