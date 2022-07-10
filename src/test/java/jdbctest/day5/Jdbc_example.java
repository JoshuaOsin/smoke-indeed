package jdbctest.day5;

import org.junit.Test;

import java.sql.*;

public class Jdbc_example {

    String dbURL = "jdbc:oracle:thin:@54.205.226.28:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *FROM DEPARTMENTS");

        // move pointer to next row

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) +
                    " -\t " + resultSet.getString(2) +
                    " -\t " + resultSet.getInt(3) +
                    " -\t " + resultSet.getInt(4));
        }

        resultSet = statement.executeQuery("SELECT *FROM REGIONS");

        // move pointer to next row

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) +
                    " -\t " + resultSet.getString(2));

        }

        // CLOSE CONNECTION
        resultSet.close();
        statement.close();
        connection.close();

    }
}
