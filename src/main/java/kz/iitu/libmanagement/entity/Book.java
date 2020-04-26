package kz.iitu.libmanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    @ManyToMany(mappedBy = "booksgenre", fetch = FetchType.LAZY)
    private List<Genre> genreList;

    @Enumerated(EnumType.STRING)
    private BookTransactionStatus status;
    @ManyToMany(mappedBy = "bookList", fetch = FetchType.LAZY)
    private List<LibraryMember> memberList;

    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    private List<BookCollection> bookCollections;

// public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
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
//
//    public void setGenres(List<Genre> genres) {
//        this.genreList = genres;
//    }
//
//    public List<Genre> getGenres() {
//        return genreList;
//    }
//
//    public BookTransactionStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(BookTransactionStatus status) {
//        this.status = status;
//    }
//

    @Override
    public String toString() {
        return  "Book ID = " + id + ", title = '" + title + '\'' + ", author = '" + author + '\'';
        ///+ ", genre =" + genres;
    }
}

