import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDB {

    public static List<Product> findAll() {
        var products = new ArrayList<Product>();

        var sql = "SELECT id, name, price FROM products ORDER BY name";

        try (var conn =  DB.connect();
             var stmt = conn.createStatement()) {

            var rs = stmt.executeQuery(sql);

            while (rs.next()) {
                var product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // ...
}