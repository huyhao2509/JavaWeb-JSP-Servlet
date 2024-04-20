package repository;

import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepositoryImpl {
    public static Account findUser(Connection connection,
                                   String userName, String password) throws SQLException {

        String sql = "select * from account where username = ? and `password` = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            return new Account(userName, password, rs.getInt("role"));
        }
        return null;
    }
}