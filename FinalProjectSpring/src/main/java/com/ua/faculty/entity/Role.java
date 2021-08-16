package com.ua.faculty.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "role")
    @NotNull
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

}
