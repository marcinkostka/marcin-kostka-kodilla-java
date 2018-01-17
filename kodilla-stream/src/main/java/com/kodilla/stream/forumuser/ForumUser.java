package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String userName;
    private final char userSex;
    private final LocalDate userBirthday;
    private final int postQuantity;

    public ForumUser(final int userId, final String userName, final char userSex, final int yearOfBirth, final int monthOfBirth, final int dayOfBirth, final int postQuantity) {

        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userBirthday = LocalDate.of(yearOfBirth, monthOfBirth, dayOfBirth);
        this.postQuantity = postQuantity;

    }

    public int getUserSex() {
        return userSex;
    }

    public LocalDate getUserBirthday() {
        return userBirthday;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getPostQuantity() {
        return postQuantity;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id: '" + userId + '\'' +
                ", Name: '" + userName + '\'' +
                ", Sex: " + userSex +
                ", Birthday: " + userBirthday +
                ", postQuantity: '" + postQuantity + '\'' +
                '}';
    }
}