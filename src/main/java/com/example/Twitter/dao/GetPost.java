package com.example.Twitter.dao;

import com.example.Twitter.model.TwitterInformation;
import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetPost implements TwitterDaoInterface {
    public List<TwitterInformation> getTimeLine(Twitter twitter) throws TwitterException {

        List<TwitterInformation> getTimelineinfo = new ArrayList<>();
        List<Status> getTimeLine = twitter.getHomeTimeline();

        for(Status sa : getTimeLine)
        {
            TwitterInformation twitterInformation = new TwitterInformation();
            twitterInformation.setTxt(sa.getText());
            twitterInformation.setCreatedAt(sa.getCreatedAt());
            twitterInformation.setId(sa.getId());
            twitterInformation.setProfileImageUrl(sa.getUser().getProfileImageURL());
            twitterInformation.setName(sa.getUser().getName());
            twitterInformation.setScreenName(sa.getUser().getScreenName());
            getTimelineinfo.add(twitterInformation);

        }
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
}
