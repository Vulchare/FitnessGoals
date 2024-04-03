import javax.swing.*;

public class Main {
    public static void main(String[] args){


        WorkoutGUI addNewWorkout = new WorkoutGUI();
        JFrame frame = new JFrame("Input Exercise");
        frame.setContentPane(addNewWorkout.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);




//        var workouts = WorkoutDBQuery.findAll();
//        for (var workout:  workouts) {
//            System.out.println(workout.getName());
//        }


        //Workout workout = new Workout("Chest", "Bench Press");
        //System.out.println(workout.toString());

        //int id = WorkoutDB.add(new Workout("Chest", "Bench Press"));
        //System.out.println("Inserted id:" + id);

//        var sql = "CREATE TABLE workouts (" +
//                "    id SERIAL PRIMARY KEY," +
//                "    category VARCHAR(255) NOT NULL," +
//                "    name VARCHAR(255) NOT NULL" +
//                ");";
//        try (var conn =  DB.connect();
//             var stmt = conn.createStatement()) {
//            stmt.executeUpdate(sql);
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
    }
}