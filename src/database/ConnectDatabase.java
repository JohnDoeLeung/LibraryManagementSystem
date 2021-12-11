package database;

import utilities.DBinformation;
import java.sql.*;

public class ConnectDatabase {
    public static Connection connectDB() {

        Connection con = null;

        try {
            Class.forName(DBinformation.DRIVERNAME);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(DBinformation.URL,DBinformation.USERNAME,DBinformation.PASSWORD);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
