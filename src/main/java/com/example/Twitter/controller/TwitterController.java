
package com.example.Twitter.controller;
        import org.springframework.web.bind.annotation.*;
        import twitter4j.Status;
        import twitter4j.Twitter;
        import twitter4j.TwitterException;
        import twitter4j.TwitterFactory;
        import java.util.List;

@RestController
@RequestMapping("/twitter")
public class TwitterController {
    Twitter twitter = TwitterFactory.getSingleton();

    @GetMapping("/gettimeline")
    public List<Status> getFeed() throws TwitterException
    {

        return twitter.getHomeTimeline();

    }
    @PostMapping( "/postMessage/{postMessage}")
    public Object postTweet(@PathVariable(value = "postMessage") String postMessage) {
        try {

            Status status = twitter.updateStatus(postMessage);
            return "Post Tweeted";
        }
        catch (TwitterException e)
        {
            e.printStackTrace();
            return "error";


        }

    }

}