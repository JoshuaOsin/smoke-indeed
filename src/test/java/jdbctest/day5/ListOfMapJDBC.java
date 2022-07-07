package jdbctest.day5;

import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListOfMapJDBC {

    String dbURL = "jdbc:oracle:thin:@54.205.226.28:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("SELECT  FIRST_NAME, LAST_NAME,SALARY, JOB_ID " +
                "FROM EMPLOYEES WHERE ROWNUM <4");

        // RSMD

        ResultSetMetaData rsmd = resultSet.getMetaData();

        // Number of rows (move to last row and get the row count
        List<Map<String, Object>> queryData = new ArrayList<>();

        int colCount = rsmd.getColumnCount();

        while (resultSet.next()) {
            Map<String, Object> row = new HashMap<>();

            // add values for all columns
            for (int i = 1; i <= colCount; i++) {
                row.put(rsmd.getColumnName(i), resultSet.getObject(i));

            }
            // add row to list of Map
            queryData.add(row);
        }

        for (Map<String, Object> each : queryData) {
            System.out.println(each.toString());
        }

        // CLOSE CONNECTION
        resultSet.close();
        statement.close();
        connection.close();
    }


}
