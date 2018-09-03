package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.PcDAO;
import by.epam.labproject.createmypc.dao.UserDAO;
import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbFactory;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbInsert;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbSelect;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbWhere;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic.QbFactoryImp;
import by.epam.labproject.createmypc.domain.PCBean;
import com.sun.istack.internal.Nullable;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PcDAOImpl implements PcDAO {
    private final static Logger LOGGER = Logger.getLogger(PcDAOImpl.class.getSimpleName());
    @Nullable
    private PCBean newPC;

    @Override
    public PCBean save(PCBean entity) throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        try (Connection con = takeConnectionFromPool()) {
            try {
                con.setAutoCommit(false);
                LOGGER.info("\n==Set AutoCommit=False==\n");
                newPC = entity;
                PreparedStatement stmt;
                QbInsert ins = qbfac.newInsertQuery();
                ins.set(qbfac.newStdField("user_id_user"), ":id_user")
                        .set(qbfac.newStdField("date"), ":date")
                        .set(qbfac.newStdField("active"), ":active")
                        .inTable("pc");
                stmt = con.prepareStatement(ins.getQueryString());
                LOGGER.info("\n==Take PreparedStatement==\n");
                stmt.setString(ins.getPlaceholderIndex(":id_user"), newPC.getAutorId());
                stmt.setString(ins.getPlaceholderIndex(":date"), newPC.getDate());
                stmt.setString(ins.getPlaceholderIndex(":active"), String.valueOf(newPC.getActive()));
                stmt.executeUpdate();
                LOGGER.info("\n==Execute query" + ins.getQueryString() + "===\n");
                con.commit();
            } catch (SQLException e) {
                LOGGER.fatal("Can't insert newPC in to 'pc' table");
                con.rollback();
                throw new DAOException("Can't insert newPC in to 'pc' table", e);
            }
        } catch (SQLException e) {
            throw new DAOException("Can't insert pc in to DB", e);
        }
        return newPC;
    }

    @Override
    public Iterable<PCBean> saveAll(Iterable<PCBean> entities) {


        return null;
    }

    @Override
    public Optional<PCBean> findById(Long entity) throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        try (Connection connection = takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newStdField("ID_PC"),
                    qbfac.newStdField("USER_ID_USER"),
                    qbfac.newStdField("date"),
                    qbfac.newStdField("active"))
                    .from("pc")
                    .where()
                    .where(qbfac.newStdField("ID_PC"), QbWhere.QbWhereOperator.EQUALS, ":ID_PC");
            stmt = connection.prepareStatement(sel.getQueryString());
            LOGGER.info("\n==Take PreparedStatement==\n");
            stmt.setString(sel.getPlaceholderIndex(":ID_PC"), String.valueOf(entity));
            ResultSet rs = stmt.executeQuery();
            LOGGER.info("\n==Execute query" + sel.getQueryString() + "===\n");
            if (rs.next()) {
                newPC = PCBean.newBuilder()
                        .setIdPC(rs.getLong(":ID_PC"))
                        .setAuthor(userDAO.findById(rs.getLong(2)).orElseThrow(() -> new DAOException("Can't find user by current id")))
                        .setDate(rs.getString(":date"))
                        .setIsActive(Boolean.valueOf(rs.getString("active")))
                        .build();
            }
            return Optional.ofNullable(newPC);
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't find pc in to DB", e);
        }
    }

    @Override
    public Iterable<PCBean> findAll() throws DAOException {
        List<PCBean> findPCs = new ArrayList<>();
        QbFactory qbfac = new QbFactoryImp();
        UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
        try (Connection connection = takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newStdField("ID_PC"),
                    qbfac.newStdField("USER_ID_USER"),
                    qbfac.newStdField("date"),
                    qbfac.newStdField("active"))
                    .from("pc");
            stmt = connection.prepareStatement(sel.getQueryString());
            LOGGER.info("\n==Take PreparedStatement==\n");
            ResultSet rs = stmt.executeQuery();
            LOGGER.info("\n==Execute query" + sel.getQueryString() + "===\n");
            while (rs.next()) {
                newPC = PCBean.newBuilder()
                        .setIdPC(rs.getLong("ID_PC"))
                        .setAuthor(userDAO.findById(rs.getLong("USER_ID_USER")).get())
                        .setDate(rs.getString("date"))
                        .setIsActive(Boolean.valueOf(rs.getString("active")))
                        .build();
                findPCs.add(newPC);
            }
            return findPCs;
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't find pc in to DB", e);
        }
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(PCBean entity) {

    }

    private Connection takeConnectionFromPool() throws DAOException {
        ConnectionPool conPool = ConnectionPool.getInstance();
        try {
            Connection con;
            con = conPool.takeConnection();
            LOGGER.info("\n=======Database Connection Open=======\n");
            return con;
        } catch (InterruptedException e) {
            LOGGER.fatal("\n==Can't take a connection from connPool===\n");
            throw new DAOException("Can't take a connection from connPool", e);
        }

    }
}
