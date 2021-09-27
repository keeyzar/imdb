package de.keeyzar.checkimdb.imdbclone.config;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import de.keeyzar.checkimdb.imdbclone.model.Rating;
import de.keeyzar.checkimdb.imdbclone.model.User;
import de.keeyzar.checkimdb.imdbclone.repository.FilmRepository;
import de.keeyzar.checkimdb.imdbclone.repository.RatingRepository;
import de.keeyzar.checkimdb.imdbclone.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * initialize database with some data
 * TODO this may be optimized, but is enough for testing purposes at this point in time
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
public class DatabaseIntializer {

    private final FilmRepository filmRepository;
    private final UserRepository userRepository;
    private final RatingRepository ratingRepository;

    /**
     * when everything has booted up, run this class
     * TODO for better readability convert this to class X implements CommandLineRunner
     */
    @Bean
    public CommandLineRunner initializeDatabaseWithDummyData() {
        //todo hibernate + spring boot provides possibility to load data into the database
        //via database file, find out how..
        //this is enough for the moment
        return (e) -> {
            List<User> dummyUsers = createDummyUser();
            List<Film> dummyFilms = createDummyFilm();
            userRepository.findAll()
                    .forEach(
                            user -> log.info("saved  user with id: {}, {}", user.getId(), user)
                    );
            createDummyRating(dummyUsers, dummyFilms);
        };
    }

    private List<Film> createDummyFilm() {
        return List.of(
                saveFilm("Star Wars"),
                saveFilm("Harry Potter"));
    }


    private List<User> createDummyUser() {
        return List.of(
                saveUser("christian"),
                saveUser("kevin"),
                saveUser("yusuf"));
    }

    private void createDummyRating(List<User> dummyUsers, List<Film> dummyFilms) {
        //todo use google guave to zip streams into a tupel...
        //because this may result in null pointer exceptions, if more films than users are created
        for (int idx = 0; idx < dummyFilms.size(); idx++) {
            Film film = dummyFilms.get(idx);
            User user = dummyUsers.get(idx);
            ratingRepository.save(Rating.builder()
                            .id(0L)
                            .film(film)
                            .user(user)
                            .rating(1.5D)
                    .build());
        }
        //debug
        ratingRepository.findAll()
                .forEach(
                        rating -> log.info("created rating with id: {}, rating: {}", rating.getId(), rating)
                );
    }

    private Film saveFilm(String filmName) {
        return filmRepository.save(Film.builder()
                .id(0L)
                .filmName(filmName)
                .build()
        );
    }

    private User saveUser(String christian) {
        return userRepository.save(User.builder()
                .id(0L)
                .username(christian)
                //password is test for now - encrypted with spring encrypt test
                .password("$2a$10$G9JssU8O9y7K9LghQPFyBOnW7Q7zvaaS/v.7dIhpu8JRfW5sYwm5C")
                .role("ROLE_USER")
                .build());
    }

}
