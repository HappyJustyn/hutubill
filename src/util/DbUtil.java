package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 *
 * @author Justyn
 * @version 1.0
 * @date 2021/12/9 18:51
 */
public class DbUtil {
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://ip:3306/hutubill?characterEncoding=UTF-8";
    static final String USERNAME = "USERNAME";
    static final String PASSWORD = "PASSWORD.";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void main(String[] args) {

    }
}
