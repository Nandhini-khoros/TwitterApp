package com.example.Twitter.service;
import com.example.Twitter.dao.TwitterDao;
import com.example.Twitter.model.TwitterInformation;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.List;

public class TwitterService {

    TwitterDao twitterDao = new TwitterDao();
    public List<TwitterInformation> getMessage(Twitter twitter) throws TwitterException {
        return twitterDao.getTimeLineMessage(twitter);
    }
    public String tweetPost(Twitter twitter,String postMessage)
    {
        return twitterDao.postMessage(twitter,postMessage);
    }
}
