package eng.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

public class MoviesSet extends HashSet<Movie> {

  private String lastTitle;
  private Optional<Movie> lastTitleResult;
  private Integer lastSetYear;
  private Set<Movie> lastSetYearResult;

  private static boolean areMovieTitlesEqual(String title, String anotherTitle) {
    return anotherTitle.equals(title);
  }

  public Optional<Movie> getByTitle(String title) {
    if (this.lastTitle != null && this.lastTitle.equals(title))
      return lastTitleResult;

    Optional<Movie> ret = Optional.empty();

    for (Movie movie : this) {
      if (areMovieTitlesEqual(title, movie.getTitle())) {
        ret = Optional.of(movie);
        break;
      }
    }

    this.lastTitle = title;
    this.lastTitleResult = ret;

    return ret;
  }

  public Set<Movie> getByYear(int year) {
    if (this.lastSetYear != null && this.lastSetYear == year)
      return new HashSet<>(lastSetYearResult);

    Set<Movie> ret = new HashSet<>();

    for (Movie movie : this) {
      if (movie.getYear() == year) {
        ret.add(movie);
      }
    }

    this.lastSetYear = year;
    this.lastSetYearResult = ret;

    return new HashSet<>(ret);
  }

  @Override
  public boolean add(Movie movie) {
    clearCache();
    return super.add(movie);
  }

  private void clearCache() {
    this.lastTitle = null;
    this.lastTitleResult = null;
    this.lastSetYear = null;
    this.lastSetYearResult = null;
  }

  @Override
  public boolean remove(Object o) {
    clearCache();
    return super.remove(o);
  }

  @Override
  public void clear() {
    clearCache();
    super.clear();
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    clearCache();
    return super.removeAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends Movie> c) {
    clearCache();
    return super.addAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    clearCache();
    return super.retainAll(c);
  }

  @Override
  public boolean removeIf(Predicate<? super Movie> filter) {
    clearCache();
    return false;
  }
}
