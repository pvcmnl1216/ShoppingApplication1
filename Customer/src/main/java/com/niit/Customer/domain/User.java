/*
 * Author Name: Philip Meshach
 * Date: 29-12-2022
 * Praise The Lord
 */
package com.niit.Customer.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class User {
    @Id
    private int userId;
    private String userName;
    private String userPhoneNo;
    private Product product;

    public User() {
    }

    public User(int userId, String userName, String userPhoneNo, Product product) {
        this.userId = userId;
        this.userName = userName;
        this.userPhoneNo = userPhoneNo;
        this.product = product;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNo() {
        return userPhoneNo;
    }

    public void setUserPhoneNo(String userPhoneNo) {
        this.userPhoneNo = userPhoneNo;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(userPhoneNo, user.userPhoneNo) && Objects.equals(product, user.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userPhoneNo, product);
    }
}
