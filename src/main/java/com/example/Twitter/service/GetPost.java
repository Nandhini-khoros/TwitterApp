package com.example.Twitter.service;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.ArrayList;
import java.util.List;


public class GetPost implements TwitterServiceInterface{
    Logger logger = Logger.getLogger(GetPost.class);
    public List<String> getTimeLine(Twitter twitter) throws TwitterException {
        List<String> a = new ArrayList<>();
        List<Status> s=twitter.getHomeTimeline();
        for(Status sa : s){
            a.add(sa.getText());
        }
        return a;
    }
    public String postMsg(Twitter twitter, String postMessage)
    {
        try {

            Status status = twitter.updateStatus(postMessage);
            return "Post Tweeted";
        }
        catch (TwitterException e)
        {
            logger.error(String.valueOf(e));
            e.printStackTrace();
            return "error";
        }
    }
}
