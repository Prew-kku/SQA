package kku.sqa.lab.service;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import kku.sqa.lab.api.MovieService; 
import kku.sqa.lab.data.stub.MovieServiceStub;

class FavoriteMovieTest {

    @Test
    void testGetActionMovies_WithValidUser() {
        // Arrange
        MovieService movieService = new MovieServiceStub();
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieService);
        
        // Act
        List<String> actionMovies = favoriteMovie.getActionMovies("alice");
        
        // Assert
        assertEquals(2, actionMovies.size());
        assertTrue(actionMovies.contains("Mad Max: Fury Road"));
        assertTrue(actionMovies.contains("John Wick"));
    }
    
    
    @Test
    void testGetFavoriteByGenre_Romance() {
        // Arrange
        MovieService movieService = new MovieServiceStub();
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieService);
        
        // Act
        List<String> romanceMovies = favoriteMovie.getFavoriteByGenre("alice", "Romance");
        
        // Assert
        assertEquals(5, romanceMovies.size());
    }
}