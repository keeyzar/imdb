package de.keeyzar.checkimdb.imdbclone.services;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import de.keeyzar.checkimdb.imdbclone.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * provide means to find a film based e.g. on name
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RatingService {
    private final RatingRepository ratingRepository;

    public Optional<Double> getAverageFilmRating(Film film){
        return ratingRepository.getAverageRatingForFilm(film.getId());
    }
}
