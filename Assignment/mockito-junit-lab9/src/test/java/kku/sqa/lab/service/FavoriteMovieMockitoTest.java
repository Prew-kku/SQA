package kku.sqa.lab.service;

import java.util.Arrays; 
import java.util.List;
import static org.junit.jupiter.api.Assertions.*; 
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import kku.sqa.lab.api.MovieService;

class FavoriteMovieMockitoTest {

    @Test
    void testGetActionMovies_WithMockData_ShouldReturnActionMovies() {
        // Arrange
        MovieService movieServiceMock = mock(MovieService.class);
        String username = "alice";
        List<String> mockMovies = Arrays.asList(
            "The Notebook|Romance|datenight",
            "Mad Max: Fury Road|Action|horror",
            "John Wick|Action|horror",
            "The Conjuring|Horror|horror"
        );
        when(movieServiceMock.getPurchasedMovies(username)).thenReturn(mockMovies);
        
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieServiceMock);
        
        // Act
        List<String> actionMovies = favoriteMovie.getActionMovies(username);
        
        // Assert
        assertNotNull(actionMovies);
        assertEquals(2, actionMovies.size());
        assertTrue(actionMovies.contains("Mad Max: Fury Road"));
        assertTrue(actionMovies.contains("John Wick"));
        
        // Verify method was called once
        verify(movieServiceMock, times(1)).getPurchasedMovies(username);
    }
    
    @Test
    void testGetFavoriteByGenre_WithSpecificGenre_ShouldReturnCorrectMovies() {
        // Arrange
        MovieService movieServiceMock = mock(MovieService.class);
        String username = "alice";
        String genre = "Romance";
        List<String> mockMovies = Arrays.asList(
            "The Notebook|Romance|datenight",
            "Mad Max: Fury Road|Action|horror",
            "50 First Dates|Romance|datenight"
        );
        when(movieServiceMock.getPurchasedMovies(username)).thenReturn(mockMovies);
        
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieServiceMock);
        
        // Act
        List<String> romanceMovies = favoriteMovie.getFavoriteByGenre(username, genre);
        
        // Assert
        assertNotNull(romanceMovies);
        assertEquals(2, romanceMovies.size());
        assertTrue(romanceMovies.contains("The Notebook"));
        assertTrue(romanceMovies.contains("50 First Dates"));
        
        // Verify interaction
        verify(movieServiceMock).getPurchasedMovies(username);
    }
    
    @Test
    void testGetFavoriteByGenre_WhenServiceReturnsNull_ShouldReturnEmptyList() {
        // Arrange
        MovieService movieServiceMock = mock(MovieService.class);
        String username = "alice";
        when(movieServiceMock.getPurchasedMovies(username)).thenReturn(null);
        
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieServiceMock);
        
        // Act
        List<String> movies = favoriteMovie.getFavoriteByGenre(username, "Action");
        
        // Assert
        assertNotNull(movies);
        assertTrue(movies.isEmpty());
        
        // Verify method was called
        verify(movieServiceMock).getPurchasedMovies(username);
    }
    
    @Test
    void testGetFavoriteByGenre_CaseInsensitive_ShouldWork() {
        // Arrange
        MovieService movieServiceMock = mock(MovieService.class);
        String username = "alice";
        List<String> mockMovies = Arrays.asList(
            "Mad Max: Fury Road|ACTION|horror",
            "John Wick|action|horror"
        );
        when(movieServiceMock.getPurchasedMovies(username)).thenReturn(mockMovies);
        
        FavoriteMovie favoriteMovie = new FavoriteMovie(movieServiceMock);
        
        // Act
        List<String> actionMovies = favoriteMovie.getFavoriteByGenre(username, "Action");
        
        // Assert
        assertNotNull(actionMovies);
        assertEquals(2, actionMovies.size());
        assertTrue(actionMovies.contains("Mad Max: Fury Road"));
        assertTrue(actionMovies.contains("John Wick"));
        
        verify(movieServiceMock).getPurchasedMovies(username);
    }
}