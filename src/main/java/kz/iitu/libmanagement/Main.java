package kz.iitu.libmanagement;

import kz.iitu.libmanagement.configuration.SpringConfiguration;
import kz.iitu.libmanagement.controller.BookController;
import kz.iitu.libmanagement.controller.MemberController;
import kz.iitu.libmanagement.entity.Book;
import kz.iitu.libmanagement.entity.BookTransactionStatus;
import kz.iitu.libmanagement.entity.Genre;
import kz.iitu.libmanagement.entity.LibraryMember;
import kz.iitu.libmanagement.repository.BookRepository;
import kz.iitu.libmanagement.repository.GenreRepository;
import kz.iitu.libmanagement.repository.LibraryMemberRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        LibraryMember member = new LibraryMember();
        MemberController mc = new MemberController();
        member.setName(mc.menu());

        Genre horror = new Genre();
        Genre scifi = new Genre();
        Genre kids = new Genre();
        Genre history = new Genre();
        horror.setType("Horror");
        scifi.setType("Science fiction");
        kids.setType("For kids");
        history.setType("History");
        GenreRepository gr = context.getBean("genreRepository", GenreRepository.class);
        gr.saveAndFlush(horror);
        List<Genre> list1 = new ArrayList<Genre>();
        List<Genre> list2 = new ArrayList<Genre>();
        List<Genre> list3 = new ArrayList<Genre>();
        list1.add(horror);
        list1.add(scifi);
        list2.add(kids);
        list3.add(history);

        Book book = new Book();
        book.setAuthor("Emily Brooks");
        book.setTitle("Return to the unknown");
        book.setGenres(list1);
        book.setStatus(BookTransactionStatus.RETURNED);

        Book book2 = new Book();
        book2.setAuthor("Eric Hills");
        book2.setTitle("Spots");
        book2.setGenres(list2);
        book2.setStatus(BookTransactionStatus.ISSUED);

        Book book3 = new Book();
        book3.setAuthor("Brandon Heus");
        book3.setTitle("Egyptian manuscripts");
        book3.setGenres(list3);
        book3.setStatus(BookTransactionStatus.REQUESTED);

        BookRepository br = context.getBean("bookRepository", BookRepository.class);

        br.save(book);
        br.save(book2);
        br.save(book3);
        System.out.println("------List of books " + br.findAll());

        List<Book> bList = new ArrayList<Book>();
        BookController bc = new BookController();
        bList.add(book);
        bc.showDetails(bList,"Book");

        System.out.println("Enter book title to search: ");
        Scanner scan = new Scanner(System.in);
        String bookTitle = scan.nextLine();
        System.out.println("\nFound books: " + br.findByTitle(bookTitle));

        System.out.println("Enter book author to search: ");
        String bookAuthor = scan.nextLine();
        System.out.println("\nFound books: " + br.findByTitle(bookAuthor));

        System.out.println("Show all available books: ");
        System.out.println("\nFound books: " + br.findAvailable());

        member.setBookList(bList);

        LibraryMemberRepository mr = context.getBean("libraryMemberRepository", LibraryMemberRepository.class);
        System.out.println("------" + member.toString());
        mr.saveAndFlush(member);

    }
}
