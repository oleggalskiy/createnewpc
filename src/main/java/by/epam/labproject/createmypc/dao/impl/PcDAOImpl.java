package by.epam.labproject.createmypc.dao.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.PcDAO;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.dao.sqlqueryhelper.SQLHelperFactory;
import by.epam.labproject.createmypc.dao.sqlqueryhelper.SqlQueryHelper;
import by.epam.labproject.createmypc.domain.PCBean;
import by.epam.labproject.createmypc.domain.User;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class PcDAOImpl implements PcDAO {

    public final static Logger logger = Logger.getLogger(PcDAOImpl.class);

    private SQLHelperFactory factory = SQLHelperFactory.getInstance();
    private SqlQueryHelper queryHelper =  factory.getSQLHelper();
    private final String TABLE_NAME = "pc";
    private final String COLUMN_1 = "ID_PC";
    private final String COLUMN_2 = "Create_date";
    private final String COLUMN_3 = "Is_Active";
    private final String COLUMN_4 = "USERS_ID_USERS";


    @Override
    public PCBean save(PCBean entity) throws DAOException {
        return null;
    }

    @Override
    public Iterable<PCBean> saveAll(Iterable entities) {
        return null;
    }

    @Override
    public Optional findById(Long id) {

        return Optional.empty();
    }

    @Override
    public Iterable<PCBean> findAll() throws DAOException {
        List<PCBean> allPc = new ArrayList<PCBean>();

        ResultSet resObj;
        queryHelper.connectDb();
        queryHelper.setTable(TABLE_NAME);
        setColumns();
        resObj = queryHelper.displayAllRecords();
        try {
            if(!resObj.next()){
                logger.info("\n=======No Records Are Present In The '" + TABLE_NAME + "'=======\n");
                return allPc;
            }else {
                do {
                    User user = DAOFactory.getInstance().getUserDAO().findByUsername("Malkom");
                    PCBean pcBean = PCBean.newBuilder().
                            setIdPC(Integer.toUnsignedLong(resObj.getInt(COLUMN_1)))
                            .setDate(resObj.getString(COLUMN_2))
                            .setAuthor(user)
                            .build();
                    allPc.add(pcBean);
                } while (resObj.next());
                logger.info("\n=======All Records Displayed From The '" + TABLE_NAME + "'=======\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            queryHelper.disconnectDb();
        }
       return allPc;
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

    private void setColumns(){
        queryHelper.setColumns(COLUMN_1, "int", 11);
        queryHelper.setColumns(COLUMN_2, "date", 11);
        queryHelper.setColumns(COLUMN_3, "bit", 1);
        queryHelper.setColumns(COLUMN_4, "int", 11);
    }
}
