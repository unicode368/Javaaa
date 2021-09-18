package com.ua.faculty.entity;

import com.ua.faculty.validation.ValidEmail;
import com.ua.faculty.validation.ValidMobilePhone;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @Column(name = "user_id")
    private Long id;
    @Column(name = "surname")
    @Length(min = 5, message = "*Your surname must have at least 5 characters")
    @NotEmpty(message = "*Please provide a surname")
    private String surname;
    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;
    @Column(name = "patronimic")
    @NotEmpty(message = "*Please provide your name")
    private String patronimic;
    @Column(name = "phone_number")
    @NotEmpty(message = "*Please provide your last name")
    private String phoneNumber;
    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    public UserInfo(String surname,
                    String name, String patronimic,
                    String phoneNumber, String email) {
        this.surname = surname;
        this.name = name;
        this.patronimic = patronimic;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return surname + " "
                + name.charAt(0) + ". " +
                patronimic.charAt(0) + ".";
    }
}
