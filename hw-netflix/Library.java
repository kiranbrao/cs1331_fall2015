import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Represents a collection of all movies
 * @author Kiran Rao
 * @version 1.0 Nov. 6 2015
 */
public class Library {

    private List<Movie> movies;

    /**
     * Constructs a Library object using instance variables
     * @param newMovies     A list of new movies to be added to the library
     */
    public Library(List<Movie> newMovies) {
        movies = new ArrayList<>();
        movies.addAll(newMovies);
    }

    static class LowRatingFirst implements Comparator<Movie> {
        public int compare(Movie a, Movie b) {
            return (-1) * ((int) a.getRating() - (int) b.getRating());
        }
    }

    static class HighRatingFirst implements Comparator<Movie> {
        public int compare(Movie a, Movie b) {
            return (int) a.getRating() - (int) b.getRating();
        }
    }

    static class Alphabetize implements Comparator<Movie> {
        public int compare(Movie a, Movie b) {
            return a.compareTo(b);
        }
    }

    /**
     * Sorts movies of the library in alphabetical order
     * @return a List of all movies in the library sorted alphabetically
     */
    public List<Movie> listAlphabetically() {
        List<Movie> moviesCopy = new ArrayList<>();
        moviesCopy.addAll(movies);
        Collections.sort(moviesCopy, new Alphabetize());
        return moviesCopy;
    }

    /**
     * Finds and returns movies in the library of specific genres
     * @param genres - a Collection of the genres of interest
     * @return a List of all movies in the library of the genres of interest
     */
    public List<Movie> moviesWithGenre(Collection<Genre> genres) {
        List<Movie> moviesCopy = new ArrayList<>();
        for (Genre genre : genres) {
            for (Movie movie : movies) {
                if ((movie.getGenres().contains(genre))) {
                    moviesCopy.add(movie);
                }
            }
        }
        return moviesCopy;
    }

    /**
     * Finds and returns movies in the library made between certain years
     * @param lowYear - an int representing the low year cutoff (inclusive)
     * @param highYear - an int representing the high year cutoff (exclusive)
     * @return a list of all movies in the library between the time period
     */
    public List<Movie> listByYearRange(int lowYear, int highYear) {
        List<Movie> moviesCopy = new ArrayList<>();
        for (Movie movie : movies) {
            if ((movie.getYear() >= lowYear) && (movie.getYear() < highYear)) {
                moviesCopy.add(movie);
            }
        }
        return moviesCopy;
    }

    /**
     * Sorts movies of the library in order of lowest rating to highest rating
     * @return a List of all movies in the library sorted from lowest
        to highest rating
     */
    public List<Movie> listByLowestRating() {
        List<Movie> moviesCopy = new ArrayList<>();
        moviesCopy.addAll(movies);
        Collections.sort(moviesCopy, new LowRatingFirst());
        return moviesCopy;
    }

    /**
     * Sorts movies of the library in order of highest rating to lowest rating
     * @return a List of all movies in the library sorted from highest
        to lowest rating
     */
    public List<Movie> listByHighestRating() {
        List<Movie> moviesCopy = new ArrayList<>();
        moviesCopy.addAll(movies);
        Collections.sort(moviesCopy, new HighRatingFirst());
        return moviesCopy;
    }

}
