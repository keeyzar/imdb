package de.keeyzar.checkimdb.imdbclone.repository;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import de.keeyzar.checkimdb.imdbclone.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
