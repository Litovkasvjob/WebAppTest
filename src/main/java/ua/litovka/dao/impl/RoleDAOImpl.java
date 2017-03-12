package ua.litovka.dao.impl;

import ua.litovka.dao.api.Dao;
import ua.litovka.model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SergLion on 24.02.2017.
 */
public class RoleDAOImpl extends CrudDAO<Role> {
    public RoleDAOImpl() {
        super(Role.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Role entity) throws SQLException {
        return null;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Role entity) throws SQLException {
        return null;
    }

    @Override
    protected List<Role> readAll(ResultSet resultSet) throws SQLException {
        List<Role> result = new LinkedList<>();
        Role role = null;
        while (resultSet.next()) {
            role = new Role();
            role.setId(resultSet.getInt("id"));
            role.setName(resultSet.getString("name"));
            result.add(role);
        }
        return result;
    }
}

