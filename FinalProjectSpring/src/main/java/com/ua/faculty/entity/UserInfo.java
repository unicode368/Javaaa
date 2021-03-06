package com.ua.faculty.entity;


import lombok.*;
import javax.persistence.*;
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
    @NotEmpty
    private String surname;
    @Column(name = "name")
    @NotEmpty
    private String name;
    @Column(name = "patronimic")
    @NotEmpty
    private String patronimic;
    @Column(name = "phone_number")
    @NotEmpty
    private String phoneNumber;
    @Column(name = "email")
    @NotEmpty
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

    public String getFullName() {
        return surname + " "
                + name + " " +
                patronimic;
    }
}
