package com.spring.Entity;

import org.springframework.core.codec.StringDecoder;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class AuthUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String userName;
    private String passWord;

    public AuthUser(){}

    public AuthUser(String username, String password){
        this.userName = username;
        this.passWord = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUser authUser = (AuthUser) o;
        return Objects.equals(id, authUser.id) && Objects.equals(userName, authUser.userName) && Objects.equals(passWord, authUser.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, passWord);
    }
}
