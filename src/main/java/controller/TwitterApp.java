package controller;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.Scanner;

public class TwitterApp {


    public Twitter getTwitterInstance() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("**")
                .setOAuthConsumerSecret("**")
                .setOAuthAccessToken("**")
                .setOAuthAccessTokenSecret("***");
        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        return twitter;
    }


    void getTimeline(Twitter twitter) throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        for (Status st : statuses) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");
        }
    }

    void postTweet(Twitter twitter, String msg) throws TwitterException {

        Status status = twitter.updateStatus(msg);
        System.out.println("POst tweeted");
    }


    public static void main(String[] args) throws TwitterException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message to be posted");
        String st = sc.nextLine();

        TwitterApp td = new TwitterApp();
        Twitter d = td.getTwitterInstance();

        td.postTweet(d,st);
        td.getTimeline(d);


    }
}

