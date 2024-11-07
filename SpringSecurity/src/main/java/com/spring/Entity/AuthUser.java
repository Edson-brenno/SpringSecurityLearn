package com.spring.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_auth_user")
public class AuthUser implements UserDetails{

//    @Serial
//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "The username cannot be null")
    @Column(nullable = false)
    @Size(min = 5, max = 100, message = "The username needs to have 5 to 100 characters")
    private String username;

    @NotNull(message = "The Password cannot be null")
    @Column(nullable = false)
    private String password;

    @NotNull(message = "The first name cannot be null")
    @Column(nullable = false)
    @Size(min = 1, max = 250, message = "The first name needs to have 1 to 250 characters")
    private String firstName;

    @NotNull(message = "The last name cannot be null")
    @Column(nullable = false)
    @Size(min = 1, max = 250, message = "The last name needs to have 1 to 250 characters")
    private String lastName;

    @Email(message = "Please, inform a valid email")
    private String email;

    private boolean is_active;
    private boolean is_staff;
    private boolean is_admin;

    public AuthUser(){}

    public AuthUser(String username, String password, String firstName, String lastName, String email) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.is_active = true;
        this.is_staff = false;
        this.is_admin = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean isIs_staff() {
        return is_staff;
    }

    public void setIs_staff(boolean is_staff) {
        this.is_staff = is_staff;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthUser authUser = (AuthUser) o;
        return is_active == authUser.is_active && is_staff == authUser.is_staff && is_admin == authUser.is_admin &&
                Objects.equals(username, authUser.username) && Objects.equals(password, authUser.password) &&
                Objects.equals(firstName, authUser.firstName) && Objects.equals(lastName, authUser.lastName) &&
                Objects.equals(email, authUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, email, is_active, is_staff, is_admin);
    }
}
