package kz.iitu.libmanagement.controller;

import kz.iitu.libmanagement.entity.Book;
import kz.iitu.libmanagement.entity.BookTransactionStatus;
import kz.iitu.libmanagement.entity.LibraryMember;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Scanner;

public class BookController {
    @PersistenceContext
    private EntityManager entityManager;

    public String request(){
        System.out.println("Enter book title to request: ");
        Scanner scan = new Scanner(System.in);
        String requestName = scan.nextLine();
        return requestName;
    }

    public void borrowBook(Long clientId, Long bookId) {
            LibraryMember member = entityManager.find(LibraryMember.class, clientId);
            Book book = entityManager.find(Book.class, bookId);
            if (book.getStatus().equals("RETURNED")) {
                book.setStatus(BookTransactionStatus.ISSUED);
            } else {
                System.out.println("Book is not available!");
            }
    }

    public void showDetails(List<?> entities, String message) {
        System.out.println("-----" + message + "-----");
        for (Object entity : entities) {
            System.out.println(entity);
        }
        System.out.println("--------------------------");
    }

}
