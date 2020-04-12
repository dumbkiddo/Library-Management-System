package kz.iitu.libmanagement.repository;

import kz.iitu.libmanagement.entity.BookCollection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCollectionRepository extends JpaRepository<BookCollection, Long> {
    List<BookCollection> findByAuthor(String author);
}
