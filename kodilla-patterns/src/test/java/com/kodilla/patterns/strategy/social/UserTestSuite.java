package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.TwitterPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User user1 = new Millenials("Phil");
        User user2 = new YGeneration("Peter");
        User user3 = new ZGeneration("Harry");

        //When
        String user1Social = user1.sharePost();
        System.out.println(user1.getUserName() + " uses " + user1Social);
        String user2Social = user2.sharePost();
        System.out.println(user2.getUserName() + " uses " + user2Social);
        String user3Social = user3.sharePost();
        System.out.println(user3.getUserName() + " uses " + user3Social);

        //Then
        Assert.assertEquals("Facebook", user1Social);
        Assert.assertEquals("Snapchat", user2Social);
        Assert.assertEquals("Twitter", user3Social);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User user = new Millenials("David");

        //When
        String userSocial = user.sharePost();
        System.out.println(user.getUserName() + " uses " + userSocial);
        user.setSocialPublisher(new TwitterPublisher());
        userSocial = user.sharePost();
        System.out.println(user.getUserName() + " uses " + userSocial);

        //Then
        Assert.assertEquals("Twitter", userSocial);
    }
}
