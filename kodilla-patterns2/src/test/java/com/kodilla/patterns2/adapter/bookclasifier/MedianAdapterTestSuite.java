package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void testPublicationYearMedian() {

        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> bookSet = new HashSet<>();

        for(int i=1; i<10; i++) {
                bookSet.add(new Book("Author"+i, "Title"+i, 2000+i, "000"+i));
        }

        //When
        int publicationYearMedian = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2005, publicationYearMedian);

    }
}