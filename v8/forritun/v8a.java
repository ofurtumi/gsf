import java.sql.*;

/**
 * v8
 */

public class v8a {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:company.db");
            Statement statement = connection.createStatement();

            double salaries = 0;
            int cnt = 0;
            ResultSet rs = statement.executeQuery("select Salary from EMPLOYEE");
            while (rs.next()) {
                salaries += rs.getDouble(1);
                cnt++;
            }
            rs.close();
            System.out.printf("avg-salary: %f", salaries/cnt);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}