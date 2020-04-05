package kz.iitu.libmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class LibraryMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "member_books",
            joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")}
    )
    private List<Book> bookList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Member ID = " + id + ", name='" + name + '\'' + ", books =" + bookList;
    }
}
