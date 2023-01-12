/*
 * Author Name: Philip Meshach
 * Date: 26-12-2022
 * Praise The Lord
 */
package com.niit.Demo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String email;
    private String passWord;
    private String firstName;
    private String lastNama;

    public User() {
    }

    public User(String email, String passWord, String firstName, String lastNama) {
        this.email = email;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastNama = lastNama;
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

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", passWord='" + passWord + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastNama='" + lastNama + '\'' +
                '}';
    }
}
