import javax.swing.*;
import java.awt.*;

public class WorkoutEntryGUI {
    protected JButton addWorkoutButton;
    protected JButton cancelButton;
    protected JTextField textFieldDefaultReps;
    protected JTextField textFieldDefaultSets;
    protected JTextField textFieldWorkout;
    protected JTextField textFieldCategory;
    JPanel panelMainAddNew;
    private JLabel warningLabelExists;

    public WorkoutEntryGUI(WorkoutGUI workoutGUI){

        addWorkoutButton.addActionListener(e -> {
            var workouts = WorkoutDBQuery.findAll();
            boolean workoutExists = false;

            for (var workout:  workouts) {
                if (workout.getName().equals(textFieldWorkout.getText())) {
                    workoutExists = true;
                    System.out.println("exercise exists");
                    warningLabelExists.setText("Exercise already exists!");
                    warningLabelExists.setBackground(Color.RED);
                    break;
                }
            }

            if (!workoutExists) {
                int id = WorkoutDBInsert.add(
                        new Workout(
                                textFieldCategory.getText(),
                                textFieldWorkout.getText(),
                                Integer.parseInt(textFieldDefaultSets.getText()),
                                Integer.parseInt(textFieldDefaultReps.getText())));
                workoutGUI.updateExerciseList(workoutGUI);
                closeFrame();


            }


        });

        cancelButton.addActionListener(e -> closeFrame());

    }

    public void closeFrame(){

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cancelButton);
        frame.dispose();

    }



}


