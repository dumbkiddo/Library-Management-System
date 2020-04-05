package kz.iitu.libmanagement.controller;

import java.util.Scanner;

public class MemberController {
    public String menu(){
        System.out.println("Enter your name:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        return name;
    }
}
