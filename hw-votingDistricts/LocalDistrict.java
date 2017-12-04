import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Represents all local districts in the election
 * @author Kiran Rao
 * @version 1.0 Dec. 4 2015
 */
public class LocalDistrict {

    private String name;
    private List<Voter> voters;
    private Map<String, Integer> voteCount;
    private String winner;
    private int weight;

    /**
     * Constructs a LocalDistrict object using instance variables
     * @param name    The name of the local district
     */
    public LocalDistrict(String name) {
        this.name = name;
        voters = new ArrayList<>();
    }

    /**
     * Retrieves the instance variable representing the local district's name
     * @return a String of the local district's name
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the voters part of the local district and stores them in a list
     * @param fileName    The name of the file that corresponds
        certain voters to certain local districts
     * @param fileName2    The name of the file that corresponds
        certain voters to the candidates they voted for
     * @throws Exception   If the file is not found
     * @return A list of voters belonging to the local district
     */
    public List<Voter> getVoters(String fileName, String fileName2)
        throws Exception {
        Scanner ldFile = new Scanner(new File(fileName));
        while (ldFile.hasNext()) {
            String currentLine = ldFile.nextLine();
            String[] currentLineArray = currentLine.split(":");
            String ldName = currentLineArray[0];
            if (name.equals(ldName)) {
                String[] votersStrArray = currentLineArray[1].split(",");
                for (String voter : votersStrArray) {
                    String currentVoter = voter.trim();
                    Scanner voterFile = new Scanner(new File(fileName2));
                    while (voterFile.hasNext()) {
                        String currentVoterLine = voterFile.nextLine();
                        if (currentVoter
                            .equals(getVoterName(currentVoterLine))) {
                            String[] currentVoterVotes
                                = getVoterVotes(currentVoterLine);
                            Voter thisVoter
                                = new Voter(currentVoter, currentVoterVotes);
                            voters.add(thisVoter);
                        }
                    }
                }
            }
        }
        return voters;
    }

    /**
     * Calcualtes and retrives the score (number of voters) in
        the local district
     * @return The value representing the number of voters in
        the local district
     */
    public int getVoteWeight() {
        weight = voters.size();
        return voters.size();
    }

    /**
     * Calcualates the result of the voters' votes by corresponding
        chosen candidates to their scores
     * @param voterList    A list of voters belonging to the local district
     * @return A map that corresponds chosen candidates to their scores
     */
    public Map<String, Integer> mapVoters(List<Voter> voterList) {
        Map<String, Integer> mappedVoters = new HashMap<>();
        for (Voter voter : voterList) {
            if (!mappedVoters.containsKey(voter.getFirstVote())) {
                mappedVoters.put(voter.getFirstVote(), 3);
            } else {
                mappedVoters.put(voter.getFirstVote(),
                    (mappedVoters.get(voter.getFirstVote()) + 3));
            }

            if (!mappedVoters.containsKey(voter.getSecondVote())) {
                mappedVoters.put(voter.getSecondVote(), 2);
            } else {
                mappedVoters.put(voter.getSecondVote(),
                    (mappedVoters.get(voter.getSecondVote()) + 2));
            }

            if (!mappedVoters.containsKey(voter.getThirdVote())) {
                mappedVoters.put(voter.getThirdVote(), 1);
            } else {
                mappedVoters.put(voter.getThirdVote(),
                    (mappedVoters.get(voter.getThirdVote()) + 1));
            }
        }
        voteCount = mappedVoters;
        return mappedVoters;
    }

    /**
     * Calcualates the result of the voters' votes by
        finding the winner of the local district
     * @param voterMap  A map that corresponds chosen candidates to their scores
     * @return A String representing the name of the winning
        candidate for the local district
     */
    public String findWinner(Map<String, Integer> voterMap) {
        Set<Map.Entry<String, Integer>> voterSet = voterMap.entrySet();
        String[] voterNameArray = new String[voterSet.size()];
        int[] totalVoteArray = new int[voterSet.size()];
        int counter = 0;
        //System.out.print(voterSet.size());
        for (Map.Entry<String, Integer> entry : voterSet) {
            voterNameArray[counter] = entry.getKey();
            totalVoteArray[counter] = entry.getValue();
            ++counter;
        }
        int largestVal = 0;
        int largestIndex = 0;
        for (int i = 0; i < (totalVoteArray.length); i++) {
            if (totalVoteArray[i] >= largestVal) {
                largestVal = totalVoteArray[i];
                largestIndex = i;
            }
        }
        winner = voterNameArray[largestIndex];
        return voterNameArray[largestIndex];
    }

    /**
     * Retrieves the name of the winning candidate for the local district
     * @return A String representing the name of the winning
        candidate for the local district
     */
    public String getWinner() {
        return winner;
    }

    /**
     * Initializes a local district by running the getVoters,
         mapVoters, findWinner, and getVoteWeight methods
     * @param fileName1    The name of the file that corresponds
        certain voters to certain local districts
     * @param fileName2    The name of the file that corresponds
        certain voters to the candidates they voted for
     * @throws Exception   If the file is not found
     */
    public void initialize(String fileName1, String fileName2)
        throws Exception {
        getVoters(fileName1, fileName2);
        mapVoters(voters);
        findWinner(voteCount);
        getVoteWeight();
    }

    /**
     * Parses through a line of the voter text file and returns
        the name of a voter
     * @param currentLine  A String representing the current line of the voter
        text file
     * @return A String representing the name of the voter for a local district
     */
    public static String getVoterName(String currentLine) {
        String[] nameSplit = currentLine.split(":");
        return nameSplit[0];
    }

    /**
     * Parses through a line of the voter text file and returns
        the candidates that the voter voted for
     * @param currentLine  A String representing the current line of the voter
        text file
     * @return A String array representing the names of
        the candidate that the voter voted for
     */
    public static String[] getVoterVotes(String currentLine) {
        String[] nameSplit = currentLine.split(":");
        String[] voteSplit = nameSplit[1].split(",");
        for (int i = 0; i < voteSplit.length; i++) {
            voteSplit[i] = voteSplit[i].trim();
        }
        return voteSplit;
    }
}
