from flask import Flask, request
from flask_restful import Resource, Api
from flasgger import Swagger

app = Flask(__name__)
api = Api(app)
swagger = Swagger(app)

Movie_data = [
    {"id":1,"list":["The Notebook", "50 First Dates", "A Walk to Remember"], "playlists":"datenight"},
    {"id":2,"list":["Die Hard", "Mad Max: Fury Road", "John Wick"], "playlists":"action"},
    {"id":3,"list":["Superbad", "Step Brothers", "The Hangover"], "playlists":"comedy"},
]

class Movie(Resource):
    def get(self):
        """ 
        Get a list of all Movie 
        ---
        responses:
          200:
            description: A list of Movie
        """
        return Movie_data, 200

    def post(self):
        """
        Create a new Movie
        ---
        parameters:
          - in: body
            name: Movie
            required: true
            schema: 
                id: Movie 
                required:
                    - list
                    - playlists
                properties: 
                    list: 
                        type: array
                        items:
                            type: string
                        description: The list of Movie names
                    playlists: 
                        type: string 
                        description: The playlists of the Movie
        responses:
            201:
                description: A new Movie created
            400:
                description: Bad request
        """
        data = request.get_json()

        # Basic validation
        if 'list' not in data or 'playlists' not in data:
            return {'message': 'Missing "list" or "playlists"'}, 400

        if not isinstance(data['list'], list):
            return {'message': '"list" must be a list of strings'}, 400

        new_id = Movie_data[-1]['id'] + 1
        new_Movie = {'id': new_id, 'list': data['list'], 'playlists': data['playlists']}
        Movie_data.append(new_Movie)
        return new_Movie, 201


class MovieByName(Resource):
    def get(self, name):
        """
        Get a Movie by name
        ---
        parameters:
          - name: name
            in: path
            type: string
            required: true
            description: The name of the Movie to search
        responses:
          200:
            description: Found a Movie
          404:
            description: Movie not found
        """
        # Search name case-insensitive in the list of names
        for movie in Movie_data:
            if any(n.lower() == name.lower() for n in movie['list']):
                return movie, 200

        return {'message': 'Movie not found'}, 404

# Routes 
api.add_resource(Movie, '/Movies')
api.add_resource(MovieByName, '/Movie/<string:name>')

if __name__ == '__main__':
    app.run(debug=True)
