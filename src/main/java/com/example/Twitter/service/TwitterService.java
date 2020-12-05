package com.example.Twitter.service;
import com.example.Twitter.dao.TwitterDao;
import com.example.Twitter.model.TwitterInformation;
import org.springframework.stereotype.Service;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import javax.inject.Inject;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterService {

    @Inject
    TwitterDao twitterDao;

    public List<TwitterInformation> getMessage(Twitter twitter) throws TwitterException {
        return  twitterDao.getTimeLineMessage(twitter);
    }
    public String tweetPost(Twitter twitter,String postMessage)
    {
        return twitterDao.postMessage(twitter,postMessage);
    }
    public List<TwitterInformation> getTimeLineFilter(Twitter twitter) throws TwitterException {
         List<TwitterInformation> twitterInformations = twitterDao.getTimeLineFilter(twitter);
        return  twitterInformations.stream().sorted(Comparator.comparing(TwitterInformation::getName)).collect(Collectors.toList());
    }
    public HashMap<String,TwitterInformation> postingMsg(List<TwitterInformation> data) throws TwitterException {
        HashMap<String,TwitterInformation> informationHashMap = new HashMap<>();
        List<String> userNames = data.stream().map(item -> {
            informationHashMap.put(item.getScreenName(),item);
            return item.getScreenName();
        }).collect(Collectors.toList());
        return informationHashMap;
    }
    public  List<TwitterInformation> getTimelines(Twitter twitter) throws TwitterException {
        return twitterDao.getTimelines(twitter);
    }
}
