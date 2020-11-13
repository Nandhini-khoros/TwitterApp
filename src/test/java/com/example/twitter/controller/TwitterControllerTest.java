/*package com.example.Twitter.controller;

import com.example.Twitter.controller.TwitterController;
import com.example.Twitter.service.TwitterService;
import com.example.Twitter.service.TwitterServiceInterface;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Collections;
import java.util.List;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(EasyMockRunner.class)
public class TwitterControllerTest {
    @Mock
    TwitterService twitterService;

    @TestSubject
    TwitterController twitterController = new TwitterController();

    @Mock
    Twitter twitter;


    @Test
    public void getTimeLineMessageTest() throws TwitterException {

        expect(twitterService.getTimeLineMessage(twitter)).andReturn(Collections.singletonList("Tweet from Timeline"));
        replay(twitterService);
        List<String> getTimeLineMsg =twitterController.getFeed(twitter);
        Assert.assertEquals(Collections.singletonList("Tweet from Timeline"),getTimeLineMsg);

    }
    @Test
    public void postTweetTest()throws TwitterException
    {

        expect(twitterService.postMessage(twitter,"Helllo")).andReturn("PostTweeted");
        replay(twitterService);
        String tweetMsg = twitterController.postTweet("Helllo");
        assertEquals("PostTweeted", tweetMsg);


    }

}*/