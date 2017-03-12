package ua.litovka.dao.impl;


import ua.litovka.dao.DaoFactory;
import ua.litovka.dao.SQLs;
import ua.litovka.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SergLion on 24.02.2017.
 */
public class UserDAOImpl extends CrudDAO<User> {

   // public static final String UPDATE_USER = "Update user set login = ?, password = ?, firstName = ?,
    // lastName = ?, email = ?, sex = ?, birthday = ?, role = ?";

    public UserDAOImpl() {
        super(User.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLs.UPDATE_USER);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLs.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    protected List<User> readAll(ResultSet resultSet) throws SQLException {
        List<User> result = new LinkedList<>();
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setFirstName(resultSet.getString("firstName"));
            user.setLastName(resultSet.getString("lastName"));
            user.setEmail(resultSet.getString("email"));
            user.setSex(resultSet.getString("sex"));
            user.setBirthday(resultSet.getDate("birthday").toLocalDate());
            user.setRole(DaoFactory.getInstance().getRoleDao().getById(resultSet.getInt("role")));
            result.add(user);
        }
        return result;
    }

    private void setStatement(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getLogin());
        preparedStatement.setString(2, entity.getPassword());
        preparedStatement.setString(3, entity.getFirstName());
        preparedStatement.setString(4, entity.getLastName());
        preparedStatement.setString(5, entity.getEmail());
        preparedStatement.setString(6, entity.getSex());
        preparedStatement.setDate(7, Date.valueOf(entity.getBirthday()));
        preparedStatement.setInt(8, entity.getRole().getId());
    }
}
