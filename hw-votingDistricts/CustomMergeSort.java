/**
 * Represents a customized merge sort that sorts
     contents of a string array alphabetically
 * @author Kiran Rao
 * @version 1.0 Dec. 4 2015
 */
public class CustomMergeSort {

    /**
     * Recursively divides string array and compares individual elements
        before reconstructing in sorted order
     * @param names    A string array containing the strings
        to be sorted alphabetically
     */
    public static void mergeSort(String[] names) {
        if (names.length >= 2) {
            String[] leftEnd = new String[names.length / 2];
            String[] rightStart = new String[names.length - names.length / 2];

            for (int i = 0; i < leftEnd.length; i++) {
                leftEnd[i] = names[i];
            }

            for (int i = 0; i < rightStart.length; i++) {
                rightStart[i] = names[i + names.length / 2];
            }

            mergeSort(leftEnd);
            mergeSort(rightStart);
            merge(names, leftEnd, rightStart);
        }
    }

    /**
     * Recursively divides string array and compares individual elements
        before reconstructing in sorted order
     * @param names    A string array containing the strings
        to be sorted alphabetically
     * @param leftSide   The elements of the names string array
        to the left of the middle index
     * @param rightSide    The elements of the names string array
        to the right of the middle index
     */
    public static void merge(String[] names, String[] leftSide,
        String[] rightSide) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (b >= rightSide.length || (a < leftSide.length && leftSide[a]
                .compareToIgnoreCase(rightSide[b]) < 0)) {
                names[i] = leftSide[a];
                a++;
            } else {
                names[i] = rightSide[b];
                b++;
            }
        }
    }
}
