package by.epam.labproject.createmypc.dao;

import by.epam.labproject.createmypc.dao.exception.DAOException;

import java.util.Set;

public interface RoleDAO<Role> {

    Role addRole(Role newRole, Long userId) throws DAOException;
    Set<Role> findAllRoles(Long userId) throws DAOException;
    Set<Role> saveAllRoles(Set<Role> saveRoles, Long userId) throws DAOException;
    void removeRole(Role removeRole, Long userId) throws DAOException;
    Role findRoleByUserId(Long userId)throws DAOException;

}
