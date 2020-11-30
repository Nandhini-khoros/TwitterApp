package com.example.Twitter.dao;

import com.example.Twitter.model.TwitterInformation;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.UserList;

import java.util.HashMap;
import java.util.List;

public interface TwitterDaoInterface {

    List<TwitterInformation> getTimeLine(Twitter twitter) throws TwitterException;
    String postMsg(Twitter twitter,String postMessage);

    List<TwitterInformation> getTimeLineFilter(Twitter twitter) throws TwitterException;


}
