package ua.litovka.dao;

/**
 * Created by SergLion on 24.02.2017.
 */
public class SQLs {
    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY_ID = "Select * from %s where id = ?";
    public static final String FIND_BY = "Select * from %s where %s = ?";
    public static final String DELETE_BY_ID = "Delete * from %s where id = ?";
    public static final String INSERT_MOVIE = "INSERT INTO movie (title, duration, description) VALUES (? , ?, ?)";
    public static final String UPDATE_MOVIE = "UPDATE movie SET title = ?, duration = ?, description = ? WHERE id = ?";


    public static final String UPDATE_USER = "Update user set login = ?, password = ?, firstName = ?, lastName = ?, email = ?, sex = ?, birthday = ?, role = ? where id = ?";
    public static final String INSERT_USER = "Insert into user (login, password, firstName, lastName, email, sex, birthday,  role) values (? , ?, ?,?,?,?,?,?)";
}
