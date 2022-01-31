package org.cba.controller;

import org.cba.entity.Book;
import org.cba.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by noel on 31/1/22
 */
@Component
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) throws Exception {
        log.debug(">>>>> addBook: {}");
        try {
            this.validateBook(book);

            Book bookDb = bookRepository.findByIsbn(book.getIsbn());
            if (bookDb == null) {
                log.debug("Saving...");
            } else {
                log.debug("Updating...");
                book.setId(bookDb.getId());
            }
            return bookRepository.save(book);
        } finally {
            log.debug("<<<<< addBook: {}");
        }
    }

    public Book updateBook(Book book) throws Exception {
        log.debug(">>>>> updateBook: {}");
        try {
            this.validateBook(book);

            Book bookDb = bookRepository.findByIsbn(book.getIsbn());
            if (bookDb == null) {
                throw new Exception("Book does not exist");
            }
            log.debug("Updating...");
            book.setId(bookDb.getId());
            return bookRepository.save(book);
        } finally {
            log.debug("<<<<< updateBook: {}");
        }
    }

    public List<Book> searchBooks(String title, String authors, String isbn) {
        log.debug(">>>>> searchBooks: {}");
        try {
            return bookRepository.findBooksByFilters(title, authors, isbn);
        } finally {
            log.debug("<<<<< searchBooks: {}");
        }
    }

    public void deleteBook(String isbn) {
        log.debug(">>>>> deleteBook: {}");
        try {
            Book bookDb = bookRepository.findByIsbn(isbn);
            if (bookDb != null) {
                bookRepository.delete(bookDb);
            }
        } finally {
            log.debug("<<<<< deleteBook: {}");
        }
    }

    private void validateBook(Book book) throws Exception {
        String title = book.getTitle();
        String authors = book.getAuthors();
        String isbn = book.getIsbn();
        if (isbn == null || title == null || authors == null) {
            throw new Exception("Title, Authors, ISBN are mandatory fields");
        }
        if (isbn.length() != 13) {
            throw new Exception("Invalid ISBN");
        }
    }

}
