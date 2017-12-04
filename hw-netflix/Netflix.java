import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Collection;

/**
 * Your Netflix journey begins here!
 *
 * @author Jayanth
 * @author Srijan
 * @author Kiran Rao
 * @version 1.0
 */
public class Netflix {

    private static Scanner in;
    private static PopulateNetflix popPop;
    private static Random rand;
    private static Library library;
    private static List<Movie> list;

    /**
     * Main method for Netflix. This produces the high-end login screen
     * for our Netflix service that took a team of experienced
     * UI designers to create.
     *
     * @param args command-line arguments for the program.
     * @throws Exception if an invalid numerical entry is present
        (NumberFormatException)
     */
    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
        popPop = new PopulateNetflix();
        library = new Library(popPop.getNetflixPopulation());

        Map<String, List<Movie>> userWatchLists = new HashMap<>();
        Collection<Genre> taylorsGenres = new MySet<>();
        taylorsGenres.add(Genre.COMEDY);
        Collection<Genre> georgesGenres = new MySet<>();
        georgesGenres.add(Genre.ACTION);
        georgesGenres.add(Genre.ADVENTURE);

        Library taylorsLibrary = new Library(library.listAlphabetically());
        Library georgesLibrary = new Library(library
            .moviesWithGenre(georgesGenres));

        int lowYear = 1980;
        int highYear = 2000;

        userWatchLists.put("Taylor", taylorsLibrary
            .moviesWithGenre(taylorsGenres));
        userWatchLists.put("George", georgesLibrary.listByHighestRating());
        userWatchLists.put("Sarah", library.listByYearRange(lowYear, highYear));

        boolean running = true;
        System.out.println("Welcome to your very own Netflix service!");
        while (running) {
            System.out.println("\nNow, who's watching tonight? [q to exit]");

            String response = in.nextLine();
            if (response.equals("q")) {
                System.out.println("Thanks for watching!");
                running = false;
            } else if (userWatchLists.containsKey(response)) {

                List<Movie> watchList = userWatchLists.get(response);

                int numMovies = -1;
                while (numMovies < 1) {
                    System.out.println("How many movies would you like"
                        + " to watch? (1 - 10)");
                    try {
                        numMovies = Integer.parseInt(in.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, please try again");
                    }
                }

                System.out.println("\nHere you go!\n");

                if (numMovies > watchList.size()) {
                    numMovies = watchList.size();
                }
                for (Movie m : watchList.subList(0, numMovies)) {
                    System.out.println(m);
                }
            } else {
                System.out.println("\nNetflix does not "
                    + "recognize that input\n");
            }
        }
    }
}
