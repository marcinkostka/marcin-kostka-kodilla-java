package com.kodilla.testing.forum.statistics;

public class CalcStatistics {

    Statistics statistics;

    private int usersCount;
    private int postsCount;
    private int commentsCount;
    private double avgPostsPerUser;
    private double avgCommentsPerUser;
    private double avgCommentsPerPost;

    public int getUsersCount() {
        return usersCount;
    }

    public int getPostsCount() {
        return postsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public double getAvgCommentsPerUser() {
        return avgCommentsPerUser;
    }

    public double getAvgCommentsPerPost() {
        return avgCommentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics){

        usersCount = statistics.usersNames().size();
        postsCount = statistics.postsCount();
        commentsCount = statistics.commentsCount();

        avgPostsPerUser = 0;
        if (usersCount == 0) {
            avgPostsPerUser = 0;
        } else {
            avgPostsPerUser = postsCount / usersCount;
        }

        avgCommentsPerUser = 0;
        if (usersCount == 0) {
            avgCommentsPerUser = 0;
        } else {
            avgCommentsPerUser = commentsCount / usersCount;
        }

        avgCommentsPerPost = 0;
        if (postsCount == 0) {
            avgCommentsPerPost = 0;
        } else {
            avgCommentsPerPost = commentsCount / postsCount;
        }
    }
}
