package jdbctest.day5;

import org.junit.Test;

import java.sql.*;

public class Jdbc_practice2 {

    String dbURL = "jdbc:oracle:thin:@54.205.226.28:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT *FROM DEPARTMENTS");

        // Number of rows (move to last row and get the row count
        resultSet.last();
        int rowCount = resultSet.getRow();
        System.out.println("rowCount = " + rowCount);

        // print second column of table
        resultSet.beforeFirst();

        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }

        // CLOSE CONNECTION
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test3() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT *FROM EMPLOYEES");

        DatabaseMetaData dbMetadata = connection.getMetaData();

        System.out.println("dbMetadata.getUserName() = " + dbMetadata.getUserName());
        System.out.println("dbMetadata.getDatabaseProductName() = " + dbMetadata.getDatabaseProductName());


        // get resutset meta data // rsmd
        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        //how many columns do we have
        int colCount = rsMetadata.getColumnCount();
        System.out.println("colCount = " + colCount);

        // get columns name
        for (int i = 1; i <= colCount; i++) {
            System.out.println(i+ " - "+ rsMetadata.getColumnName(i));
        }

        // CLOSE CONNECTION
        resultSet.close();
        statement.close();
        connection.close();
    }
}