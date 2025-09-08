 package kku.sqa.lab.service;

import java.util.ArrayList; import java.util.Collections; import java.util.List;

import kku.sqa.lab.api.MovieService;

public class FavoriteMovie {

private final MovieService movieService;

public FavoriteMovie(MovieService movieService) {
    this.movieService = movieService;
}

public List<String> getFavoriteByGenre(String username, String genre) {
    if (username == null || genre == null) return Collections.emptyList();

    List<String> all = movieService.getPurchasedMovies(username);
    if (all == null || all.isEmpty()) return Collections.emptyList();

    String target = genre.trim().toLowerCase();
    List<String> result = new ArrayList<>();
    for (String item : all) {
        if (item == null) continue;
        String[] parts = item.split("\\|");
        if (parts.length < 2) continue;
        String title = parts[0].trim();
        String itemGenre = parts[1].trim().toLowerCase();
        if (itemGenre.equals(target)) {
            result.add(title);
        }
    }
    return result;
}

public List<String> getActionMovies(String username) {
    return getFavoriteByGenre(username, "Action");
}
}