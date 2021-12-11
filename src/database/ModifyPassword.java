package database;

import java.sql.*;

public class ModifyPassword {
    public static void modifypass(String user,String password) {
        Connection con = ConnectDatabase.connectDB();
        PreparedStatement preSql;
        String sqlStr = "update usertable set password=? where user = ?";

        try {
            preSql = con.prepareStatement(sqlStr);
            preSql.setString(1, password);
            preSql.setString(2, user);
            preSql.executeUpdate();

            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
