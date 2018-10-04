package by.epam.labproject.createmypc.service.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.DdrDAO;
import by.epam.labproject.createmypc.dao.MbDAO;
import by.epam.labproject.createmypc.dao.VgaDAO;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.MBBean;
import by.epam.labproject.createmypc.service.MbBeanService;
import by.epam.labproject.createmypc.service.exception.ServiceException;

public class MbBeanServiceImpl implements MbBeanService {

    @Override
    public MBBean findByID(Long id) throws ServiceException {
        return null;
    }

    @Override
    public MBBean save(MBBean domain) throws ServiceException {
        return null;
    }

    @Override
    public void update(MBBean domain) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public Iterable<MBBean> findAll() {
       MbDAO dao = getDaoFromFactory();
        try {
            return  dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private MbDAO getDaoFromFactory() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getMbDAO();

    }
}
