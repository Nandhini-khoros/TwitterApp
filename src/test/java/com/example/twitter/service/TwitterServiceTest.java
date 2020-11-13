package com.example.Twitter.service;

import com.example.Twitter.controller.TwitterController;
import com.example.Twitter.service.TwitterService;
import com.example.Twitter.service.TwitterServiceInterface;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(EasyMockRunner.class)
public class TwitterServiceTest {
    @Mock
    TwitterServiceInterface twitterServiceInterface;

    @TestSubject
    TwitterService twitterService = new TwitterService();

    @Mock
    Twitter twitter;



   @Test
    public void getTimeLineMessageTest() throws TwitterException {

       expect(twitterServiceInterface.getTimeLine(twitter)).andReturn(Collections.singletonList("Tweet from Timeline"));
       replay(twitterServiceInterface);
       List<String> getTimeLineMsg =twitterService.getTimeLineMessage(twitter);
       Assert.assertEquals(Collections.singletonList("Tweet from Timeline"),getTimeLineMsg);

    }



    @Test
    public void postMessageTest() throws TwitterException {

        expect(twitterServiceInterface.postMsg(twitter, "Hellloo")).andReturn("PostTweeted");
        replay(twitterServiceInterface);
        String tweet = twitterService.postMessage(twitter, "Hellloo");
        assertEquals("PostTweeted", tweet);

        

    }
}