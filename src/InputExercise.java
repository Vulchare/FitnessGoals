import javax.swing.*;
import java.util.Calendar;
enum EnumExercises {
    EMPTY(""),
    BENCH("Bench Press"),
    SHOULDERPRESS("Shoulder Press"),
    LATRAISES("Lateral Raises"),
    REARDELTS("Rear Delts"),
    CLOSEGRIPPULLDOWN("Close Grip Pulldown"),
    SEATEDROW("Seated Row"),
    BARBELLCURLS("Barbell Bicep Curls"),
    ADDNEWWORKOUT("<Add new workout>");

    private final String stringValue;
    EnumExercises(String s) {
        this.stringValue = s;
    }
    public String getStringValue(){
        return stringValue;
    }
}

public class InputExercise {
    private JTextField textFieldDate;
    private JTextField textFieldSets;
    private JTextField textFieldReps;
    private JTextField textFieldWeight;
    private JButton cancelButton;
    private JButton saveButton;
    JPanel panelMain;
    JPanel panelMainAddNew;
    private JComboBox<String> JComboBoxExercise;

    public InputExercise() {
        saveButton.addActionListener(e -> {
            System.out.println("Exercise:   " + JComboBoxExercise.getSelectedItem());
            System.out.println("Date:       " + textFieldDate.getText());
            System.out.println("Sets:       " + textFieldSets.getText());
            System.out.println("Reps:       " + textFieldReps.getText());
            System.out.println("Weight:     " + textFieldWeight.getText());
            Exercise test = new Exercise("test", 3, 10, 50);
            System.out.println(test.getName());
        });


        JComboBoxExercise.addActionListener(e -> {
            System.out.println(JComboBoxExercise.getSelectedItem());
            int idx = JComboBoxExercise.getSelectedIndex() + 1;
            int enumLength = EnumExercises.values().length;
            if (idx == enumLength) {
                AddNewExercise AddNewExercise = new AddNewExercise();
                JFrame frame2 = new JFrame("Input Exercise");
                frame2.setContentPane(AddNewExercise.panelMainAddNew);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.pack();
                frame2.setVisible(true);
            }

        });

        cancelButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(cancelButton);
            frame.dispose();
        });
    }



    public static void main(String[] args) {
        InputExercise inputExercise = new InputExercise();
        JFrame frame = new JFrame("Input Exercise");
        frame.setContentPane(inputExercise.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



        //fill default values
        inputExercise.textFieldDate.setText(getDate());
        inputExercise.textFieldSets.setText("3");
        inputExercise.textFieldReps.setText("10");

        for (EnumExercises exe : EnumExercises.values()){
            inputExercise.JComboBoxExercise.addItem(exe.getStringValue());
        }


    }


    public static String getDate(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // Note: 0-based index
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        return dayOfMonth + "-" + (month + 1) + "-" + year;
    }
}




