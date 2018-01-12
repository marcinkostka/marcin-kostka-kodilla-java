package com.kodilla.testing.forum.statistics;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticsTestSuite {

    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    //gdy liczba postów = 0
    public void testCalculateAdvStatisticsPostsNotExistingWithMock() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();

        for(int i=0; i < 10; i++) {
            usersList.add("Kowalski"+i);
        }

        when(statisticMock.usersNames()).thenReturn(usersList);
        when(statisticMock.postsCount()).thenReturn(0);
        when(statisticMock.commentsCount()).thenReturn(100);

        CalcStatistics cstat = new CalcStatistics();

        //When
        cstat.calculateAdvStatistics(statisticMock);
        int postsCount = cstat.getPostsCount();
        double avgPostsPerUser = cstat.getAvgPostsPerUser();
        double avgCommentsPerPost = cstat.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(0, postsCount);
        Assert.assertEquals(0, avgPostsPerUser, 0);
        Assert.assertEquals(0, avgCommentsPerPost, 0);
    }

    @Test
    //gdy liczba postów = 1000
    public void testCalculateAdvStatisticsPostsThousandWithMock() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();

        for(int i=0; i < 10; i++) {
            usersList.add("Kowalski"+i);
        }

        when(statisticMock.usersNames()).thenReturn(usersList);
        when(statisticMock.postsCount()).thenReturn(1000);
        when(statisticMock.commentsCount()).thenReturn(100);

        CalcStatistics cstat = new CalcStatistics();

        //When
        cstat.calculateAdvStatistics(statisticMock);
        int postsCount = cstat.getPostsCount();
        double avgPostsPerUser = cstat.getAvgPostsPerUser();
        double avgCommentsPerPost = cstat.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(1000, postsCount);
        Assert.assertEquals(100, avgPostsPerUser, 0);
        Assert.assertEquals(0.1, avgCommentsPerPost, 1);
    }

    @Test
    //gdy liczba komentarzy = 0
    public void testCalculateAdvStatisticsCommentsNotExistingWithMock() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();

        for(int i=0; i < 10; i++) {
            usersList.add("Kowalski"+i);
        }

        when(statisticMock.usersNames()).thenReturn(usersList);
        when(statisticMock.postsCount()).thenReturn(1000);
        when(statisticMock.commentsCount()).thenReturn(0);

        CalcStatistics cstat = new CalcStatistics();

        //When
        cstat.calculateAdvStatistics(statisticMock);
        int commentsCount = cstat.getCommentsCount();
        double avgCommentsPerUser = cstat.getAvgCommentsPerUser();
        double avgCommentsPerPost = cstat.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(0, commentsCount);
        Assert.assertEquals(0, avgCommentsPerUser, 0);
        Assert.assertEquals(0, avgCommentsPerPost, 0);
    }

    @Test
    //gdy liczba komentarzy < liczba postów
    public void testCalculateAdvStatisticsQuantityCommentsLowerThanPostsWithMock() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();

        for(int i=0; i < 10; i++) {
            usersList.add("Kowalski"+i);
        }

        when(statisticMock.usersNames()).thenReturn(usersList);
        when(statisticMock.postsCount()).thenReturn(10);
        when(statisticMock.commentsCount()).thenReturn(5);

        CalcStatistics cstat = new CalcStatistics();

        //When
        cstat.calculateAdvStatistics(statisticMock);
        int commentsCount = cstat.getCommentsCount();
        int postsCount = cstat.getPostsCount();
        boolean result = false;

        if (commentsCount < postsCount) {
            result = true;
        } else {
            result = false;
        }

        double avgCommentsPerPost = cstat.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(0.5, avgCommentsPerPost, 1);
        Assert.assertTrue(result);
    }

    @Test
    //gdy liczba komentarzy > liczba postów
    public void testCalculateAdvStatisticsQuantityCommentsHigherThanPostsWithMock() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();

        for(int i=0; i < 10; i++) {
            usersList.add("Kowalski"+i);
        }

        when(statisticMock.usersNames()).thenReturn(usersList);
        when(statisticMock.postsCount()).thenReturn(1000);
        when(statisticMock.commentsCount()).thenReturn(5000);

        CalcStatistics cstat = new CalcStatistics();

        //When
        cstat.calculateAdvStatistics(statisticMock);
        int commentsCount = cstat.getCommentsCount();
        int postsCount = cstat.getPostsCount();
        boolean result = false;

        if (commentsCount > postsCount) {
            result = true;
        } else {
            result = false;
        }

        double avgCommentsPerPost = cstat.getAvgCommentsPerPost();

        //Then
        Assert.assertEquals(5, avgCommentsPerPost, 0);
        Assert.assertTrue(result);
    }

    @Test
    //gdy liczba użytkowników = 0
    public void testCalculateAdvStatisticsUsersNotExistingWithMock() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();

        when(statisticMock.usersNames()).thenReturn(usersList);
        when(statisticMock.postsCount()).thenReturn(500);
        when(statisticMock.commentsCount()).thenReturn(5000);

        CalcStatistics cstat = new CalcStatistics();

        //When
        cstat.calculateAdvStatistics(statisticMock);
        int commentsCount = cstat.getCommentsCount();
        int postsCount = cstat.getPostsCount();
        int userCount = cstat.getUsersCount();
        double avgPostsPerUser = cstat.getAvgPostsPerUser();
        double avgCommentsPerUser = cstat.getAvgCommentsPerUser();

        //Then
        Assert.assertEquals(0, userCount);
        Assert.assertEquals(0, avgPostsPerUser, 0);
        Assert.assertEquals(0, avgCommentsPerUser, 0);
    }

    @Test
    //gdy liczba użytkowników = 1000
    public void testCalculateAdvStatisticsUsersThousandWithMock() {
        //Given
        Statistics statisticMock = mock(Statistics.class);
        List<String> usersList = new ArrayList<>();

        for(int i=0; i < 1000; i++) {
            usersList.add("Kowalski"+i);
        }

        when(statisticMock.usersNames()).thenReturn(usersList);
        when(statisticMock.postsCount()).thenReturn(500);
        when(statisticMock.commentsCount()).thenReturn(1200);

        CalcStatistics cstat = new CalcStatistics();

        //When
        cstat.calculateAdvStatistics(statisticMock);
        int commentsCount = cstat.getCommentsCount();
        int postsCount = cstat.getPostsCount();
        int userCount = cstat.getUsersCount();
        double avgPostsPerUser = cstat.getAvgPostsPerUser();
        double avgCommentsPerUser = cstat.getAvgCommentsPerUser();

        //Then
        Assert.assertEquals(1000, userCount);
        Assert.assertEquals(0.5, avgPostsPerUser, 1);
        Assert.assertEquals(1.2, avgCommentsPerUser, 1);
    }
}
