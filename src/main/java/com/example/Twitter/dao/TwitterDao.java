package com.example.Twitter.dao;

import com.example.Twitter.model.TwitterInformation;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;

public class TwitterDao {

    TwitterDaoInterface getPost =  new GetPost();
    public List<TwitterInformation> getTimeLineMessage(Twitter twitter) throws TwitterException {
        return getPost.getTimeLine(twitter);
    }
    public String postMessage(Twitter twitter,String postMessage)
    {
        return getPost.postMsg(twitter,postMessage);
    }
}
