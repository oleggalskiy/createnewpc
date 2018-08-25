package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.UserDAO;
import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbFactory;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbInsert;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbSelect;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbWhere.QbWhereOperator;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic.QbFactoryImp;
import by.epam.labproject.createmypc.domain.User;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SQLUserDAO implements UserDAO {

    @Override
    public User save(User entity)throws DAOException {
        User newUser = null;
        Connection connection =  takeConnectionFromPool();
        try {connection = takeConnectionFromPool();
            connection.setAutoCommit(false);
                try {newUser = entity;
                     newUser = saveUserInUsersTable(newUser, connection);
                     newUser = saveUserInUserInfoTable(newUser, connection);
                    connection.commit();
        } catch (SQLException | DAOException e) {
                    connection.rollback();
                    throw new DAOException("Can't insert user in to 'users' or 'user_info' table", e);
        }
        } catch ( SQLException e ) {
            throw new DAOException("Can't insert user in to 'users' or 'user_info' table", e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO log error
            }
        }
        return  newUser;
    }

    public User saveUserInUsersTable(User entity, Connection entityConnection)throws DAOException{
        QbFactory f = new QbFactoryImp();
        User user;
        long autoIncKeyFromUsers = -1l;
        try {Connection connection = entityConnection;
            user =  entity;
            PreparedStatement stmt;
            QbInsert ins = f.newInsertQuery();
            ins.set(f.newStdField("login"),":username")
                    .set(f.newStdField("password"),":password")
                    .inTable("users");
            stmt = connection.prepareStatement(ins.getQueryString());
            stmt.setString(ins.getPlaceholderIndex(":username"),user.getUsername());
            stmt.setString(ins.getPlaceholderIndex(":password"),user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = null;

            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");

            if (rs.next()) {
                autoIncKeyFromUsers = rs.getLong(1);
            }
            user.setId(autoIncKeyFromUsers);
        }catch (SQLException  e) {
            throw new DAOException("Can't insert user in to 'users' table", e);
        }
        return user;

    }

    public User saveUserInUserInfoTable(User entity, Connection entityConnection) throws  DAOException{
        QbFactory f = new QbFactoryImp();
        User user = null;
        String infoId = null;
        try { Connection connection = entityConnection;
            user =  entity;
            PreparedStatement stmt;
            QbInsert ins = f.newInsertQuery();
            ins.set(f.newStdField("name"),":firstname")
                    .set(f.newStdField("surname"),":surname")
                    .set(f.newStdField("email"),":email")
                    .set(f.newStdField("age"),":age")
                    .set(f.newStdField("address"),":address")
                    .set(f.newStdField("isActive"),":active")
                    .set(f.newStdField("USERS_ID_USERS"),":ID_USERS")
                    .inTable("user_info");
            stmt = connection.prepareStatement(ins.getQueryString());
            stmt.setString(ins.getPlaceholderIndex(":firstname"),user.getFirstname());
            stmt.setString(ins.getPlaceholderIndex(":surname"),user.getSurname());
            stmt.setString(ins.getPlaceholderIndex(":email"),user.getEmail());
            stmt.setString(ins.getPlaceholderIndex(":age"),user.getAge());
            stmt.setString(ins.getPlaceholderIndex(":address"),user.getAddress());
            stmt.setString(ins.getPlaceholderIndex(":active"),String.valueOf(user.isActive()));
            stmt.setString(ins.getPlaceholderIndex(":ID_USERS"),String.valueOf(user.getId()));
            stmt.executeUpdate();
        }catch (SQLException  e) {
            throw new DAOException("Can't insert user in to 'user_info' tabl", e);
        }
        return user;
    }

    @Override
    public Iterable saveAll(Iterable entities) {
        return null;
    }


    @Override
    public Optional findById(ID entity) {
        return Optional.empty();
    }

    @Override
    public Iterable findAll()  throws DAOException{
        QbFactory f = new QbFactoryImp();
        List<User> users = new ArrayList<>();
         try(Connection connection = takeConnectionFromPool()){
            PreparedStatement stmt;
            QbSelect sel = f.newSelectQuery();
            sel.select(f.newStdField("ID_USERS"),
                    f.newStdField("login"),
                    f.newStdField("name"),
                    f.newStdField("surname" ),
                    f.newStdField("age"),
                    f.newStdField("address"),
                    f.newStdField("email"),
                    f.newStdField("isActive"))
                    .from("users")
                    .join("user_info",
                      f.newQualifiedField("users", "ID_USERS"),
                      f.newQualifiedField("user_info", "USERS_ID_USERS"),
                       QbSelect.QbJoinType.INNER);
            assert(sel.getQueryString().equals("SELECT `ID_USERS`, `login`, `name`, `surname`, `age`, `address`, `email`, `isActive` FROM `users` INNER JOIN `user_info` ON `users`.`ID_USERS` = `user_info`.`USERS_ID_USERS`"));
            stmt = connection.prepareStatement(sel.getQueryString());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
               User user = User.newBuilder()
                        .setId(Long.valueOf(rs.getString(1)))
                        .setUsername(rs.getString(2))
                        .setFirstname(rs.getString(3))
                        .setSurname(rs.getString(4))
                        .setAge(rs.getString(5))
                        .setAddress(rs.getString(6))
                        .setEmail(rs.getString(7))
                        .setActive(Boolean.valueOf(rs.getString(8)))
                        .build();
               users.add(user);
            }}
            catch (SQLException  e) {
            throw new DAOException("Users not find", e);
        }
        return users;
    }

    @Override
    public User findByUsername(String username) throws DAOException {
        QbFactory f = new QbFactoryImp();
        User user = null;
        try(Connection connection = takeConnectionFromPool()){
            PreparedStatement stmt;
            QbSelect sel = f.newSelectQuery();
            sel.select(f.newStdField("ID_USERS"),f.newStdField("login"),f.newStdField("name"),f.newStdField("surname" ),f.newStdField("age"),f.newStdField("address"),f.newStdField("email"), f.newStdField("isActive"))
                    .from("users").join("user_info",f.newQualifiedField("users", "ID_USERS"),f.newQualifiedField("user_info", "USERS_ID_USERS"), QbSelect.QbJoinType.INNER)
                    .where()
                    .where(f.newStdField("login"), QbWhereOperator.EQUALS, ":username");
            System.out.println(sel.getQueryString());
            assert(sel.getQueryString().equals("SELECT `ID_USERS`, `login`, `name`, `surname`, `age`, `address`, `email`, `isActive` FROM `users` INNER JOIN `user_info` ON `users`.`ID_USERS` = `user_info`.`USERS_ID_USERS` WHERE `login` = ?"));
            stmt = connection.prepareStatement(sel.getQueryString());
            stmt.setString(sel.getPlaceholderIndex(":username"), username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){

                user = User.newBuilder()
                        .setId(Long.valueOf(rs.getString(1)))
                        .setUsername(rs.getString(2))
                        .setFirstname(rs.getString(3))
                        .setSurname(rs.getString(4))
                        .setAge(rs.getString(5))
                        .setAddress(rs.getString(6))
                        .setEmail(rs.getString(7))
                        .setActive(Boolean.valueOf(rs.getString(8)))
                        .build();
            }

        } catch (SQLException e) {
            throw new DAOException("User not find by this name", e);
        }
        return user;

    }
    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public void delete(User entity) {

    }

    private Connection takeConnectionFromPool () throws DAOException {
         ConnectionPool conPool = ConnectionPool.getInstance();

        try {
            return conPool.takeConnection();
        } catch (InterruptedException e) {
            throw new DAOException("Can't take a connection from connPool", e);
        }

    }
}

