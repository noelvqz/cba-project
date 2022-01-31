package org.cba.repository;

import org.cba.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by noel on 31/1/22
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE (:title is null or lower(b.title) like lower(concat('%', :title, '%'))) " +
            "and (:authors is null or lower(b.authors) like lower(concat('%', :authors, '%'))) " +
            "and (:isbn is null or b.isbn = :isbn) ")
    List<Book> findBooksByFilters(String title, String authors, String isbn);

    Book findByIsbn(String isbn);

}
