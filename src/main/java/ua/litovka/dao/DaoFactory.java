package ua.litovka.dao;


import ua.litovka.dao.api.Dao;
import ua.litovka.dao.impl.MovieDaoImpl;
import ua.litovka.dao.impl.RoleDAOImpl;
import ua.litovka.dao.impl.UserDAOImpl;
import ua.litovka.helper.PropertyHolder;
import ua.litovka.model.Movie;
import ua.litovka.model.Role;
import ua.litovka.model.User;

/**
 * Created by SergLion on 22.02.2017.
 */
public class DaoFactory {
    private static DaoFactory instance = null;

    private Dao<Integer, Movie> movieDao;
    private Dao<Integer, User> userDao;
    private Dao<Integer, Role> roleDao;

    private DaoFactory() {
        loadDAOs();
    }

    public static DaoFactory getInstance() {
        if (instance == null) {
            instance = new DaoFactory();
        }
        return instance;
    }

    private void loadDAOs() {
        if (PropertyHolder.getInstance().isInMemoryDB()) {

        } else {
            movieDao = new MovieDaoImpl(Movie.class);
            userDao = new UserDAOImpl();
            roleDao = new RoleDAOImpl();
        }
    }

    public Dao<Integer, Movie> getMovieDao() {
        return movieDao;
    }

    public void setMovieDao(Dao<Integer, Movie> movieDao) {
        this.movieDao = movieDao;
    }

    public Dao<Integer, User> getUserDao() {
        return userDao;
    }

    public void setUserDao(Dao<Integer, User> userDao) {
        this.userDao = userDao;
    }

    public Dao<Integer, Role> getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(Dao<Integer, Role> roleDao) {
        this.roleDao = roleDao;
    }
}
