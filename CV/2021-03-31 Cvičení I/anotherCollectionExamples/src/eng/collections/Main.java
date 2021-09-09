package eng.collections;

import java.util.List;
import java.util.Locale;

public class Main {

  public static void main(String[] args) {
    // task 2
    List<Movie> movies = new DistinctList<Movie>(new MovieTitleEquality());
    List<Movie> movie2 = new DistinctList<Movie>(new MovieYearEquality());

    List<Movie> movie3 = new DistinctList<>((a, b) -> a.getTitle().equals(b.getTitle()));

    List<Movie> movie4 = new DistinctList<>((a, b) -> a.getTitle().charAt(a.getTitle().length()-1) == b.getTitle().charAt(b.getTitle().length()-1));

    movies.add(new Movie("Matrix", 1995));
    movies.add(new Movie("Forrest Gump", 1994));
    movies.add(new Movie("Sedm", 1995));
    movies.add(new Movie("Temný rytíř", 2008));
    movies.add(new Movie("Matrix", 1995));
    movies.add(new Movie("Temný rytíř", 2008));

    // task 1
//    MoviesSet movies = new MoviesSet();
//
//    movies.add(new Movie("Matrix", 1995));
//    movies.add(new Movie("Forrest Gump", 1994));
//    movies.add(new Movie("Sedm", 1995));
//    movies.add(new Movie("Temný rytíř", 2008));
//
//    Optional<Movie> m = movies.getByTitle("Sedm");
//
//    Set<Movie> oldMovies = movies.getByYear(1980);
//    movies.removeAll(oldMovies);
//    oldMovies = movies.getByYear(1980);
//    oldMovies.add(new Movie("Kmotr", 1972));
  }


}

class MovieTitleEquality implements Equality<Movie>{
  @Override
  public boolean areEqual(Movie a, Movie b) {
    return a.getTitle().equals(b.getTitle());
  }
}

class MovieYearEquality implements Equality<Movie>{
  @Override
  public boolean areEqual(Movie a, Movie b) {
    return a.getYear() == b.getYear();
  }
}
