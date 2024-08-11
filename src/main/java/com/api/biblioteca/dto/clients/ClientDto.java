package com.api.biblioteca.dto.clients;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientDto {

    private Long id;

    @NotBlank(message = "Nombre no ingresado")
    private String name;

    @NotBlank(message = "Apellido No ingresado")
    private String last_name;

    @NotBlank(message = "Email no ingresado")
    @Email(message = "Email no valido")
    private String email;

    @NotBlank(message = "Numero de telefono no ingresado")
    private String phoneNumber;

    public ClientDto(Long id, String name, String last_name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //--------------------Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    //---------------------------

    //----------------------Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
