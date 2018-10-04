package by.epam.labproject.createmypc.service.impl;

import by.epam.labproject.createmypc.dao.CpuDAO;
import by.epam.labproject.createmypc.dao.DAOFactory;
import by.epam.labproject.createmypc.dao.exception.DAOException;
import by.epam.labproject.createmypc.domain.CPUBean;
import by.epam.labproject.createmypc.service.CpuBeanService;
import by.epam.labproject.createmypc.service.exception.ServiceException;

public class CpuBeanServiceImpl implements CpuBeanService {
    @Override
    public CPUBean findByID(Long id) throws ServiceException {
        return null;
    }

    @Override
    public CPUBean save(CPUBean domain) throws ServiceException {
        return null;
    }

    @Override
    public void update(CPUBean domain) throws ServiceException {

    }

    @Override
    public void delete(Long id) throws ServiceException {

    }

    @Override
    public Iterable<CPUBean> findAll() {
        CpuDAO dao = getDaoFromFactory();
        try {
            return  dao.findAll();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private CpuDAO getDaoFromFactory() {
        DAOFactory factory = DAOFactory.getInstance();
        return factory.getCpuDAO();

    }
}
