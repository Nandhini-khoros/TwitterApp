package com.example.Twitter.dao;
import com.example.Twitter.model.TwitterInformation;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Component
@Primary
public class GetPost implements TwitterDaoInterface {

    public List<TwitterInformation> getTimeLine(Twitter twitter) throws TwitterException {
        List<TwitterInformation> getTimelineinfo = new ArrayList<>();
        Paging paging = new Paging();
        paging.setCount(40);
        List<Status> getTimeLine = twitter.getHomeTimeline(paging);
        for (Status status : getTimeLine) {
            TwitterInformation twitterInformation = new TwitterInformation(status.getText(),  Long.toString(status.getId()),status.getCreatedAt(), status.getUser().getProfileImageURL(), status.getUser().getName(), status.getUser().getScreenName(),status.getUser().getId());
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
    public List<TwitterInformation> getTimelines(Twitter twitter) throws TwitterException {
        List<TwitterInformation> getTimelineinfo = new ArrayList<>();
        List<Status> getTimeLine = twitter.getHomeTimeline();
        for (Status status : getTimeLine) {
            TwitterInformation twitterInformation = new TwitterInformation(status.getText(),  Long.toString(status.getId()),status.getCreatedAt(), status.getUser().getProfileImageURL(), status.getUser().getName(), status.getUser().getScreenName(),status.getUser().getId());
            getTimelineinfo.add(twitterInformation);
        }
        return getTimelineinfo;
    }
    public List<TwitterInformation> getTimeLineFilter(Twitter twitter) throws TwitterException {
        List<TwitterInformation> getTimelineinfo = new ArrayList<>();
        List<Status> twitterinfo = twitter.getHomeTimeline();
        for (Status status : twitterinfo) {
            TwitterInformation twitterInformation = new TwitterInformation(status.getText(), Long.toString(status.getId()), status.getCreatedAt(), status.getUser().getProfileImageURL(), status.getUser().getName(), status.getUser().getScreenName(),status.getUser().getId());
            getTimelineinfo.add(twitterInformation);
        }
        return getTimelineinfo;
    }

}
