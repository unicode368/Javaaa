package com.ua.faculty.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id")
    @Getter
    private Long id;
    @Column(name = "role")
    @NotNull
    @Getter
    @Setter
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    @Override
    public String toString() {
        return role;
    }

}
