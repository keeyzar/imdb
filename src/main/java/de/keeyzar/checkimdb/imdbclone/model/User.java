package de.keeyzar.checkimdb.imdbclone.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//data can't be used when Entity is used
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
    private boolean enabled;
}
