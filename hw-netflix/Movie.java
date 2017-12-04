import java.util.Collection;

/**
 * Represents an individual movie
 * @author Kiran Rao
 * @version 1.0 Nov. 6 2015
 */
public class Movie implements Comparable<Movie> {

    private String name;
    private double rating;
    private int year;
    private Collection<Genre> genres;

    /**
     * Constructs a Movie object using instance variables
     * @param name    A String representing the name of the movie
     * @param rating  An double representing the rating of the movie
     * @param year    An int representing the release year of the movie
     * @param genres  An Collection representing the genre(s) of the movie
     */
    public Movie(String name, double rating
        , int year, Collection<Genre> genres) {
        this.name = name;
        this.rating = rating;
        this.year = year;
        this.genres = genres;
    }

    /**
     * Retrives the name of the movie
     * @return the string representing the name of the movie
     */
    public String getName() {
        return name;
    }

    /**
     * Retrives the rating of the movie
     * @return the double representing the rating of the movie
     */
    public double getRating() {
        return rating;
    }

    /**
     * Retrives the release year of the movie
     * @return the int representing the release year of the movie
     */
    public int getYear() {
        return year;
    }

    /**
     * Retrives the genre(s) of the movie
     * @return the Collection representing the genre(s) of the movie
     */
    public Collection<Genre> getGenres() {
        return genres;
    }

    /**
     * Overrides the equals method to compare the current
        movie to another object
     * @param o  The other object being compared to the current object
     * @return a boolean representing if the objects are equal
        according to the new equals() method
     */
    public boolean equals(Object o) {
        if (!(o == null)) {
            if (o instanceof Movie) {
                Movie other = (Movie) o;
                if (this.getName().equals(other.getName())) {
                    if (this.getRating() == other.getRating()) {
                        if (this.getYear() == other.getYear()) {
                            if (this.getGenres().equals(other.getGenres())) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Overrides the hashCode method to be be consistent
        with overridden equals() method
     * @return an int value for a hashCode overwrite
     */
    public int hashCode() {
        int result = 17;
        result = 31 * result + getName().hashCode() + (int) getRating()
            + getYear() + getGenres().hashCode();
        return result;
    }

    /**
     * Summarizes all the properties used to create a Movie object
     * @return a String that displays the instance variables of the Movie object
     */
    public String toString() {
        return name + " (" + year + ") - " + rating;
    }

    /**
     * Compares the names of two Movie objects alphabetically
     * @param other  The other Movie being compared to the current Movie
     * @return an int representing whether or not the other movie is before,
        equal to, or after the current movie alphabetically
     */
    public int compareTo(Movie other) {
        return this.getName().compareTo(other.getName());
    }

}
