package de.keeyzar.checkimdb.imdbclone.repository;

import de.keeyzar.checkimdb.imdbclone.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Query(value = "SELECT AVG(e.userrating) FROM rating e WHERE e.film_id = ?1" , nativeQuery = true)
    Optional<Double> getAverageRatingForFilm(Long filmId);
}
