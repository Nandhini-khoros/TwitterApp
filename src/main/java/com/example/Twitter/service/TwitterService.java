package com.example.Twitter.service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.List;

public class TwitterService {

    TwitterServiceInterface getPost =  new GetPost();
    public List<String> getTimeLineMessage(Twitter twitter) throws TwitterException {
        return getPost.getTimeLine(twitter);
    }
    public String postMessage(Twitter twitter,String postMessage)
    {
        return getPost.postMsg(twitter,postMessage);
    }
}
