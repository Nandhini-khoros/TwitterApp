package com.example.Twitter.dao;
import com.example.Twitter.TwitterType;
import com.example.Twitter.model.TwitterInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import javax.inject.Inject;
import java.util.List;

@Component
public class TwitterDao {
    @Autowired
    //@TwitterType("hello")
            //@Qualifier("hai")
    TwitterDaoInterface twitterDaoInterface;

    public List<TwitterInformation> getTimeLineMessage(Twitter twitter) throws TwitterException {
        return twitterDaoInterface.getTimeLine(twitter);
    }
    public String postMessage(Twitter twitter,String postMessage)
    {
        return twitterDaoInterface.postMsg(twitter,postMessage);
    }
    public List<TwitterInformation> getTimeLineFilter(Twitter twitter) throws TwitterException {
        return twitterDaoInterface.getTimeLineFilter(twitter);
    }


}
