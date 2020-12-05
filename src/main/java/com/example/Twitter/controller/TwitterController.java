package com.example.Twitter.controller;
import com.example.Twitter.service.TwitterService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import java.util.List;

@RestController
@RequestMapping("/twitter")
public class TwitterController {

    Logger logger = Logger.getLogger(TwitterController.class);
    TwitterService twitterService =  new TwitterService();
    Twitter twitter = TwitterFactory.getSingleton();

    @GetMapping("/gettimeline")
    public List<String> getFeed() throws TwitterException
    {
      logger.warn("getfeed");
        return twitterService.getTimeLineMessage(this.twitter);
    }
    @PostMapping( "/postMessage/{postMessage}")
    public String postTweet(@PathVariable(value = "postMessage") String postMessage) {
        return twitterService.postMessage(twitter,postMessage);

    }

}
