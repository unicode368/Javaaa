package com.ua.faculty.entity;

import lombok.*;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.*;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @Getter
    private Long id;
    @Column(name = "login")
    @Length(min = 5, message = "*Your login must have at least 5 characters")
    @NotEmpty(message = "*Please provide your login")
    @Setter
    private String login;
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Getter
    @Setter
    private String password;
    @Column(name = "blocked")
    @Getter
    @Setter
    private Boolean blocked;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.blocked = false;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_courses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       return roles.stream()
                .map( role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
   }
    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
       return "id: " + id + "," +
               "login: " + login + "," +
               "password: " + password;
    }
}