package de.keeyzar.checkimdb.imdbclone.testutils;

import de.keeyzar.checkimdb.imdbclone.model.Film;
import de.keeyzar.checkimdb.imdbclone.model.Rating;
import de.keeyzar.checkimdb.imdbclone.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreateEntities {

    public static Film createFilm(String filmName) {
        return Film.builder()
                .id(0L)
                .filmName(filmName)
                .build();
    }

    public static User createUser(String username, String password) {
        return User.builder()
                .id(0L)
                .username(username)
                .password(password)
                .build();
    }

    public static Rating createRating(User user, Film film, double rating) {
        return Rating.builder()
                .id(0L)
                .user(user)
                .film(film)
                .rating(rating)
                .build();
    }


}
