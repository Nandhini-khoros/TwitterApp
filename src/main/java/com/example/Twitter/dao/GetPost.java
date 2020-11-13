package com.example.Twitter.dao;

import com.example.Twitter.model.TwitterInformation;
import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetPost implements TwitterDaoInterface {
    public List<TwitterInformation> getTimeLine(Twitter twitter) throws TwitterException {

        List<TwitterInformation> getTimelineinfo = new ArrayList<>();
        List<Status> getTimeLine = twitter.getHomeTimeline();
        for (Status sa : getTimeLine) {
            TwitterInformation twitterInformation = new TwitterInformation(sa.getText(),  sa.getId(),sa.getCreatedAt(), sa.getUser().getProfileImageURL(), sa.getUser().getName(), sa.getUser().getScreenName());
            getTimelineinfo.add(twitterInformation);
        }
        List<TwitterInformation> twitterInformations = getTimelineinfo.stream().sorted(Comparator.comparing(TwitterInformation::getName)).collect(Collectors.toList());
        return getTimelineinfo;
    }
    public String postMsg(Twitter twitter, String postMessage)
    {
        try {

            Status status = twitter.updateStatus(postMessage);
            return "Post Tweeted";
        }
        catch (TwitterException e)
        {
            e.printStackTrace();
            return "error";
        }
    }


    //For java streams
    public List<TwitterInformation> getTimeLineFilter(Twitter twitter) throws TwitterException {
        List<TwitterInformation> getTimelineinfo = new ArrayList<>();
        List<Status> twitterinfo = twitter.getHomeTimeline();
        for (Status sa : twitterinfo) {
            TwitterInformation twitterInformation = new TwitterInformation(sa.getText(), sa.getId(), sa.getCreatedAt(), sa.getUser().getProfileImageURL(), sa.getUser().getName(), sa.getUser().getScreenName());
            getTimelineinfo.add(twitterInformation);
        }
        return getTimelineinfo;
    }

}
