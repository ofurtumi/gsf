import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class v8b {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:company.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.

            String query = "update EMPLOYEE set Salary = (Salary + 200) where Ssn = ?";
            PreparedStatement p = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery("select ssn from EMPLOYEE");
            while (rs.next()) {
                String ssn = rs.getString(1);
                p.clearParameters();
                p.setString(1, ssn);
                p.execute();
                // System.out.printf("%d\n", rs.getInt(1));
            }
            rs.close();
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}
