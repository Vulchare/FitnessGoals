import javax.swing.*;

public class AddNewExercise {
    private JButton addWorkoutButton;
    private JButton cancelButton;
    private JTextField textFieldDefaultReps;
    private JTextField textFieldDefaultSets;
    private JTextField textFieldWorkout;
    private JTextField textFieldCategory;
    JPanel panelMainAddNew;
    public AddNewExercise(){

        addWorkoutButton.addActionListener(e -> {
            var workouts = WorkoutDBQuery.findAll();
            boolean workoutExists = false;

            for (var workout:  workouts) {
                if (workout.getName().equals(textFieldWorkout.getText())) {
                    workoutExists = true;
                    System.out.println("exercise exists");
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


