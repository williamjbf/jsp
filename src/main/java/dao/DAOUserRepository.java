package dao;

import connection.SingleConnectionDB;
import model.ModelLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOUserRepository {

    private Connection connection;

    public DAOUserRepository() {
        connection = SingleConnectionDB.getConnection();
    }

    public void saveUser(ModelLogin modelLogin) throws SQLException {

        String sql = "INSERT INTO public.model_login (login, password,name, email) VALUES (?, ?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, modelLogin.getLogin());
        preparedStatement.setString(2, modelLogin.getPassword());
        preparedStatement.setString(3, modelLogin.getName());
        preparedStatement.setString(4, modelLogin.getEmail());

        preparedStatement.execute();

        connection.commit();
    }

}
