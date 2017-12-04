import java.util.Scanner;
import java.io.File;

public class GradeHistogram {

    public static void main(String[] args) throws Exception {
        String csvName = args[0];
        int interval = 0;

        if (args.length < 2) {
            System.out.println("What bucket size would you like?");
            Scanner keyboard = new Scanner(System.in);
            interval = Integer.parseInt(keyboard.next());
        } else {
            interval = Integer.parseInt(args[1]);
        }

        Scanner csvFile = new Scanner(new File(csvName));
        String part2 = null;
        String noSpaces = null;
        double currentValue = 0;
        int numRows = ((100 / interval) + 1);
        int[] quantityArray = new int[numRows];

        while (csvFile.hasNext()) {
            int stepCoefficient = 0;
            String currentLine = csvFile.nextLine();
            String[] currentStrArray = currentLine.split(",");
            part2 = currentStrArray[1];
            noSpaces = part2.trim();
            currentValue = Double.parseDouble(noSpaces);
            while ((101 - ((stepCoefficient) * (interval))) > currentValue) {
                stepCoefficient++;
            }
            quantityArray[(stepCoefficient - 1)]++;
        }

        int i = 0;
        int currentStart = 100;
        int currentEnd = 100 - (interval - 1);
        while (currentStart >= 0) {
            if (interval == 1) {
                if (currentStart == 100) {
                    System.out.print(currentStart + " | ");
                } else if (currentStart > 9) {
                    System.out.print(" " + currentStart + " | ");
                } else {
                    System.out.print("  " + currentStart + " | ");
                }
            } else {
                if ((currentStart == 100) && (currentEnd > 9)) {
                    System.out.print(currentStart + " - " + currentEnd + " | ");
                } else if ((currentStart == 100) && (currentEnd < 10)) {
                    System.out.print(currentStart
                        + " -  " + currentEnd + " | ");
                } else if ((currentStart > 9) && (currentEnd > 9)) {
                    System.out.print(" " + currentStart
                        + " - " + currentEnd + " | ");
                } else if ((currentStart > 0) && (currentStart > 9)
                        && (currentEnd < 0)) {
                    System.out.print(" " + currentStart + " -  " + "0" + " | ");
                } else if ((currentStart > 0) && (currentStart < 10)
                        && (currentEnd < 0)) {
                    System.out.print("  " + currentStart
                        + " -  " + "0" + " | ");
                } else if ((currentStart == 0) && (currentEnd < 0)) {
                    System.out.print("  " + currentStart + " -  "
                        + "0" + " | ");
                } else if ((currentStart > 9) && (currentEnd < 10)) {
                    System.out.print(" " + currentStart
                        + " -  " + currentEnd + " | ");
                } else {
                    System.out.print("  " + currentStart + " -  "
                        + currentEnd + " | ");
                }
            }
            currentStart = (currentEnd - 1);
            currentEnd = currentStart - (interval - 1);
            int i2 = 1;
            String barCounter = "";
            while (i2 <= quantityArray[i]) {
                barCounter = barCounter + "[]";
                i2++;
            }
            i++;
            System.out.println(barCounter);
        }
    }
}
