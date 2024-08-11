package com.api.biblioteca.dto.books;

public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String editorial;
    private String isbn;
    private String publishedDate;  // Cambiado a String
    private Double price;
    private String disponibilidad;
    private Long clientid;  // Cambiado a Long para evitar problemas con null

    // Constructor
    public BookDto(Long id, String title, String author, String editorial, String isbn, String publishedDate, Double price, String disponibilidad, Long clientid) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.editorial = editorial;
        this.isbn = isbn;
        this.publishedDate = publishedDate;  // Cambiado a String
        this.price = price;
        this.disponibilidad = disponibilidad;
        this.clientid = clientid;  // Cambiado a Long
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getPublishedDate() { return publishedDate; }  // Cambiado a String
    public void setPublishedDate(String publishedDate) { this.publishedDate = publishedDate; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(String disponibilidad) { this.disponibilidad = disponibilidad; }

    public Long getClientid() { return clientid; }
    public void setClientid(Long clientid) { this.clientid = clientid; }
}
