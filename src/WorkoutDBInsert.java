import java.sql.SQLException;
import java.sql.Statement;


public class WorkoutDBInsert {


    public static int add(Workout workout) {
        var sql = "INSERT INTO workouts(category, name, sets, reps) "
                + "VALUES(?,?,?,?)";

        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // bind the values
            pstmt.setString(1, workout.getCategory());
            pstmt.setString(2, workout.getName());
            pstmt.setInt(3, workout.getSets());
            pstmt.setInt(4, workout.getReps());

            // execute the INSERT statement and get the inserted id
            int insertedRow = pstmt.executeUpdate();
            if (insertedRow > 0) {
                var rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}