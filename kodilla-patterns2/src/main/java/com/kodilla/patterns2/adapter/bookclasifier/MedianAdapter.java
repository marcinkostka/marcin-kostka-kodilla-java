package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {

    @Override
    public int publicationYearMedian(Set<com.kodilla.patterns2.adapter.bookclasifier.librarya.Book> bookSet) {
        Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> booksMap = new HashMap<>();

        for (com.kodilla.patterns2.adapter.bookclasifier.librarya.Book bookS: bookSet) {
            BookSignature bookSignature = new BookSignature(bookS.getSignature());
            com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book book = new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(bookS.getAuthor(), bookS.getTitle(), bookS.getPublicationYear());

            booksMap.put(bookSignature,book);
        }
        return medianPublicationYear(booksMap);
    }
}
