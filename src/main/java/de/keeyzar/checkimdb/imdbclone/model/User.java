package de.keeyzar.checkimdb.imdbclone.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//data can't be used when Entity is used
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "User")
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username")
    private String password;

    @Column(name = "password")
    private String username;
}
