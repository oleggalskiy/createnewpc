package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.CpuDAO;
import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbFactory;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbSelect;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbWhere;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic.QbFactoryImp;
import by.epam.labproject.createmypc.domain.CPUBean;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CpuDAOImpl implements CpuDAO {
    private final static Logger LOGGER = Logger.getLogger(CpuDAOImpl.class.getSimpleName());

    @Override
    public CPUBean save(CPUBean entity) throws DAOException {
        return null;
    }

    @Override
    public Iterable<CPUBean> saveAll(Iterable<CPUBean> entities) {
        return null;
    }

    @Override
    public CPUBean findById(Long entity) throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        try (Connection connection = ConnectionPool.takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newStdField("ID_CPU"),
                    qbfac.newStdField("Name"),
                    qbfac.newStdField("Socket"),
                    qbfac.newStdField("Core"),
                    qbfac.newStdField("Number_cores"),
                    qbfac.newStdField("Process_tech_nm"),
                    qbfac.newStdField("Frequency_MGz"),
                    qbfac.newStdField("System_bus"),
                    qbfac.newStdField("Name_Fab"))
                    .join("fabricator", qbfac.newStdField("Fabricator_ID_Fab"),qbfac.newStdField("ID_Fab"), QbSelect.QbJoinType.INNER )
                    .from("cpu")
                    .where()
                    .where(qbfac.newStdField("ID_CPU"), QbWhere.QbWhereOperator.EQUALS, ":ID_CPU");
            stmt = connection.prepareStatement(sel.getQueryString());
            LOGGER.info("\n==Take PreparedStatement==\n");
            stmt.setString(sel.getPlaceholderIndex(":ID_CPU"), String.valueOf(entity));
            ResultSet rs = stmt.executeQuery();
            LOGGER.info("\n==Execute query: " + sel.getQueryString() + "===\n");
            if (rs.next()) {
                CPUBean newCpuBean = CPUBean.newBuilder()
                        .setNestedIdCpu(rs.getLong("ID_CPU"))
                        .setNestedNameCPU(rs.getString("Name"))
                        .setNestedCpuSocket(rs.getString("Socket"))
                        .setNestedCpuCore(rs.getString("Core"))
                        .setNestedCpuNumberCores(String.valueOf(rs.getInt("Number_cores")))
                        .setNestedCpuProcess(String.valueOf(rs.getInt("Process_tech_nm")))
                        .setNestedCpuFrequency(String.valueOf(rs.getInt("Frequency_MGz")))
                        .setNestedCpuSystemBus(rs.getString("System_bus"))
                        .setNestedCpuFabricator(rs.getString("Name_Fab"))
                        .build();
                    return newCpuBean;
            }
            return null;
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't find cpu in to DB", e);
        }
    }

    @Override
    public Iterable<CPUBean> findAll() throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        List<CPUBean> allCpu = new ArrayList<>();
        try (Connection connection = ConnectionPool.takeConnectionFromPool()) {
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newStdField("ID_CPU"),
                    qbfac.newStdField("Name"),
                    qbfac.newStdField("Socket"),
                    qbfac.newStdField("Core"),
                    qbfac.newStdField("Number_cores"),
                    qbfac.newStdField("Process_tech_nm"),
                    qbfac.newStdField("Frequency_MGz"),
                    qbfac.newStdField("System_bus"),
                    qbfac.newStdField("Name_Fab"))
                    .join("fabricator", qbfac.newStdField("Fabricator_ID_Fab"),qbfac.newStdField("ID_Fab"), QbSelect.QbJoinType.INNER )
                    .from("cpu");
            stmt = connection.prepareStatement(sel.getQueryString());
            LOGGER.info("\n==Take PreparedStatement==\n");
            ResultSet rs = stmt.executeQuery();
            LOGGER.info("\n==Execute query: " + sel.getQueryString() + "===\n");
            while(rs.next()) {
                CPUBean cpuBean = CPUBean.newBuilder()
                        .setNestedIdCpu(rs.getLong("ID_CPU"))
                        .setNestedNameCPU(rs.getString("Name"))
                        .setNestedCpuSocket(rs.getString("Socket"))
                        .setNestedCpuCore(rs.getString("Core"))
                        .setNestedCpuNumberCores(String.valueOf(rs.getInt("Number_cores")))
                        .setNestedCpuProcess(String.valueOf(rs.getInt("Process_tech_nm")))
                        .setNestedCpuFrequency(String.valueOf(rs.getInt("Frequency_MGz")))
                        .setNestedCpuSystemBus(rs.getString("System_bus"))
                        .setNestedCpuFabricator(rs.getString("Name_Fab"))
                        .build();
                    allCpu.add(cpuBean);
            }
            return allCpu;
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't find cpu in to DB", e);
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
    public void delete(CPUBean entity) {

    }

}
