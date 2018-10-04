package by.epam.labproject.createmypc.service.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.VgaDAO;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.VGABean;
import by.epam.labproject.createmypc.service.VgaBeanService;
import by.epam.labproject.createmypc.service.exception.ServiceException;

public class VgaBeanServiceImpl implements VgaBeanService {
    @Override
    public VGABean findByID(Long id) throws ServiceException {
        return null;
    }

    @Override
    public VGABean save(VGABean domain) throws ServiceException {
        return null;
    }

    @Override
    public void update(VGABean domain) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public Iterable<VGABean> findAll() {
        VgaDAO dao = getDaoFromFactory();
        try {
            return  dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private VgaDAO getDaoFromFactory() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getVgaDAO();

    }
}
