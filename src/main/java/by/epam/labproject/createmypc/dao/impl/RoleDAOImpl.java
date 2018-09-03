package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.RoleDAO;
import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.*;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic.QbFactoryImp;
import by.epam.labproject.createmypc.domain.Role;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RoleDAOImpl implements RoleDAO<Role> {

    private final static Logger LOGGER = Logger.getLogger(RoleDAOImpl.class.getSimpleName());

    @Override
    public Role addRole(Role newRole, Long userId) throws DAOException{
        QbFactory qbfac = new QbFactoryImp();
        Role addNewRole;
        try (Connection con = takeConnectionFromPool()) {
            addNewRole = newRole;
            PreparedStatement stmt;
            QbInsert ins = qbfac.newInsertQuery();
            ins.set(qbfac.newStdField("USER_ID_USER"), ":USER_ID_USER")
                    .set(qbfac.newStdField("role"), ":role")
                    .inTable("roles");
            stmt = con.prepareStatement(ins.getQueryString());
            stmt.setString(ins.getPlaceholderIndex(":USER_ID_USER"), String.valueOf(userId));
            stmt.setString(ins.getPlaceholderIndex(":role"), newRole.name());
            LOGGER.info("\n=======Execute query"+ins.getQueryString()+"=======\n");
            stmt.executeUpdate();
            return addNewRole;
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't add new user role in 'roles' table");
        }
    }

    @Override
    public  Set<Role> findAllRoles(Long userId) throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
       Set<Role> addRoles = new HashSet<Role>();
        try (Connection con = takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newStdField("role"))
                    .from("roles")
                    .where()
                    .where(qbfac.newStdField("USER_ID_USER"), QbWhere.QbWhereOperator.EQUALS,":USER_ID_USER");
            stmt = con.prepareStatement(sel.getQueryString());
            stmt.setString(sel.getPlaceholderIndex(":USER_ID_USER"), String.valueOf(userId));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                addRoles.add(Role.valueOf(rs.getString("role")));
            }
            return addRoles;
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't add new user role in 'roles' table");
        }
    }

    @Override
    public Set<Role> saveAllRoles(Set<Role> saveRoles, Long userId) throws DAOException {
        Set<Role> saveAllRoles = new HashSet<Role>(saveRoles);
        for (Role role: saveAllRoles) {
            try {
                addRole(role,userId);
            } catch (DAOException e) {
                throw new DAOException("Can't add new user role in 'roles' table");
            }
        }
        return saveAllRoles;
    }

    @Override
    public void removeRole(Role removeRole, Long userId) throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        try (Connection con = takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbDelete del = qbfac.newDeleteQuery();
                del.from("roles")
                        .where()
                        .where(qbfac.newQualifiedField("role", ":role"), QbWhere.QbWhereOperator.EQUALS, ":role")
                        .where(qbfac.newQualifiedField("USER_ID_USER", ":USER_ID_USER"), QbWhere.QbWhereOperator.EQUALS, ":role");
            stmt = con.prepareStatement(del.getQueryString());
            stmt.setString(del.getPlaceholderIndex(":role"), removeRole.name());
            stmt.setString(del.getPlaceholderIndex(":USER_ID_USER"), String.valueOf(userId));
            stmt.executeUpdate();
        } catch (SQLException | DAOException e) {
           throw new DAOException("Can't remove role from 'roles' table");
        }

    }

    @Override
    public Role findRoleByUserId(Long userId) throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        Role findRole;
        try (Connection con = takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newAllField("role"))
                    .where().where(qbfac.newStdField(":USER_ID_USER"), QbWhere.QbWhereOperator.EQUALS, ":USER_ID_USER");
            LOGGER.info("\n=======Execute query"+sel.getQueryString()+"=======\n");
            stmt = con.prepareStatement(sel.getQueryString());
            stmt.setString(sel.getPlaceholderIndex(":USER_ID_USER"), String.valueOf(userId));
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                findRole = Role.valueOf(rs.getString("role"));
                return findRole;
            }
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't find role in 'roles' table");
        }





        return null;
    }


    private Connection takeConnectionFromPool() throws DAOException {
        ConnectionPool conPool = ConnectionPool.getInstance();
        try {
            Connection conn = conPool.takeConnection();
            LOGGER.info("\n=======Database Connection Open=======\n");
            return conn;
        } catch (InterruptedException e) {
            LOGGER.fatal("\n==Can't take a connection from connPool===\n");
            throw new DAOException("Can't take a connection from connPool", e);
        }
    }

}
