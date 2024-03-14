import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDBQuery {

    public static List<Workout> findAll() {
        var workouts = new ArrayList<Workout>();

        var sql = "SELECT id, category, name, sets, reps FROM workouts ORDER BY name";

        try (var conn =  DB.connect();
             var stmt = conn.createStatement()) {

            var rs = stmt.executeQuery(sql);

            while (rs.next()) {
                var workout = new Workout(
                        rs.getInt("id"),
                        rs.getString("category"),
                        rs.getString("name"),
                        rs.getInt("sets"),
                        rs.getInt("reps"));
                workouts.add(workout);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workouts;
    }

    // ...
}