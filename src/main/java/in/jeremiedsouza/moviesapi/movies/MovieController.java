package in.jeremiedsouza.moviesapi.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin
public class MovieController {

  @Autowired
  private MovieService movieService;

  @GetMapping
  public ResponseEntity<List<Movie>> getAllMovies() {
    return new ResponseEntity<List<Movie>>(movieService.allMovies(), null, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id) {
    return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByObjectId(id), null, HttpStatus.OK);
  }

  @GetMapping("/imdb/{id}")
  public ResponseEntity<Optional<Movie>> getSingleMovieByImdbId(@PathVariable String id) {
    return new ResponseEntity<Optional<Movie>>(movieService.singleMovieByImdbId(id), null, HttpStatus.OK);
  }
}
