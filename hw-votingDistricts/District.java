import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

/**
 * Represents all composite districts in the election
 * @author Kiran Rao
 * @version 1.0 Dec. 4 2015
 */
public class District {

    private String name;

    /**
     * Constructs a District object using instance variables
     * @param name    The name of the composite district
     */
    public District(String name) {
        this.name = name;
    }

    /**
     * Retrieves the instance variable representing
        the composite district's name
     * @return a String of the composite district's name
     */
    public String getName() {
        return name;
    }

    /**
     * Determines whether or not the current district is local
     * @param fileName    The name of the file that corresponds
        certain voters to certain local districts
     * @throws Exception   If the file is not found
     * @return A boolean depicting whether or not the district is local
     */
    public boolean isLocal(String fileName) throws Exception {
        Scanner ldFile = new Scanner(new File(fileName));
        while (ldFile.hasNext()) {
            String currentLine = ldFile.nextLine();
            String[] currentLineArray = currentLine.split(":");
            if (name.equals(currentLineArray[0])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves all local districts in the election and stores them in a list
     * @param fileName1    The name of the file that corresponds
        certain voters to certain local districts
     * @throws Exception   If the file is not found
     * @return A list of all local districts in the election
     */
    public List<LocalDistrict> getAllLocalDistricts(String fileName1)
        throws Exception {
        List<LocalDistrict> localDistricts = new ArrayList<>();
        Scanner ldFile = new Scanner(new File(fileName1));
        while (ldFile.hasNext()) {
            String currentLine = ldFile.nextLine();
            String[] currentLineArray = currentLine.split(":");
            String ldName = currentLineArray[0];
            LocalDistrict lowerDistrictLD = new LocalDistrict(ldName);
            localDistricts.add(lowerDistrictLD);
        }
        return localDistricts;
    }

    /**
     * Retrieves the local districts part of
        the composite district and stores them in a list
     * @param fileName1    The name of the file that corresponds
        composite districts to local districts
     * @param fileName2    The name of the file that corresponds
        certain voters to certain local districts
     * @throws Exception   If the file is not found
     * @return A list of local districts belonging to the composite district
     */
    public List<LocalDistrict> getLocalDistricts(String fileName1,
        String fileName2) throws Exception {
        List<LocalDistrict> localDistricts = new ArrayList<>();
        Scanner districtFile = new Scanner(new File(fileName1));
        districtFile.nextLine();
        while (districtFile.hasNext()) {
            String currentLine = districtFile.nextLine();
            String[] currentLineArray = currentLine.split(":");
            if (name.equals(currentLineArray[0])) {
                String[] lowerStringArray = currentLineArray[1].split(",");
                for (String s : lowerStringArray) {
                    String sNew = s.trim();
                    District lowerDistrictD = new District(sNew);
                    if (lowerDistrictD.isLocal(fileName2)) {
                        LocalDistrict lowerDistrictLD = new LocalDistrict(sNew);
                        localDistricts.add(lowerDistrictLD);
                    } else {
                        localDistricts.addAll(lowerDistrictD
                            .getLocalDistricts(fileName1, fileName2));
                    }
                }
            }
        }
        return localDistricts;
    }

    /**
     * Initializes all local districts part of a list of
        local districts to determine their instance variables
     * @param lds          A list of local districts belonging
        to the composite district
     * @param fileName1    The name of the file that corresponds
        certain voters to certain local districts
     * @param fileName2    The name of the file that corresponds
        certain voters to the candidates they voted for
     * @throws Exception   If the file is not found
     */
    public void initializeLDs(List<LocalDistrict> lds,
        String fileName1, String fileName2) throws Exception {
        for (LocalDistrict ld : lds) {
            if (ld.getVoteWeight() == 0) {
                ld.initialize(fileName1, fileName2);
            }
        }
    }

    /**
     * Calculates the election results of the local districts in a list
     * @param localDistricts          A list of local districts belonging
        to the composite district
     * @return A string array representing which candidate won which
        local district and their score
     */
    public String[] getLocalResults(List<LocalDistrict> localDistricts) {
        String[] ldResults = new String[localDistricts.size()];
        int counter = 0;
        for (LocalDistrict ld : localDistricts) {
            ldResults[counter] = (ld.getWinner() + " wins the district of "
                + ld.getName() + " with a score of " + ld.getVoteWeight());
            ++counter;
        }
        return ldResults;
    }

    /**
     * Calculates the total score for the composite district
        by the number of voters
     * @param localDistricts          A list of local districts belonging
        to the composite district
     * @return An int representing the total number of voters,
        and therefore the score, of the composite district
     */
    public int totalDistrictVotes(List<LocalDistrict> localDistricts) {
        int total = 0;
        for (LocalDistrict ld : localDistricts) {
            total = total + ld.getVoteWeight();
        }
        return total;
    }

    /**
     * Determines the winning candidate of the composite district
     * @param localDistricts          A list of local districts belonging
        to the composite district
     * @return An String representing the name of the winning
        candidate of the composite district
     */
    public String findWinner(List<LocalDistrict> localDistricts) {
        Map<String, Integer> mappedDistricts = new HashMap<>();
        for (LocalDistrict ld : localDistricts) {
            if (!mappedDistricts.containsKey(ld.getWinner())) {
                mappedDistricts.put(ld.getWinner(), ld.getVoteWeight());
            } else {
                mappedDistricts.put(ld.getWinner(),
                    (mappedDistricts.get(ld.getWinner()) + ld.getVoteWeight()));
            }
        }
        Set<Map.Entry<String, Integer>> districtSet = mappedDistricts
            .entrySet();
        String[] winnerNameArray = new String[districtSet.size()];
        int[] totalVoteArray = new int[districtSet.size()];
        int counter = 0;
        for (Map.Entry<String, Integer> entry : districtSet) {
            winnerNameArray[counter] = entry.getKey();
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
        return winnerNameArray[largestIndex];
    }

}
