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
    private Long id;
    @Column(name = "login")
    @Length(min = 5, message = "*Your login must have at least 5 characters")
    @NotEmpty(message = "*Please provide your login")
    private String login;
    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;
    @Column(name = "blocked")
    private Boolean blocked;

   @ManyToMany
   @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private Collection<Role> roles;

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
       return roles.stream()
                .map( role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}