package dao;

import connection.SingleConnectionDB;
import model.ModelLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOUserRepository {

    private final Connection connection;

    public DAOUserRepository() {
        connection = SingleConnectionDB.getConnection();
    }

    public ModelLogin saveUser(ModelLogin modelLogin) throws SQLException {

        if (modelLogin.isNew()) {
            this.createNewUser(modelLogin);
        } else {
            this.updateExistUser(modelLogin);
        }
        return this.getUserByLogin(modelLogin.getLogin());
    }

    private void createNewUser(ModelLogin modelLogin) throws SQLException {
        String sql = "INSERT INTO public.model_login (login, password,name, email) VALUES (?, ?, ?, ?);";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, modelLogin.getLogin());
        statement.setString(2, modelLogin.getPassword());
        statement.setString(3, modelLogin.getName());
        statement.setString(4, modelLogin.getEmail());

        statement.execute();

        connection.commit();
    }

    private void updateExistUser(ModelLogin modelLogin) throws SQLException {
        String sql = "UPDATE model_login SET login=?, password=?, name=?, email=? where id =" + modelLogin.getId() + ";";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, modelLogin.getLogin());
        statement.setString(2, modelLogin.getPassword());
        statement.setString(3, modelLogin.getName());
        statement.setString(4, modelLogin.getEmail());

        statement.executeUpdate();

        connection.commit();
    }

    public ModelLogin getUserByLogin(String login) throws SQLException {

        ModelLogin modelLogin = new ModelLogin();

        String sql = "select * from model_login where login = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, login);

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            modelLogin.setId(result.getLong("id"));
            modelLogin.setName(result.getString("name"));
            modelLogin.setEmail(result.getString("email"));
            modelLogin.setLogin(result.getString("login"));
            modelLogin.setPassword(result.getString("password"));
        }

        return modelLogin;
    }

    public List<ModelLogin> getUserByName(String name) throws SQLException {

        List<ModelLogin> userList = new ArrayList<>();

        String sql = "select * from model_login where upper(name) ilike upper(?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, "%" + name + "%");

        ResultSet result = statement.executeQuery();

        while (result.next()) {
            ModelLogin user = new ModelLogin();

            user.setId(result.getLong("id"));
            user.setName(result.getString("name"));
            user.setEmail(result.getString("email"));
            user.setLogin(result.getString("login"));
            //user.setPassword(result.getString("password"));
            userList.add(user);
        }
        return userList;
    }

    public boolean loginExists(String login) throws SQLException {

        String sql = "select count(*) as exist from model_login where login = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, login);

        ResultSet result = statement.executeQuery();

        result.next();
        return result.getBoolean("exist");

    }

    public void deleteUserById(String id) throws SQLException {

        String sql = "delete from model_login where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setLong(1, Long.parseLong(id));

        statement.executeUpdate();

        connection.commit();
    }
}
