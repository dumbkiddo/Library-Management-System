package kz.iitu.libmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Genre> genres;
    @Enumerated(EnumType.STRING)
    private BookTransactionStatus status;
    @ManyToMany(mappedBy = "bookList", fetch = FetchType.LAZY)
    private List<LibraryMember> memberList;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public BookTransactionStatus getStatus() {
        return status;
    }

    public void setStatus(BookTransactionStatus status) {
        this.status = status;
    }

    public List<LibraryMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<LibraryMember> memberList) {
        this.memberList = memberList;
    }

    @Override
    public String toString() {
        return  "Book ID = " + id + ", title = '" + title + '\'' + ", author = '" + author + '\'' + ", genre =" + genres;
    }
}

