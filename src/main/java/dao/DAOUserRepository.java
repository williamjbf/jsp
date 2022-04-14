package dao;

import connection.SingleConnectionDB;
import model.ModelLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUserRepository {

    private Connection connection;

    public DAOUserRepository() {
        connection = SingleConnectionDB.getConnection();
    }

    public ModelLogin saveUser(ModelLogin modelLogin) throws SQLException {

        String sql = "INSERT INTO public.model_login (login, password,name, email) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, modelLogin.getLogin());
        statement.setString(2, modelLogin.getPassword());
        statement.setString(3, modelLogin.getName());
        statement.setString(4, modelLogin.getEmail());

        statement.execute();

        connection.commit();

        return this.getUserByLogin(modelLogin.getLogin());
    }

    public ModelLogin getUserByLogin(String login) throws SQLException {

        ModelLogin modelLogin = new ModelLogin();

        String sql = "select * from model_login where login = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, login);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            modelLogin.setId(resultSet.getLong("id"));
            modelLogin.setName(resultSet.getString("name"));
            modelLogin.setEmail(resultSet.getString("email"));
            modelLogin.setLogin(resultSet.getString("login"));
            modelLogin.setPassword(resultSet.getString("password"));
        }

        return modelLogin;
    }

}
