package model;


public class Book {
private int id;
private String title;
private String author;
private String isbn;
private String category;
private String status;


public Book() {}


public Book(String title, String author, String isbn, String category, String status) {
this.title = title;
this.author = author;
this.isbn = isbn;
this.category = category;
this.status = status;
}


// Getters and Setters
}