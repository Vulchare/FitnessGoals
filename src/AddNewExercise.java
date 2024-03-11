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
            System.out.println("Category:     " + textFieldCategory.getText());
            System.out.println("Workout:      " + textFieldWorkout.getText());
            System.out.println("Default sets: " + textFieldDefaultSets.getText());
            System.out.println("Default reps: " + textFieldDefaultReps.getText());
            closeFrame();
        });

        cancelButton.addActionListener(e -> {
            closeFrame();
        });

    }

    public void closeFrame(){

            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cancelButton);
            frame.dispose();

    }



}


