package ua.litovka.dao.impl;



import ua.litovka.dao.SQLs;
import ua.litovka.model.Movie;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SergLion on 21.02.2017.
 */
public class MovieDaoImpl extends CrudDAO<Movie> {

    //private final String INSERT = "INSERT INTO movie (title, duration, description) VALUES (? , ?, ?)";
    //private final String UPDATE = "UPDATE movie SET title = ?, duration = ?, description = ? WHERE id = ?";
    private static MovieDaoImpl crudDAO;

    public MovieDaoImpl(Class type) {
        super(type);
    }

    public static synchronized MovieDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new MovieDaoImpl(Movie.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Movie movie) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLs.UPDATE_MOVIE);
        preparedStatement.setString(1, movie.getTitle());
        preparedStatement.setLong(2, movie.getDuration());
        preparedStatement.setString(3, movie.getDescription());
        preparedStatement.setInt(4, movie.getId());

        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Movie movie) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLs.INSERT_MOVIE, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, movie.getTitle());
        preparedStatement.setLong(2, movie.getDuration());
        preparedStatement.setString(3, movie.getDescription());
        return preparedStatement;
    }

    @Override
    protected List<Movie> readAll(ResultSet resultSet) throws SQLException {
        List<Movie> result = new LinkedList<>();
        Movie movie = null;
        while (resultSet.next()) {
            movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setDuration(resultSet.getLong("duration"));
            movie.setDescription(resultSet.getString("description"));
            result.add(movie);
        }
        return result;
    }
}
