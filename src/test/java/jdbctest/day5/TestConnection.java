package jdbctest.day5;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        String dbURL = "jdbc:oracle:thin:@54.205.226.28:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT *FROM REGIONS");
        //resultSet.next();
        //
        //        System.out.println("resultSet.getString(\"REGION_NAME\") = " + resultSet.getString("REGION_NAME"));
        //
        //        System.out.println("resultSet.getInt(1) = " + resultSet.getInt(1));

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1)+ " - "+resultSet.getString(2));
        }

        // CLOSE CONNECTION
        resultSet.close();
        statement.close();
        connection.close();
    }
}
