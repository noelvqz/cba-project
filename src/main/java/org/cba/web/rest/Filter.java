package org.cba.web.rest;

/**
 * Created by noel on 31/1/22
 */
public class Filter {

    private String title;
    private String authors;
    private String isbn;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append("\n\ttitle: ").append(title);
        buff.append("\n\tauthors: ").append(authors);
        buff.append("\n\tisbn: ").append(isbn);
        return buff.toString();
    }
}
