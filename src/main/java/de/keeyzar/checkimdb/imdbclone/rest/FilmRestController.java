package de.keeyzar.checkimdb.imdbclone.rest;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import de.keeyzar.checkimdb.imdbclone.services.FilmSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FilmRestController {

    private final FilmSearchService filmSearchService;

    @Secured("ROLE_USER")
    @GetMapping("/film")
    public List<Film> getAllFilms(){
        return filmSearchService.findAllFilms();
    }

    @Secured("ROLE_USER")
    @GetMapping("/film")
    public List<Film> getFilm(@RequestParam(name="name") String name){
        return filmSearchService.findFilmByName(name);
    }

    @GetMapping("/rating/{filmId}")
    @Secured("ROLE_USER")
    public void rateFilm(@PathVariable String filmId){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        log.info(securityContext.getAuthentication().getName());
    }
}
