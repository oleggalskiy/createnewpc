package by.epam.labproject.createmypc.service.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.DdrDAO;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.DDRBean;
import by.epam.labproject.createmypc.service.DdrBeanService;
import by.epam.labproject.createmypc.service.exception.ServiceException;

public class DdrBeanServiceImpl implements DdrBeanService {
    @Override
    public DDRBean findByID(Long id) throws ServiceException {
        return null;
    }

    @Override
    public DDRBean save(DDRBean domain) throws ServiceException {
        return null;
    }

    @Override
    public void update(DDRBean domain) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public Iterable<DDRBean> findAll() {
        DdrDAO dao = getDaoFromFactory();
        try {
            return  dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private DdrDAO getDaoFromFactory() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getDdrDAO();

    }
}
