package com.example.Twitter.controller;
import com.example.Twitter.model.TwitterInformation;
import com.example.Twitter.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    @Autowired
    TwitterService twitterService;
    Twitter twitter= TwitterFactory.getSingleton();

    @GetMapping("/gettimeline")
    public List<TwitterInformation> getFeed() throws TwitterException
    {
        return twitterService.getMessage(twitter);
    }
    @PostMapping( "/postMessage/{postMessage}")
    public String postTweet(@PathVariable(value = "postMessage") String postMessage) {
        return twitterService.tweetPost(twitter,postMessage);
    }
    @GetMapping("/gettimelines")
    @Cacheable(value = "gettimelines")
    public List<TwitterInformation> getTimeLines() throws TwitterException {
        System.out.println("GetTimeLines Cache will exist for 1 minute");
        return twitterService.getTimelines(twitter);
    }
    @GetMapping("/get")
    public List<TwitterInformation> getTimeLineFilter() throws TwitterException {
        System.out.println("hiiii");
        return twitterService.getTimeLineFilter(twitter);
    }
    @PostMapping("/post")
    public HashMap<String,TwitterInformation> postingMsg(@RequestBody List<TwitterInformation> twitterInformations) throws TwitterException {
        return twitterService.postingMsg(twitterInformations);
    }

}
