package eng.collections;

public class PublishedMovie extends Movie {
  private int year;

  public PublishedMovie(String title, int year){
    super(title);
    this.year = year;
  }

  public int getYear() {
    return year;
  }
}
