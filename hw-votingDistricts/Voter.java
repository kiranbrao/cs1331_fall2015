/**
 * Represents all individual voters belonging to local districts
 * @author Kiran Rao
 * @version 1.0 Dec. 4 2015
 */
public class Voter {

    private String name;
    private String[] votes;

    /**
     * Constructs a Voter object using instance variables
     * @param name    The name of the voter
     * @param votes    The candidates that the voter has voted for
     */
    public Voter(String name, String[] votes) {
        this.name = name;
        this.votes = votes;
    }

    /**
     * Retrieves the instance variable representing the voter's name
     * @return a String of the voter's name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the instance variable representing the candidates
        that the voter has voted for
     * @return a String array of the candidates that the voter has voted for
     */
    public String[] getVotes() {
        return votes;
    }

    /**
     * Retrieves the top candidate that the voter has voted for
     * @return a String representing the top candidate
        that the voter has voted for
     */
    public String getFirstVote() {
        return votes[0];
    }

    /**
     * Retrieves the second candidate that the voter has voted for
     * @return a String representing the second candidate
        that the voter has voted for
     */
    public String getSecondVote() {
        return votes[1];
    }

    /**
     * Retrieves the third candidate that the voter has voted for
     * @return a String representing the third candidate
        that the voter has voted for
     */
    public String getThirdVote() {
        return votes[2];
    }
}
