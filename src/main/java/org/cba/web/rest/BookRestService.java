package org.cba.web.rest;

import org.cba.controller.BookController;
import org.cba.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by noel on 31/1/22
 */
@RestController
@RequestMapping("/api/cba/book")
public class BookRestService {

    private static final Logger log = LoggerFactory.getLogger(BookRestService.class);

    private BookController bookController;

    public BookRestService(BookController bookController) {
        this.bookController = bookController;
    }

    @PostMapping(value = "/add")
    public Book add(@RequestBody Book book) throws Exception {
        log.debug(">>>>> add: {}", book.toString());
        return bookController.addBook(book);
    }

    @PutMapping(value = "/{isbn}")
    public Book update(@PathVariable String isbn, @RequestBody Book book) throws Exception {
        book.setIsbn(isbn);
        log.debug(">>>>> update: {}", book.toString());
        return bookController.updateBook(book);
    }

    @DeleteMapping(value = "/{isbn}")
    public void delete(@PathVariable String isbn) throws Exception {
        log.debug(">>>>> delete: {}", isbn);
        bookController.deleteBook(isbn);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String authors,
                                  @RequestParam(required = false) String isbn) {
        log.debug(">>>>> searchBooks-  title:{}, authors:{}, isbn:{}", title, authors, isbn);
        return bookController.searchBooks(title, authors, isbn);
    }

}
