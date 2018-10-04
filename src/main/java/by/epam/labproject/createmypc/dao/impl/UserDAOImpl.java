package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.RoleDAO;
import by.epam.labproject.createmypc.dao.UserDAO;
import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbFactory;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbInsert;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbSelect;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbWhere.QbWhereOperator;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic.QbFactoryImp;
import by.epam.labproject.createmypc.domain.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class UserDAOImpl implements UserDAO {

    @Override
    public User save(User entity) throws DAOException {
        User newUser = null;
        Connection connection = takeConnectionFromPool();
        try {
            connection = takeConnectionFromPool();
            connection.setAutoCommit(false);
            try {
                newUser = entity;
                newUser = saveUserInUsersTable(newUser, connection);
                newUser = saveUserInUserInfoTable(newUser, connection);
                connection.commit();
                RoleDAO roleDAO = DAOFactory.getInstance().getRoleDAO();
                roleDAO.saveAllRoles(newUser.getRoles(), newUser.getId());
            } catch (SQLException | DAOException e) {
                connection.rollback();
                throw new DAOException("Can't insert user in to 'users' or 'user_info' table", e);
            }
        } catch (SQLException e) {
            throw new DAOException("Can't insert user in to 'users' or 'user_info' table", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO log error
            }
        }
        return newUser;
    }

    public User saveUserInUsersTable(User entity, Connection entityConnection) throws DAOException {
        QbFactory f = new QbFactoryImp();
        User user;
        long autoIncKeyFromUsers = 0;
        try {
            Connection connection = entityConnection;
            user = entity;
            PreparedStatement stmt;
            QbInsert ins = f.newInsertQuery();
            ins.set(f.newStdField("login"), ":username")
                    .set(f.newStdField("password"), ":password")
                    .inTable("user");
            stmt = connection.prepareStatement(ins.getQueryString());
            stmt.setString(ins.getPlaceholderIndex(":username"), user.getUsername());
            stmt.setString(ins.getPlaceholderIndex(":password"), user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = null;
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

            if (rs.next()) {
                autoIncKeyFromUsers = rs.getLong(1);
            }
            user.setId(autoIncKeyFromUsers);
        } catch (SQLException e) {
            throw new DAOException("Can't insert user in to 'users' table", e);
        }
        return user;

    }

    public User saveUserInUserInfoTable(User entity, Connection entityConnection) throws DAOException {
        QbFactory f = new QbFactoryImp();
        User user = null;
        try {
            Connection connection = entityConnection;
            user = entity;
            PreparedStatement stmt;
            QbInsert ins = f.newInsertQuery();
            ins.set(f.newStdField("name"), ":firstname")
                    .set(f.newStdField("surname"), ":surname")
                    .set(f.newStdField("email"), ":email")
                    .set(f.newStdField("age"), ":age")
                    .set(f.newStdField("address"), ":address")
                    .set(f.newStdField("isactive"), ":active")
                    .set(f.newStdField("USER_ID_USER"), ":ID_USER")
                    .inTable("user_info");
            stmt = connection.prepareStatement(ins.getQueryString());
            stmt.setString(ins.getPlaceholderIndex(":firstname"), user.getFirstName());
            stmt.setString(ins.getPlaceholderIndex(":surname"), user.getSurname());
            stmt.setString(ins.getPlaceholderIndex(":email"), user.getEmail());
            stmt.setString(ins.getPlaceholderIndex(":age"), user.getAge());
            stmt.setString(ins.getPlaceholderIndex(":address"), user.getAddress());
            stmt.setString(ins.getPlaceholderIndex(":active"), String.valueOf(user.isActive()));
            stmt.setString(ins.getPlaceholderIndex(":ID_USER"), String.valueOf(user.getId()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Can't insert user in to 'user_info' table", e);
        }
        return user;
    }



    @Override
    public Iterable<User> saveAll(Iterable entities) {
        return null;
    }


    @Override
    public User findById(Long entity) throws DAOException {
        QbFactory f = new QbFactoryImp();
        try (Connection connection = takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbSelect sel = f.newSelectQuery();
            sel.select(f.newStdField("ID_USER"),
                    f.newStdField("login"),
                    f.newStdField("name"),
                    f.newStdField("surname"),
                    f.newStdField("age"),
                    f.newStdField("address"),
                    f.newStdField("email"),
                    f.newStdField("isActive"))
                    .from("user")
                    .join("user_info",
                            f.newQualifiedField("user", "ID_USER"),
                            f.newQualifiedField("user_info", "USER_ID_USER"),
                            QbSelect.QbJoinType.INNER)
                    .where()
                    .where(f.newStdField("ID_USER"), QbWhereOperator.EQUALS, ":ID_USER");
            stmt = connection.prepareStatement(sel.getQueryString());
            stmt.setString(sel.getPlaceholderIndex(":ID_USER"), String.valueOf(entity));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                RoleDAO roleDAO = DAOFactory.getInstance().getRoleDAO();
                User user = User.newBuilder()
                        .setId(Long.valueOf(rs.getString("ID_USER")))
                        .setUsername(rs.getString("login"))
                        .setFirstname(rs.getString("name"))
                        .setSurname(rs.getString("surname"))
                        .setAge(rs.getString("age"))
                        .setAddress(rs.getString("address"))
                        .setEmail(rs.getString("email"))
                        .setRoles( roleDAO.findAllRoles(Long.valueOf(rs.getString("ID_USER"))))
                        .setActive(Boolean.valueOf(rs.getString("isActive")))
                        .build();
                return user;
            }
        } catch (SQLException | DAOException e) {
            throw new DAOException("User not find", e);
        }
        return null;
    }

    @Override
    public Iterable<User> findAll() throws DAOException {
        QbFactory f = new QbFactoryImp();
        List<User> users = new ArrayList<>();
        try (Connection connection = takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbSelect sel = f.newSelectQuery();
            sel.select(f.newStdField("ID_USER"),
                    f.newStdField("login"),
                    f.newStdField("name"),
                    f.newStdField("surname"),
                    f.newStdField("age"),
                    f.newStdField("address"),
                    f.newStdField("email"),
                    f.newStdField("isActive"))
                    .from("user")
                    .join("user_info",
                            f.newQualifiedField("user", "ID_USER"),
                            f.newQualifiedField("user_info", "ID_USER_INFO"),
                            QbSelect.QbJoinType.INNER);
            assert (sel.getQueryString().equals("SELECT `ID_USER`, `login`, `name`, `surname`, `age`, `address`, `email`, `isActive` FROM `user` INNER JOIN `user_info` ON `user`.`ID_USER` = `user_info`.`USER_ID_USER`"));
            stmt = connection.prepareStatement(sel.getQueryString());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RoleDAO roleDAO = DAOFactory.getInstance().getRoleDAO();
                User user = User.newBuilder()
                        .setId(Long.valueOf(rs.getString("ID_USER")))
                        .setUsername(rs.getString("login"))
                        .setFirstname(rs.getString("name"))
                        .setSurname(rs.getString("surname"))
                        .setAge(rs.getString("age"))
                        .setAddress(rs.getString("address"))
                        .setEmail(rs.getString("email"))
                        .setActive(Boolean.valueOf(rs.getString("isActive")))
                        .setRoles(roleDAO.findAllRoles(Long.valueOf(rs.getString("ID_USER"))))
                        .build();
                users.add(user);
            }
        } catch (SQLException e) {
            throw new DAOException("Users not find", e);
        }
        return users;
    }

    @Override
    public User findByUsername(String username) throws DAOException {
        QbFactory f = new QbFactoryImp();
        User user = null;
        try (Connection connection = takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbSelect sel = f.newSelectQuery();
            sel.select(f.newStdField("ID_USER"),
                    f.newStdField("login"),
                    f.newStdField("name"),
                    f.newStdField("surname"),
                    f.newStdField("age"),
                    f.newStdField("address"),
                    f.newStdField("email"),
                    f.newStdField("isActive"))
                    .from("user")
                    .join("user_info",
                            f.newQualifiedField("user", "ID_USER"),
                            f.newQualifiedField("user_info", "USER_ID_USER"),
                            QbSelect.QbJoinType.INNER)
                    .where()
                    .where(f.newStdField("login"), QbWhereOperator.EQUALS, ":login");
            stmt = connection.prepareStatement(sel.getQueryString());
            stmt.setString(sel.getPlaceholderIndex(":login"), username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                RoleDAO roleDAO = DAOFactory.getInstance().getRoleDAO();
                user = User.newBuilder()
                        .setId(Long.valueOf(rs.getString("ID_USER")))
                        .setUsername(rs.getString("login"))
                        .setFirstname(rs.getString("name"))
                        .setSurname(rs.getString("surname"))
                        .setAge(rs.getString("age"))
                        .setAddress(rs.getString("address"))
                        .setEmail(rs.getString("email"))
                        .setActive(Boolean.valueOf(rs.getString("isActive")))
                        .setRoles(roleDAO.findAllRoles(Long.valueOf(rs.getString("ID_USER"))))
                        .build();
            }

        } catch (SQLException e) {
            throw new DAOException("User not find by this name", e);
        }
        return user;

    }

    @Override
    public User checkUser(String login, String password) throws DAOException {
        QbFactory f = new QbFactoryImp();
        User user = null;
        try (Connection connection = takeConnectionFromPool()){
            PreparedStatement stmt;
            QbSelect sel = f.newSelectQuery();
            sel.select(f.newStdField("ID_USER"),
                    f.newStdField("login"),
                    f.newStdField("password"),
                    f.newStdField("name"),
                    f.newStdField("surname"),
                    f.newStdField("age"),
                    f.newStdField("address"),
                    f.newStdField("email"),
                    f.newStdField("isActive"))
                    .from("user")
                    .join("user_info",
                            f.newQualifiedField("user", "ID_USER"),
                            f.newQualifiedField("user_info", "USER_ID_USER"),
                            QbSelect.QbJoinType.INNER)
                    .where()
                    .where(f.newStdField("login"), QbWhereOperator.EQUALS, ":login")
                    .where(f.newStdField("password"), QbWhereOperator.EQUALS, ":password");
            stmt = connection.prepareStatement(sel.getQueryString());
            stmt.setString(sel.getPlaceholderIndex(":login"), login);
            stmt.setString(sel.getPlaceholderIndex(":password"), password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                RoleDAO roleDAO = DAOFactory.getInstance().getRoleDAO();
                user = User.newBuilder()
                        .setId(Long.valueOf(rs.getString("ID_USER")))
                        .setUsername(rs.getString("login"))
                        .setFirstname(rs.getString("name"))
                        .setSurname(rs.getString("surname"))
                        .setAge(rs.getString("age"))
                        .setAddress(rs.getString("address"))
                        .setEmail(rs.getString("email"))
                        .setActive(Boolean.valueOf(rs.getString("isActive")))
                        .setRoles(roleDAO.findAllRoles(Long.valueOf(rs.getString("ID_USER"))))
                        .build();
            }else {
                return null;
            }
        }catch (SQLException e) {
            throw new DAOException("User not find by this 'login' and 'password'", e);
        }
        return user;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(User entity) {

    }


    private Connection takeConnectionFromPool() throws DAOException {
        ConnectionPool conPool = ConnectionPool.getInstance();

        try {
            return conPool.takeConnection();
        } catch (InterruptedException e) {
            throw new DAOException("Can't take a connection from connPool", e);
        }

    }
}

