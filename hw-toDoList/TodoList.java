import java.util.Scanner;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.io.PrintStream;

public class TodoList {
    public static void main(String[] args) throws Exception {
        Scanner usernameFile = new Scanner(new File("users.csv"));
        String currentName = usernameFile.nextLine();

        System.out.println("What is your username?");
        Scanner keyboard = new Scanner(System.in);
        String usernameInput = keyboard.next();
        String nameMatch = "";
        String[] currentNameArray = currentName.split(",");
        boolean foundName = false;
        Person currentPerson = new Person();

        for (int i = 0; i < (currentNameArray.length); ++i) {
            if (usernameInput.equals(currentNameArray[i].trim())) {
                nameMatch = currentNameArray[i].trim();
                foundName = true;
            }
        }

        if (!foundName) {
            System.out.println("Please try again with a valid username");
        } else {
            boolean existingFile;
            existingFile = new File(nameMatch + ".csv").exists();
            if (existingFile) {
                Goal[] currentPersonGoals = currentPerson
                        .displayGoalTasksRead(nameMatch);
                currentPerson.setPersonGoals(currentPersonGoals);
            } else {
                Goal[] currentPersonGoals = new Goal[10];
                currentPerson.setPersonGoals(currentPersonGoals);
            }
        }
        PrintStream ps = new PrintStream(new FileOutputStream((nameMatch
                        + ".csv"), true));
        boolean gucciOption = false;
        while (!gucciOption) {
            System.out.println("\nSelect an option and press Enter:\n"
                        + " [1] Add a goal\n"
                        + " [2] Add a task\n" + " [3] Edit a task\n"
                        + " [4] Show me my to-do list\n"
                        + " [5] Quit & Save\n");
            Scanner decision = new Scanner(System.in);
            int chosenOption = Integer.parseInt(decision.nextLine());
            if (chosenOption == 1) {
                //ps.FileOutputStream((nameMatch + ".csv"), true);
                System.out.println("What would you like to name your goal?");
                String gNameInput = decision.nextLine();
                Goal createdGoal = new Goal();
                createdGoal.setGoalName(gNameInput);
                currentPerson.addPersonGoal(createdGoal);
                System.out.println("Your goal has been added!");
            } else if (chosenOption == 2) {
                //ps.FileOutputStream((nameMatch + ".csv"), false);
                System.out.println("What would you like to name your task?");
                String tNameInput = decision.nextLine();
                System.out.println("On a scale of 1-10, how high is"
                        + " the priority of this task?");
                int tPriorityInput = Integer.parseInt(decision.nextLine());
                System.out.println("What day is this task due? (YYYY-MM-DD)");
                String tYearInput = decision.nextLine();
                System.out.println("What time is this task due?"
                        + " (HH:MM 24-hour clock)");
                String tHourInput = decision.nextLine();
                LocalDateTime tDueDateInput = LocalDateTime.parse(tYearInput
                        + "T" + tHourInput);
                System.out.println("Is this task complete?");
                Boolean tStatusInput;
                if (decision.nextLine().equalsIgnoreCase("yes")) {
                    tStatusInput = true;
                } else {
                    tStatusInput = false;
                }
                Task newTask = new Task(tNameInput, tPriorityInput
                        , tDueDateInput, tStatusInput);
                Goal[] goalArray = currentPerson.getPersonGoals();
                int goalIndex = 0;
                String allGoalNames = "";
                while (goalArray[goalIndex] != null) {
                    allGoalNames = allGoalNames + " (" + (goalIndex + 1) + ") "
                        + goalArray[goalIndex].returnGoalName() + "\n";
                    goalIndex++;
                }
                System.out.println("Which goal would you like to add this"
                        + " task to? (enter number)");
                System.out.println(allGoalNames);
                int selectedGoalNum = Integer.parseInt(decision.nextLine());
                if (selectedGoalNum <= (goalIndex + 1)) {
                    goalArray[(selectedGoalNum - 1)].addTask(newTask);
                    System.out.println("Task added to goal!");
                } else {
                    System.out.println("Entered value is not valid");
                }
            } else if (chosenOption == 3) {
                Goal[] goalArrayEdit = currentPerson.getPersonGoals();
                int goalIndexEdit = 0;
                String allGoalNamesEdit = "";
                while (goalArrayEdit[goalIndexEdit] != null) {
                    allGoalNamesEdit = allGoalNamesEdit + " (" + (goalIndexEdit
                        + 1) + ") " + goalArrayEdit[goalIndexEdit]
                        .returnGoalName() + "\n";
                    goalIndexEdit++;
                }
                System.out.println("Which goal is the task in? (enter number)");
                System.out.println(allGoalNamesEdit);
                int selectedGoalNumEdit = Integer.parseInt(decision.nextLine());
                //if entry not valid
                Task[] taskArrayEdit = new Task[10];
                int taskIndexEdit = 0;
                String allTaskNamesEdit = "";
                if (selectedGoalNumEdit <= (goalIndexEdit + 1)) {
                    taskArrayEdit = goalArrayEdit[(selectedGoalNumEdit - 1)]
                        .getTasks();
                    while (taskArrayEdit[taskIndexEdit] != null) {
                        allTaskNamesEdit = allTaskNamesEdit + " ("
                            + (taskIndexEdit + 1) + ") "
                            + taskArrayEdit[taskIndexEdit].getTaskName() + "\n";
                        taskIndexEdit++;
                    }
                    System.out.println("Which task would you like to"
                        + " edit? (enter number)");
                    System.out.println(allTaskNamesEdit);
                    int selectedTaskNumEdit = Integer
                        .parseInt(decision.nextLine());
                    Task editTask = taskArrayEdit[(selectedTaskNumEdit - 1)];
                    boolean gucciOption2 = false;
                    String selectedNewTaskNameEdit;
                    int selectedNewTaskPriorityEdit;
                    String selectedNewTaskDayEdit;
                    String selectedNewTaskTimeEdit;
                    int selectedNewTaskCompletenessEdit;
                    //LocalDateTime selectedNewTaskDueDateEdit;
                    while (!gucciOption2) {
                        System.out
                            .println("Which field of this task would you"
                                + " like to edit? (enter number)\n"
                                + " (1) Name\n"
                                + " (2) Priority\n" + " (3) Due Date\n"
                                + " (4) Completion Status\n"
                                + " (5) I'm done editing this task\n");
                        Scanner decision2 = new Scanner(System.in);
                        int selectedFieldNumEdit = Integer
                            .parseInt(decision2.nextLine());
                        if (selectedFieldNumEdit == 1) {
                            System.out.println("Please enter the"
                                + " new name for this task.");
                            selectedNewTaskNameEdit = decision2.nextLine();
                            editTask.setName(selectedNewTaskNameEdit);
                        } else if (selectedFieldNumEdit == 2) {
                            System.out.println("Please enter the new"
                                + " priority for this task.");
                            selectedNewTaskPriorityEdit = Integer
                                .parseInt(decision2.nextLine());
                            editTask.setPriority(selectedNewTaskPriorityEdit);
                        } else if (selectedFieldNumEdit == 3) {
                            System.out
                                .println("Please enter the new date that"
                                         + " this task will be due "
                                         + "(YYYY-MM-DD)");
                            selectedNewTaskDayEdit = decision2.nextLine();
                            System.out.println("Please enter the new time "
                                + "that this task will be due (HH:MM 24-hour"
                                + " clock)");
                            selectedNewTaskTimeEdit = decision2.nextLine();
                            LocalDateTime selectedNewTaskDue = LocalDateTime
                                .parse(selectedNewTaskDayEdit + "T"
                                + selectedNewTaskTimeEdit);
                            editTask.setDueDate(selectedNewTaskDue);
                        } else if (selectedFieldNumEdit == 4) {
                            System.out.println("Is this task complete or"
                                + " incomplete? (enter number)\n"
                                + " (1) Complete\n"
                                + " (2) Incomplete\n");
                            selectedNewTaskCompletenessEdit = Integer
                                .parseInt(decision2.nextLine());
                            if (selectedNewTaskCompletenessEdit == 1) {
                                editTask.changeStatus(true);
                            } else if (selectedNewTaskCompletenessEdit == 2) {
                                editTask.changeStatus(false);
                            } else {
                                System.out
                                    .println("Entered value is not valid");
                            }
                        } else if (selectedFieldNumEdit == 5) {
                            System.out
                                .println("You have successfully saved"
                                     + " this task!");
                            gucciOption2 = true;
                        } else {
                            System.out.println("Entered value is not valid");
                        }
                    }
                } else {
                    System.out.println("Entered value is not valid");
                }
            } else if (chosenOption == 4) {
                currentPerson.writeNew(ps, (nameMatch + ".csv"));
                currentPerson.displayGoalTasksRead(nameMatch);
            } else if (chosenOption == 5) {
                currentPerson.writeNew(ps, (nameMatch + ".csv"));
                System.out.println("Your progress has been saved."
                    + " Have a nice day!");
                gucciOption = true;
            } else {
                System.out.println("Please choose from the provided options");
            }

        }

    }
}
