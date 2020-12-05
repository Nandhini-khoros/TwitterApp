package com.example.Twitter.model;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@ToString
public class TwitterInformation
{
    private String txt;
    private String id;
    private Date createdAt;
    private String profileImageUrl;
    private String name;
    private String screenName;
    private long userId;

}
