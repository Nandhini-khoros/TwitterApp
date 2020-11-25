package com.example.Twitter.service;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.ArrayList;
import java.util.List;


public class GetPost implements TwitterServiceInterface{
    public GetPost() {
    }

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
            e.printStackTrace();
            return "error";
        }
    }
}
