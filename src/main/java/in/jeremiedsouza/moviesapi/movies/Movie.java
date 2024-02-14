package in.jeremiedsouza.moviesapi.movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "MOVIES")
@Data // creates getters and setters (lombok dependency)
@AllArgsConstructor // creates a constructor to take all class variables as param
@NoArgsConstructor // creates no param constructor
public class Movie {

  @Id
  private ObjectId id;
  private String imdbId;
  private String title;
  private String releaseDate;
  private String trailerLink;
  private String poster;
  private List<String> genres;
  private List<String> backdrops;

  @DocumentReference // manual reference relationship
  private List<Review> reviewIds;
}
