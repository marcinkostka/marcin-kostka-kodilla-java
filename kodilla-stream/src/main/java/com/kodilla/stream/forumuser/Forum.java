package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum() {
        theForumUserList.add(new ForumUser(001, "Dylan Murphy", 'M',
                1987, 6, 30, 10));
        theForumUserList.add(new ForumUser(002, "Phoebe Pearson", 'F',
                2012, 6, 30, 5));
        theForumUserList.add(new ForumUser(003, "Morgan Walsh", 'M',
                2001, 6, 30, 15));
        theForumUserList.add(new ForumUser(004, "Aimee Murphy", 'F',
                2015, 6, 30, 13));
        theForumUserList.add(new ForumUser(005, "Ryan Talley", 'M',
                2007, 6, 30, 54));
        theForumUserList.add(new ForumUser(006, "Madelynn Carson", 'F',
                2007, 6, 30, 74));
        theForumUserList.add(new ForumUser(007, "Giancarlo Guerrero", 'M',
                1992, 6, 30, 34));

    }

    public List<ForumUser> getList() {
        return new ArrayList<>(theForumUserList);
    }
}