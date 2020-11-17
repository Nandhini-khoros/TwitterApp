package controller;

import twitter4j.*;
import java.util.List;
import java.util.Scanner;

public class Twitterapp1{
    public static void postTweet(String msg){

        Twitter twitter= TwitterFactory.getSingleton();
        try {
            Status status = twitter.updateStatus(msg);
            System.out.println("POst tweeted");
        }
        catch (TwitterException e)
        {
            e.printStackTrace();
        }
    }
    void sendDirectMessage(String msg, String s)  {
        Twitter twitter= TwitterFactory.getSingleton();
        try {
            DirectMessage message = twitter.sendDirectMessage(s, msg);
            System.out.println("Sent: " + message.getText() + " to @" + message.getRecipientId());
        }
        catch (TwitterException e)
        {
            e.printStackTrace();
        }
    }
    void getOneUserTimeline(String userId)  {
        Twitter twitter= TwitterFactory.getSingleton();
        try {
            List<Status> statuses = twitter.getUserTimeline(userId);
            for (Status st : statuses) {
                System.out.println(st.getUser().getName() + "------" + st.getText() + "\n");
            }
        }
        catch(TwitterException e)
            {
                e.printStackTrace();
            }
    }
    public static void main(String[] args) throws TwitterException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message to be posted");
        String st = sc.nextLine();
        System.out.println("Enter the  message to be sent directly to the user and userId");
        String tt = sc.nextLine();
        String ht = sc.nextLine();
        System.out.println("Enter the user Id");
        String t = sc.nextLine();
        Twitterapp1 td = new Twitterapp1();
        td.postTweet(st);
        Twitterapp2.getTimeline();
        td.sendDirectMessage(tt,ht);
        td.getOneUserTimeline(t);
    }
}