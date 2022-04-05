package dao;

import connection.SingleConnectionDB;
import model.ModelLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOLoginRepository {

    private Connection connection;

    public DAOLoginRepository(){
        connection = SingleConnectionDB.getConnection();
    }

    public boolean validateAuth(ModelLogin modelLogin) throws Exception {

        String sql = "select * from model_login where login = ? and password = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,modelLogin.getLogin());
        statement.setString(2,modelLogin.getPassword());

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()){
            return true;
        }

        return false;
    }

}
