package jdbctest.day5;

import com.indeed.utilities.DBUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class DBUtilPractice {

    @Test
    public void test1(){
        DBUtils.createConnection();
        String query = "SELECT  FIRST_NAME, LAST_NAME,SALARY, JOB_ID " +
                "FROM EMPLOYEES WHERE ROWNUM <5";
        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

        for (Map<String, Object> each : queryData) {
            System.out.println(each.toString());
        }

        DBUtils.destroy();

    }
    @Test
    public void test2(){
        DBUtils.createConnectionVtrack();
        String query = "SELECT  * " +
                "FROM oro_ext_vehiclecontract"; // bitnami_orocrm.oro_ext_vehiclecontract
        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query);

        for (Map<String, Object> each : queryData) {
            System.out.println(each.toString());
        }

        DBUtils.destroy();

    }
}
