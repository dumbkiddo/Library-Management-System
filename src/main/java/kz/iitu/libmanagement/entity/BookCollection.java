package kz.iitu.libmanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter @Setter @NoArgsConstructor
@Entity
public class BookCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "collection_books",
            joinColumns = {@JoinColumn(name = "collection_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")}
    )

    private List<Book> books;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }

    @Override
    public String toString() {
        return  "Collection ID = " + id + ",  author = '" + author + '\'' + ", books =" + books;
    }
}

