import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class AddNewWorkout {
    public static List<Workout> tableData = new ArrayList<>();
    private JTextField textFieldDate;
    private JTextField textFieldSets;
    private JTextField textFieldReps;
    private JTextField textFieldWeight;
    private JButton cancelButton;
    private JButton saveButton;
    JPanel panelMain;
    private JComboBox<String> JComboBoxExercise;
    private JButton AddWorkoutButton;

    public AddNewWorkout() {
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
                AddNewExercise AddNewExercise = new AddNewExercise();
                JFrame frame2 = new JFrame("Input Exercise");
                frame2.setContentPane(AddNewExercise.panelMainAddNew);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setLocationRelativeTo(null);
                frame2.setVisible(true);
        });
    }


    public static void main(String[] args) {


        AddNewWorkout addNewWorkout = new AddNewWorkout();
        JFrame frame = new JFrame("Input Exercise");
        frame.setContentPane(addNewWorkout.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //fill default values
        addNewWorkout.textFieldDate.setText(getDate());
        addNewWorkout.textFieldSets.setText("3");
        addNewWorkout.textFieldReps.setText("10");

        updateExerciseList(addNewWorkout);

    }


    public static String getDate(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // Note: 0-based index
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        return dayOfMonth + "-" + (month + 1) + "-" + year;
    }

    public static void updateExerciseList(AddNewWorkout addNewWorkout){

        var workouts = WorkoutDBQuery.findAll();
        for (var workout:  workouts) {
            addNewWorkout.JComboBoxExercise.addItem(workout.getName());
        }
    }


}




