package IteratorsAndComparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<String>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    @Override
    public int compareTo(Book other) {
        int result = this.getTitle().compareTo(other.getTitle());

        return result != 0 ? result : Integer.compare(this.getYear(), other.getYear());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getTitle()).append(", ").append(this.getYear());

        for (String author : authors) {
            sb.append(", ").append(author);
        }
        return sb.toString();
    }
}
