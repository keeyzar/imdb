package de.keeyzar.checkimdb.imdbclone.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "Film")
@NoArgsConstructor
public class Film {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "filmName")
    private String filmName;

    //additional data may be added in the future
}
