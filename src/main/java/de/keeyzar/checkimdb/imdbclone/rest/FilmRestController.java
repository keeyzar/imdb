package de.keeyzar.checkimdb.imdbclone.rest;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import de.keeyzar.checkimdb.imdbclone.services.FilmSearchService;
import de.keeyzar.checkimdb.imdbclone.services.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FilmRestController {

    private final FilmSearchService filmSearchService;
    private final RatingService ratingService;

    @Secured("ROLE_USER")
    @GetMapping("/film")
    public List<Film> getAllFilms(@RequestParam(name="name", defaultValue = "") String filmName)
    {
        //rating in film beim serialisieren ist eine zyklische referenz, die im StackOverflow endet
        //daher sollte ich niemals DTO == entity rausgeben.

        if("".equals(filmName)) {
            return filmSearchService.findAllFilms();
        } else {
            return filmSearchService.findFilmByName(filmName);
        }
    }

    @GetMapping("/rating/{filmId}")
    @Secured("ROLE_USER")
    public Optional<Double> getFilmRating(@PathVariable Long filmId){
        return ratingService.getAverageFilmRating(Film.builder().id(filmId).build());
    }
}
