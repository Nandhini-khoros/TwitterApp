package com.example.Twitter.service;
import com.example.Twitter.dao.GetPost;
import com.example.Twitter.dao.TwitterDao;
import com.example.Twitter.dao.TwitterServiceInterface;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.List;

public class TwitterService {

    TwitterDao twitterDao = new TwitterDao();
    public List<String> getMessage(Twitter twitter) throws TwitterException {
        return twitterDao.getTimeLineMessage(twitter);
    }
    public String tweetPost(Twitter twitter,String postMessage)
    {
        return twitterDao.postMessage(twitter,postMessage);
    }
}
