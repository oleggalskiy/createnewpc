package by.epam.labproject.createmypc.service.impl;

import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.PcDAO;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.PCBean;
import by.epam.labproject.createmypc.service.PcService;
import by.epam.labproject.createmypc.service.exception.ServiceException;


import java.util.Optional;

public class PcServiceImpl implements PcService {
    @Override
    public Optional<PCBean> findByID(Long id) {
        PcDAO dao = getDaoFromFactory();
        try {
            return  dao.findById(id);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public PCBean save(PCBean domain) throws ServiceException {
        return null;
    }

    @Override
    public void update(PCBean domain) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public Iterable<PCBean> findAll() {
        PcDAO dao = getDaoFromFactory();
        try {
            return  dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }
    private PcDAO getDaoFromFactory() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getPcDAO();

    }
}
