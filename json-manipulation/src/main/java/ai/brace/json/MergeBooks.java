package ai.brace.json;

import ai.brace.domain.Book;
import ai.brace.domain.TextArray;

import java.util.*;

/**
 * This will merge 2 {@linkplain Book} objects taking all of the fields and then giving it a new {@linkplain UUID}
 * and merging the lists of {@linkplain TextArray}
 */
public class MergeBooks {

    public Book mergeBooks(Book book1, Book book2) {
        if (book1.equals(book2)) {
            if (book1.getLastModified() > book2.getLastModified()) {
                return merge(book1, book2);
            } else {
                return merge(book2, book1);
            }
        }
        return null;
    }

    protected Book merge(Book book1, Book book2) {
        Book book = book1.copy();
        book.setUuid(UUID.randomUUID());
        if (Objects.isNull(book.getReleaseDate())) {
            book.setReleaseDate(book2.getReleaseDate());
        }
        ArrayList<TextArray> list = new ArrayList<>();
        list.addAll(book1.getTextArray());
        list.addAll(book2.getTextArray());
        book.setTextArray(list);
        return book;
    }
}
