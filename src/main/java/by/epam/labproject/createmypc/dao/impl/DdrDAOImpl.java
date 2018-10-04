package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.DdrDAO;
import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbFactory;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbSelect;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbWhere;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic.QbFactoryImp;
import by.epam.labproject.createmypc.domain.DDRBean;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DdrDAOImpl implements DdrDAO {
    private final static Logger LOGGER = Logger.getLogger(DdrDAOImpl.class.getSimpleName());
    @Override
    public DDRBean save(DDRBean entity) throws DAOException {
        return null;
    }

    @Override
    public Iterable<DDRBean> saveAll(Iterable<DDRBean> entities) {
        return null;
    }

    @Override
    public DDRBean findById(Long entity) throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        try (Connection connection = ConnectionPool.takeConnectionFromPool()){
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newStdField("ID_DDR"),
                    qbfac.newStdField("Name"),
                    qbfac.newStdField("DDR_type"),
                    qbfac.newStdField("Form"),
                    qbfac.newStdField("Frequency_MGz"),
                    qbfac.newStdField("Size_Gb"),
                    qbfac.newStdField("Name_Fab"))
                    .join("fabricator", qbfac.newStdField("Fabricator_ID_Fab"),qbfac.newStdField("ID_Fab"), QbSelect.QbJoinType.INNER )
                    .from("ddr")
                    .where()
                    .where(qbfac.newStdField("ID_DDR"), QbWhere.QbWhereOperator.EQUALS, ":ID_DDR");
            stmt = connection.prepareStatement(sel.getQueryString());
            LOGGER.info("\n==Take PreparedStatement==\n");
            stmt.setString(sel.getPlaceholderIndex(":ID_DDR"), String.valueOf(entity));
            ResultSet rs = stmt.executeQuery();
            LOGGER.info("\n==Execute query: " + sel.getQueryString() + "===\n");
            if (rs.next()) {
                DDRBean newDdrBean = DDRBean.newBuilder()
                        .setNestedIdDdr(rs.getLong("ID_DDR"))
                        .setNestedDdrName(rs.getString("Name"))
                        .setNestedDdrType(rs.getString("DDR_type"))
                        .setNestedDdrForm(rs.getString("Form"))
                        .setNestedDdrFrequency(String.valueOf(rs.getInt("Frequency_MGz")))
                        .setNestedDdrSize(rs.getString("Size_Gb"))
                        .setNestedDdrFabricator(rs.getString("Name_Fab"))
                        .build();
                return newDdrBean;
            }
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't find ddr in to DB", e);
        }
        return null;
    }

    @Override
    public Iterable<DDRBean> findAll() throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        List<DDRBean> allDdr = new ArrayList<>();
        try (Connection connection = ConnectionPool.takeConnectionFromPool()){
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newStdField("ID_DDR"),
                    qbfac.newStdField("Name"),
                    qbfac.newStdField("DDR_type"),
                    qbfac.newStdField("Form"),
                    qbfac.newStdField("Frequency_MGz"),
                    qbfac.newStdField("Size_Gb"),
                    qbfac.newStdField("Name_Fab"))
                    .join("fabricator", qbfac.newStdField("Fabricator_ID_Fab"),qbfac.newStdField("ID_Fab"), QbSelect.QbJoinType.INNER )
                    .from("ddr");
            stmt = connection.prepareStatement(sel.getQueryString());
            LOGGER.info("\n==Take PreparedStatement==\n");
            ResultSet rs = stmt.executeQuery();
            LOGGER.info("\n==Execute query: " + sel.getQueryString() + "===\n");
            while (rs.next()) {
                DDRBean newDdrBean = DDRBean.newBuilder()
                        .setNestedIdDdr(rs.getLong("ID_DDR"))
                        .setNestedDdrName(rs.getString("Name"))
                        .setNestedDdrType(rs.getString("DDR_type"))
                        .setNestedDdrForm(rs.getString("Form"))
                        .setNestedDdrFrequency(String.valueOf(rs.getInt("Frequency_MGz")))
                        .setNestedDdrSize(rs.getString("Size_Gb"))
                        .setNestedDdrFabricator(rs.getString("Name_Fab"))
                        .build();
                allDdr.add(newDdrBean);
            }
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't find ddr in to DB", e);
        }
        return allDdr;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(DDRBean entity) {

    }



}
