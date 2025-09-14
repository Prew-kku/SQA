package kku.sqa.lab.service;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import kku.sqa.lab.api.MovieService; 
import kku.sqa.lab.data.stub.MovieServiceStub;

class FavoriteMovieTest {

    @Test
    void testGetActionMovies_WithValidUser() {

        MovieService movieService = new MovieServiceStub();
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieService);
        
        List<String> actionMovies = favoriteMovie.getActionMovies("alice");

        assertEquals(2, actionMovies.size());
        assertTrue(actionMovies.contains("Mad Max: Fury Road"));
        assertTrue(actionMovies.contains("John Wick"));
    }
    
    
    @Test
    void testGetFavoriteByGenre_Romance() {

        MovieService movieService = new MovieServiceStub();
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieService);

        List<String> romanceMovies = favoriteMovie.getFavoriteByGenre("alice", "Romance");

        assertEquals(5, romanceMovies.size());
    }
}