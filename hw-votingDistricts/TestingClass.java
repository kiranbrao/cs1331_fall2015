import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents the testing class that houses the
        main method for testing the election results
 * @author Kiran Rao
 * @version 1.0 Dec. 4 2015
 */
public class TestingClass {

    /**
     * Main method
     * @param args          Default parameter for main method
     * @throws Exception   If the file is not found
     */
    public static void main(String[] args) throws Exception {
        System.out.println("FIRST, LET'S LOOK AT A SINGLE LOCAL DISTRICT.");
        LocalDistrict fulton = new LocalDistrict("Fulton");
        System.out.println("THE LOCAL DISTRICT WE'RE LOOKING AT IS THE "
            + fulton.getName() + " DISTRICT");
        System.out.println("THESE ARE THE VOTERS IN THE "
            + fulton.getName() + " DISTRICT:");
        List<Voter> fultonVoterList = fulton.getVoters("local_districts.txt",
            "voters.txt");
        for (Voter voter : fultonVoterList) {
            System.out.println(voter.getName());
        }
        System.out.println("THE WEIGHTED VOTES OF THESE VOTERS ARE:");
        Map<String, Integer> mapFultonVoters = new HashMap<>();
        mapFultonVoters = fulton.mapVoters(fultonVoterList);
        for (String s : mapFultonVoters.keySet()) {
            System.out.println(s + " " + mapFultonVoters.get(s));
        }
        System.out.println("AND OF THESE CANDIDATES, LET'S FIND OUT WHO WON!");
        System.out.println("The winner of the " + fulton.getName()
            + " district is " + fulton.findWinner(mapFultonVoters)
            + " with a score of " + fulton.getVoteWeight() + ".");

        System.out.println("NOW LET'S LOOK AT A COMPOSITE DISTRICT.");
        District orange = new District("Orange");
        System.out.println("THE COMPOSITE DISTRICT WE'RE LOOKING AT IS THE "
            + orange.getName() + " DISTRICT");
        System.out.println("THE " + orange.getName()
            + " DISTRICT IS COMPOSED OF THE FOLLOWING LOCAL DISTRICTS:");
        List<LocalDistrict> orangeLocalDistrict
            = orange.getLocalDistricts("districts.txt", "local_districts.txt");
        for (LocalDistrict ld : orangeLocalDistrict) {
            System.out.println(ld.getName());
        }
        orange.initializeLDs(orangeLocalDistrict, "local_districts.txt",
             "voters.txt");
        System.out.println("THE VOTING RESULTS OF THESE "
            + "LOCAL DISTRICTS ARE AS FOLLOWS:");
        String[] orangeResultArray
            = orange.getLocalResults(orangeLocalDistrict);
        for (String s : orangeResultArray) {
            System.out.println(s);
        }
        System.out.println("THEREFORE, THE WINNER OF THESE "
            + orangeResultArray.length
            + " LOCAL DISTRICTS, AND THE COMPOSITE DISTRICT OF "
            + orange.getName() + " AS A WHOLE IS "
            + orange.findWinner(orangeLocalDistrict) + " WITH A SCORE OF "
            + orange.totalDistrictVotes(orangeLocalDistrict) + ".");

        System.out.println("LET'S LOOK AT AN ENTIRE STATE NOW.");
        District indiana = new District("Indiana");
        System.out.println("THE STATE WE'RE LOOKING AT IS "
            + indiana.getName());
        List<LocalDistrict> indianaLocalDistrict
            = indiana.getLocalDistricts("districts.txt", "local_districts.txt");
        System.out.println("THE STATE OF " +  indiana.getName()
            + ", WHEN BROKEN DOWN, CONSISTS OF "
            + indianaLocalDistrict.size()
            + " LOCAL DISTRICTS. THEY ARE AS FOLLOWS:");
        for (LocalDistrict ld : indianaLocalDistrict) {
            System.out.println(ld.getName());
        }
        indiana.initializeLDs(indianaLocalDistrict,
            "local_districts.txt", "voters.txt");
        System.out.println("THE VOTING RESULTS OF THESE LOCAL DISTRICTS"
            + " ARE AS FOLLOWS:");
        String[] indianaResultArray
            = indiana.getLocalResults(indianaLocalDistrict);
        for (String s : indianaResultArray) {
            System.out.println(s);
        }
        System.out.println("MY CUSTOM MERGE SORT IS IMPLEMENTED BELOW"
            + " AND ALPHABETIZES THE LOCAL DISTRICT RESULTS SHOWN ABOVE.");
        CustomMergeSort cms = new CustomMergeSort();
        cms.mergeSort(indianaResultArray);
        for (String s : indianaResultArray) {
            System.out.println(s);
        }
        System.out.println("THEREFORE, THE WINNER OF THESE "
            + indianaResultArray.length
            + " LOCAL DISTRICTS, AND THE STATE OF "
            + indiana.getName() + " AS A WHOLE IS "
            + indiana.findWinner(indianaLocalDistrict) + " WITH A SCORE OF "
            + indiana.totalDistrictVotes(indianaLocalDistrict) + ".");

        System.out.println("NOW LET'S LOOK AT THE ENTIRE ELECTION AS A WHOLE.");
        District us = new District("United States");
        List<LocalDistrict> allLocalDistricts = new ArrayList<>();
        allLocalDistricts = us.getAllLocalDistricts("local_districts.txt");
        System.out.println("THERE ARE " + allLocalDistricts.size()
            + " LOCAL DISTRICTS PARTICIPATING IN THIS ELECTION. THEY ARE:");
        for (LocalDistrict ld : allLocalDistricts) {
            System.out.println(ld.getName());
        }
        us.initializeLDs(allLocalDistricts, "local_districts.txt",
            "voters.txt");
        System.out.println("THE VOTING RESULTS OF ALL LOCAL DISTRICTS"
            + " ARE AS FOLLOWS:");
        String[] usResultArray = us.getLocalResults(allLocalDistricts);
        for (String s : usResultArray) {
            System.out.println(s);
        }
        System.out.println("MY CUSTOM MERGE SORT IS IMPLEMENTED BELOW"
            + " AND ALPHABETIZES THE LOCAL DISTRICT RESULTS SHOWN ABOVE.");
        CustomMergeSort cms2 = new CustomMergeSort();
        cms2.mergeSort(usResultArray);
        for (String s : usResultArray) {
            System.out.println(s);
        }
        System.out.println("THEREFORE, THE WINNER OF THE "
            + usResultArray.length
            + " LOCAL DISTRICTS, AND THE ENTIRE ELECTION IS "
            + us.findWinner(allLocalDistricts) + " WITH A SCORE OF "
            + us.totalDistrictVotes(allLocalDistricts) + ".");
    }
}
