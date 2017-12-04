public class Goal {

    private String goalName;
    private Task[] tasks = new Task[10];

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public String returnGoalName() {
        return goalName;
    }

    public void addTask(Task task) {
        int taskIndex = 0;
        int fullCounter = 0;
        if (tasks[0] == null) {
            tasks[0] = task;
        } else {
            while (tasks[taskIndex] != null) {
                taskIndex++;
                fullCounter++;
            }
            tasks[fullCounter] = task;
        }
    }

    public Task[] getTasks() {
        return tasks;
    }

    /*public void writeNewTask(PrintStream ps, String fileName
        , int selectedGoalRow, Task entryTask) throws Exception {
        Scanner personFile = new Scanner(new File(fileName));
        String[] allLines = new String[10];
        String currentLine = "";
        int counter = 0;
        while (personFile.hasNext()) {
            currentLine = personFile.nextLine();
            allLines[counter] = currentLine.trim();
            counter++;
        }
        ps = new PrintStream(new FileOutputStream((fileName), false));
        int arrayIndex = 0;
        while (allLines[arrayIndex] != null) {
            if ((arrayIndex + 1) == selectedGoalRow) {
                ps.println(allLines[arrayIndex]
                    + ", " + entryTask.task2String());
            } else {
                ps.println(allLines[arrayIndex]);
            }
            arrayIndex++;
        }
    } */
}
