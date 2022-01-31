package org.cba.entity;

import javax.persistence.*;

/**
 * Created by noel on 31/1/22
 */
@Entity
@Table(name = "book")
public class Book {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255)
    private String title;

    @Column(length = 255)
    private String authors;

    @Column(length = 13, unique = true)
    private String isbn;

    @Column(length = 8)
    private String pubDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append("\n\tid: ").append(id);
        buff.append("\n\ttitle: ").append(title);
        buff.append("\n\tauthors: ").append(authors);
        buff.append("\n\tisbn: ").append(isbn);
        buff.append("\n\tpublication Date: ").append(pubDate);
        return buff.toString();
    }

}
