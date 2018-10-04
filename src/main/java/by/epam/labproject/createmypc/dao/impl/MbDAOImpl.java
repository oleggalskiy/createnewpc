package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.MbDAO;
import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbFactory;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbSelect;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic.QbFactoryImp;
import by.epam.labproject.createmypc.domain.DDRBean;
import by.epam.labproject.createmypc.domain.MBBean;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MbDAOImpl implements MbDAO {

    private final static Logger LOGGER = Logger.getLogger(MbDAOImpl.class.getSimpleName());
    @Override
    public MBBean save(MBBean entity) throws DAOException {
        return null;
    }

    @Override
    public Iterable<MBBean> saveAll(Iterable<MBBean> entities) {
        return null;
    }

    @Override
    public MBBean findById(Long entity) throws DAOException {
        return null;
    }

    @Override
    public Iterable<MBBean> findAll() throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        List<MBBean> allMB = new ArrayList<>();
        try (Connection connection = ConnectionPool.takeConnectionFromPool()){
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newStdField("ID_MB"),
                    qbfac.newStdField("Name"),
                    qbfac.newStdField("CPU_socket"),
                    qbfac.newStdField("chipset"),
                    qbfac.newStdField("memory_type"),
                    qbfac.newStdField("memory_stots"),
                    qbfac.newStdField("memory_max_Gb"),
                    qbfac.newStdField("VGA_sup"),
                    qbfac.newStdField("Name_Fab"))
                    .join("fabricator", qbfac.newStdField("Fabricator_ID_Fab"),qbfac.newStdField("ID_Fab"), QbSelect.QbJoinType.INNER )
                    .from("mb");
            stmt = connection.prepareStatement(sel.getQueryString());
            LOGGER.info("\n==Take PreparedStatement==\n");
            ResultSet rs = stmt.executeQuery();
            LOGGER.info("\n==Execute query: " + sel.getQueryString() + "===\n");
            while (rs.next()) {
                MBBean newMbBean = MBBean.newBuilder()
                        .setNestedIdMb(rs.getLong("ID_MB"))
                        .setNestedMbName(rs.getString("Name"))
                        .setNestedMbCpuSocket(rs.getString("CPU_socket"))
                        .setNestedMbChipset(rs.getString("chipset"))
                        .setNestedMbMemoryType(rs.getString("memory_type"))
                        .setNestedMbMemorySlots(Integer.valueOf(rs.getString("memory_stots")))
                        .setNestedMbMemoryMaxGb(Integer.valueOf(rs.getString("memory_max_Gb")))
                        .setNestedMbVgaSup(rs.getString("VGA_sup"))
                        .setNestedMbFabricator(rs.getString("Name_Fab"))
                        .build();
                allMB.add(newMbBean);
            }
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't find motherboards in to DB", e);
        }
        return allMB;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(MBBean entity) {

    }
}
