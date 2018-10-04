package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.VgaDAO;
import by.epam.labproject.createmypc.dao.connectionpool.ConnectionPool;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbFactory;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.QbSelect;
import by.epam.labproject.createmypc.dao.javasqlquerybuilder.generic.QbFactoryImp;
import by.epam.labproject.createmypc.domain.VGABean;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VgaDAOImpl implements VgaDAO {

    private final static Logger LOGGER = Logger.getLogger(VgaDAOImpl.class.getSimpleName());
    @Override
    public VGABean save(VGABean entity) throws DAOException {
        return null;
    }

    @Override
    public Iterable<VGABean> saveAll(Iterable<VGABean> entities) {
        return null;
    }

    @Override
    public VGABean findById(Long entity) throws DAOException {
        return null;
    }

    @Override
    public Iterable<VGABean> findAll() throws DAOException {
        QbFactory qbfac = new QbFactoryImp();
        List<VGABean> allVGA = new ArrayList<>();
        try (Connection connection = ConnectionPool.takeConnectionFromPool()){
            PreparedStatement stmt;
            QbSelect sel = qbfac.newSelectQuery();
            sel.select(qbfac.newStdField("ID_VGA"),
                    qbfac.newStdField("Name"),
                    qbfac.newStdField("Graph_proc"),
                    qbfac.newStdField("Frenq_proc_MGz"),
                    qbfac.newStdField("Interface"),
                    qbfac.newStdField("VRAM_Mb"),
                    qbfac.newStdField("Type_VRAM"),
                    qbfac.newStdField("Shaders"),
                    qbfac.newStdField("Name_Fab"))
                    .join("fabricator", qbfac.newStdField("Fabricator_ID_Fab"),qbfac.newStdField("ID_Fab"), QbSelect.QbJoinType.INNER )
                    .from("vga");
            stmt = connection.prepareStatement(sel.getQueryString());
            LOGGER.info("\n==Take PreparedStatement==\n");
            ResultSet rs = stmt.executeQuery();
            LOGGER.info("\n==Execute query: " + sel.getQueryString() + "===\n");
            while (rs.next()) {
                VGABean newVgaBean = VGABean.newBuilder()
                        .setNestedIdVga(rs.getLong("ID_VGA"))
                        .setNestedVgaName(rs.getString("Name"))
                        .setNestedVgaGraphProc(rs.getString("Graph_proc"))
                        .setNestedVgaFrecProcMhz(String.valueOf(rs.getInt("Frenq_proc_MGz")))
                        .setNestedVgaInterface(rs.getString("Interface"))
                        .setNestedVgaVramMb(String.valueOf(rs.getInt("VRAM_Mb")))
                        .setNestedVgaTypeVram(rs.getString("Type_VRAM"))
                        .setNestedVgShaders(rs.getString("Shaders"))
                        .setNestedVgaFabricator(rs.getString("Name_Fab"))
                        .build();
                allVGA.add(newVgaBean);
            }
        } catch (SQLException | DAOException e) {
            throw new DAOException("Can't find vga's in to DB", e);
        }
        return allVGA;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void delete(VGABean entity) {

    }
}
