/*
 * Author Name: Philip Meshach
 * Date: 29-12-2022
 * Praise The Lord
 */
package com.niit.Customer.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document
public class User {
    @Id
    private String email;
    private String passWord;
    private String firstName;
    private String lastNama;
    private List<Product> product;

    public User() {
    }

    public User(String email, String passWord, String firstName, String lastNama, List<Product> product) {
        this.email = email;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastNama = lastNama;
        this.product = product;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNama() {
        return lastNama;
    }

    public void setLastNama(String lastNama) {
        this.lastNama = lastNama;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastNama='" + lastNama + '\'' +
                ", product=" + product +
                '}';
    }
}