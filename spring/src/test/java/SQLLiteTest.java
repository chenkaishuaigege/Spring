import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class SQLLiteTest {

    Connection c;
    Statement stmt;

    /**
     * 连接到一个现有的数据库。如果数据库不存在， 那么它就会被创建，最后将返回一个数据库对象。
     */
    @Before
    public void before() throws ClassNotFoundException {
        String Drivde="org.sqlite.JDBC";
        try {
            Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
            c = DriverManager.getConnection("jdbc:sqlite:/Users/chenkai/testDB.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        try {
            stmt.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() throws SQLException {
        c.setAutoCommit(false);
        int i = 1;
        while (i < 3000){
            insertMethod(i);
            i++;
        }

        c.commit();

    }

    private void insertMethod(int i){
        String e = i + "";
        String message = "message" + i;
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("INSERT INTO MULTILINGUAL_ERROR_INF (MEF_ERROR_CODE,MEF_LANGUAGE,MTF_MESSAGE) " + "VALUES (" + e + ", 'cn_EN',\'" + message + "');\n");
            System.out.println(sb);
            stmt.executeUpdate(sb.toString());
        } catch (SQLException em) {
            em.printStackTrace();
        }
    }

    /**
     INSERT INTO MULTILINGUAL_TRANSLATION_INF
     (MTF_FIELD_NAME, MTF_LANGUAGE, MTF_FIELD_VALUE, MTF_MESSAGE)
     VALUES ('orderType','en_US', '01','cash in');
     */

}
