package ua.litovka.service.impl;

import ua.litovka.dao.DaoFactory;
import ua.litovka.dao.api.Dao;
import ua.litovka.dto.UserDTO;
import ua.litovka.mapper.BeanMapper;
import ua.litovka.model.User;
import ua.litovka.service.api.Service;

import java.util.List;

/**
 * Created by SergLion on 25.02.2017.
 */
public class UserServiceImpl implements Service<Integer, UserDTO>{

    private static UserServiceImpl service;
    private Dao<Integer, User> userDao;
    private BeanMapper beanMapper;

    private UserServiceImpl() {
        userDao = DaoFactory.getInstance().getUserDao();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized UserServiceImpl getInstance() {
        if (service == null) {
            service = new UserServiceImpl();
        }
        return service;
    }


    @Override
    public List<UserDTO> getAll() {
        List<User> users = userDao.getAll();
        List<UserDTO> userDTOs = beanMapper.listMapToList(users, UserDTO.class);
        return userDTOs;
    }

    @Override
    public UserDTO getById(Integer id) {
        UserDTO userDTO = beanMapper.singleMapper(userDao.getById(id), UserDTO.class);
        return userDTO;
    }


    @Override
    public void save(UserDTO entity) {
        User user = beanMapper.singleMapper(entity, User.class);
        userDao.save(user);
    }

    public UserDTO getByLogin(String value) {
        User user = userDao.getBy("login", value);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }


    @Override
    public void delete(Integer key) {
        userDao.delete(key);

    }

    @Override
    public void update(UserDTO entity) {
        User user = beanMapper.singleMapper(entity, User.class);
        userDao.update(user);

    }
}
