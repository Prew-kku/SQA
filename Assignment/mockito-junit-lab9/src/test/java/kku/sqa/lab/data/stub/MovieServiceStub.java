package kku.sqa.lab.data.stub;

import java.util.Arrays; import java.util.Collections; import java.util.List;

import kku.sqa.lab.api.MovieService;

public class MovieServiceStub implements MovieService {

@Override
public List<String> getPurchasedMovies(String username) {
    if ("alice".equalsIgnoreCase(username)) {

        return Arrays.asList(

            "The Notebook|Romance|datenight",
            "50 First Dates|Romance|datenight",
            "A Walk to Remember|Romance|datenight",
            "First Love|Romance|datenight",
            "The Lucky One|Romance|datenight",
            
            "Mad Max: Fury Road|Action|horror",
            "John Wick|Action|horror",

            "The Conjuring|Horror|horror"
        );
    }

    return Collections.emptyList();
}


}