import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.io.PrintStream;

public class Person {

    private String personName;
    private Goal[] goals;

    public static Goal[] displayGoalTasksRead(String nameMatch)
        throws Exception {
        Scanner personFile = new Scanner(new File(nameMatch + ".csv"));
        String mainOutput = "";
        Goal[] personGoals = new Goal[10];
        int goalCounter = 0;
        while (personFile.hasNext()) {
            String currentLine = personFile.nextLine();
            String[] currentLineArray = currentLine.split(",");
            Goal currentGoal = new Goal();
            String goalString = "";
            String taskString = "";
            currentGoal.setGoalName(currentLineArray[0]);
            int totalCompleteCounter = 0;
            Task[] currentGoalTasks = new Task[10];
            for (int j = 1; j < (currentLineArray.length); ++j) {
                String[] taskInfo = currentLineArray[j].split("\\|");
                String name = taskInfo[0].trim();
                int priority = Integer.parseInt(taskInfo[1].trim());
                String[] dateArray = taskInfo[2].split("T");
                String date = dateArray[0].trim();
                String time = dateArray[1].trim();
                LocalDateTime dateAndTime = LocalDateTime
                    .parse(taskInfo[2].trim());
                String completeness = taskInfo[3].trim();
                boolean complete;
                String taskComplete = "";
                String priorityDescription = "";
                if (completeness.equals("true")) {
                    complete = true;
                    taskComplete = "Complete";
                    totalCompleteCounter++;
                } else {
                    taskComplete = "Incomplete";
                    complete = false;
                }
                if (priority < 4) {
                    priorityDescription = "Low Priority";
                } else if ((priority >= 4) && (priority <= 6)) {
                    priorityDescription = "Medium Priority";
                } else {
                    priorityDescription = "High Priority";
                }
                taskString = taskString +  "    - "
                    + name + " - " + priorityDescription
                    +  " - " + "due " + date + " " + time + " - "
                    + taskComplete + "\n";
                Task currentTask = new Task(name, priority
                    , dateAndTime, complete);
                currentGoalTasks[(j - 1)] = currentTask;
            }
            String goalComplete = "";
            if (totalCompleteCounter == ((currentLineArray.length) - 1)) {
                goalComplete = "Complete";
            } else {
                goalComplete = "Incomplete";
            }
            goalString = goalString + currentLineArray[0]
                + " - " + goalComplete + "\n";
            mainOutput = mainOutput + goalString + taskString;
            currentGoal.setTasks(currentGoalTasks);
            personGoals[goalCounter] = currentGoal;
            goalCounter++;
        }
        System.out.print("\nGoals:\n" + mainOutput);
        return personGoals;
    }

    public void setPersonGoals(Goal[] setGoals) {
        goals = setGoals;
    }

    public Goal[] getPersonGoals() {
        return goals;
    }

    public void addPersonGoal(Goal goal) {
        int goalIndex = 0;
        int fullCounter = 0;
        if (goals[0] == null) {
            goals[0] = goal;
        } else {
            while (goals[goalIndex] != null) {
                goalIndex++;
                fullCounter++;
            }
            goals[fullCounter] = goal;
        }
    }

    public void writeNew(PrintStream ps, String fileName) throws Exception {
        ps = new PrintStream(new FileOutputStream((fileName), false));
        String currentLine = "";
        int i = 0;
        int j = 0;
        Task[] currentTaskArray;
        String taskLine;
        while (goals[i] != null) {
            currentTaskArray = goals[i].getTasks();
            currentLine = (goals[i].returnGoalName());
            j = 0;
            while (currentTaskArray[j] != null) {
                taskLine = (", " + currentTaskArray[j].task2String());
                currentLine = (currentLine + taskLine);
                j++;
            }
            ps.println(currentLine);
            i++;
        }
    }
}
