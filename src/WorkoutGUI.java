import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class WorkoutGUI {
    protected List<Workout> tableData = new ArrayList<>();
    protected JTextField textFieldDate;
    protected JTextField textFieldSets;
    protected JTextField textFieldReps;
    protected JTextField textFieldWeight;
    protected JButton cancelButton;
    protected JButton saveButton;
    protected JPanel panelMain;
    protected JComboBox<String> JComboBoxExercise;
    protected JButton AddWorkoutButton;

    public WorkoutGUI() {
        //fill default values
        this.textFieldDate.setText(WorkoutGUI.getDate());
        this.textFieldSets.setText("3");
        this.textFieldReps.setText("10");

        this.updateExerciseList(this); //pull exercises from DB

        saveButton.addActionListener(e -> {
            System.out.println("Exercise:     " + JComboBoxExercise.getSelectedItem());
            System.out.println("Date:         " + textFieldDate.getText());
            System.out.println("Sets:         " + textFieldSets.getText());
            System.out.println("Reps:         " + textFieldReps.getText());
            System.out.println("Weight:       " + textFieldWeight.getText());
        });

        JComboBoxExercise.addActionListener(e -> {

        });

        cancelButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cancelButton);
            frame.dispose();
        });

        AddWorkoutButton.addActionListener(e -> {
                WorkoutEntryGUI AddNewExercise = new WorkoutEntryGUI(this);
                JFrame frame2 = new JFrame("Input Exercise");
                frame2.setContentPane(AddNewExercise.panelMainAddNew);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
        });
    }


    public static void main(String[] args) {

    }


    public static String getDate(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // Note: 0-based index
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        return dayOfMonth + "-" + (month + 1) + "-" + year;
    }

    public static void updateExerciseList(WorkoutGUI addNewWorkout){
        addNewWorkout.JComboBoxExercise.removeAllItems();
        var workouts = WorkoutDBQuery.findAll();
        for (var workout:  workouts) {
            addNewWorkout.JComboBoxExercise.addItem(workout.getName());
        }
    }


}




