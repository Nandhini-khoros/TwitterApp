package com.example.Twitter.service;
import com.example.Twitter.dao.TwitterDao;
import com.example.Twitter.model.TwitterInformation;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TwitterService {

    TwitterDao twitterDao = new TwitterDao();
    public List<TwitterInformation> getMessage(Twitter twitter) throws TwitterException {

        return  twitterDao.getTimeLineMessage(twitter);


    }
    public String tweetPost(Twitter twitter,String postMessage)
    {
        return twitterDao.postMessage(twitter,postMessage);
    }

    public List<TwitterInformation> getTimeLineFilter(Twitter twitter) throws TwitterException {
         List<TwitterInformation> twitterInformations = twitterDao.getTimeLineFilter(twitter);

        //Foreach method:
            //getTimelineinfo.stream().filter(s->s.getName().startsWith("S")).forEach(System.out::println);
            //Using Limit:
            //getTimelineinfo.stream().filter(s->s.getName().startsWith("S")).limit(2).forEach(System.out::println);

         //Java streams: sorting and collect
        return  twitterInformations.stream().sorted(Comparator.comparing(TwitterInformation::getName)).collect(Collectors.toList());
        //Using Parallel stream:
        //return  twitterInformations.parallelStream().sorted(Comparator.comparing(TwitterInformation::getName)).collect(Collectors.toList());

        //Java streams: filter and collect
            //return twitterInformations.stream().filter(s->s.getName().startsWith("S")).limit(2).collect(Collectors.toList());

    }
    //For java stream : map method
    public HashMap<String,TwitterInformation> postingMsg(List<TwitterInformation> data) throws TwitterException {
        HashMap<String,TwitterInformation> informationHashMap = new HashMap<>();
        List<String> userNames = data.stream().map(item -> {
            informationHashMap.put(item.getScreenName(),item);
            return item.getScreenName();
        }).collect(Collectors.toList());
        return informationHashMap;
    }
}
