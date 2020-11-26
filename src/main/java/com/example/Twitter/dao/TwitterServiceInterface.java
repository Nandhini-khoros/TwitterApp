package com.example.Twitter.dao;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.List;

public interface TwitterServiceInterface {

    List<String> getTimeLine(Twitter twitter) throws TwitterException;
    String postMsg(Twitter twitter,String postMessage);
}
