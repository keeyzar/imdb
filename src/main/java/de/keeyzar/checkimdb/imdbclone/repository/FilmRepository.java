package de.keeyzar.checkimdb.imdbclone.repository;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByFilmNameContaining(String name);
}
