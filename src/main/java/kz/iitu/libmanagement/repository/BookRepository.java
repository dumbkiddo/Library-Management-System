package kz.iitu.libmanagement.repository;

import kz.iitu.libmanagement.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);

  //  List<Book> findByGenre(String genre);

    @Query("FROM Book WHERE status='REQUESTED'")
    List<Book> showRequested();

    @Query("FROM Book WHERE status='ISSUED'")
    List<Book> showIssued();

    @Query("FROM Book WHERE status='RETURNED'")
    List<Book> findAvailable();
}
