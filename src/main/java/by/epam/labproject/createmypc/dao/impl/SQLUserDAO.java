package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.UserDAO;
import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbFactory;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbSelect;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbWhere.QbWhereOperator;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic.QbFactoryImp;
import by.epam.labproject.createmypc.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SQLUserDAO implements UserDAO {
    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Iterable saveAll(Iterable entities) {
        return null;
    }

    @Override
    public Optional findById(Object entity) {
        return Optional.empty();
    }

    @Override
    public Iterable findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public User findByUsername(String username) throws DAOException {
        QbFactory f = new QbFactoryImp();
        User user = null;
        try {Connection connection = takeConnectionFromPool();
            PreparedStatement stmt;
            QbSelect sel = f.newSelectQuery();
            sel.select(f.newStdField("ID_USERS"),f.newStdField("login"),f.newStdField("password"))
                    .from("users")
                    .where()
                    .where(f.newStdField("login"), QbWhereOperator.EQUALS, ":username");
            assert(sel.getQueryString().equals("SELECT `ID_USERS`, `login`, `password` FROM `users`  WHERE `login` = ?"));
            stmt = connection.prepareStatement(sel.getQueryString());
            stmt.setString(sel.getPlaceholderIndex(":username"), username);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(Long.valueOf(rs.getString(1)));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
            }

        } catch (SQLException | InterruptedException e) {
            throw new DAOException("message foe change", e);
        }
        return user;

    }
    private Connection takeConnectionFromPool () throws InterruptedException {
         ConnectionPool conPool = ConnectionPool.getInstance();

        return conPool.takeConnection();

    }
}

