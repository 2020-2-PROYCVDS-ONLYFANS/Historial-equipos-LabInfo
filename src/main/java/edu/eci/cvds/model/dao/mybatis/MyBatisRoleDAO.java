package edu.eci.cvds.model.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.model.dao.RoleDAO;
import edu.eci.cvds.model.dao.mybatis.mappers.RoleMapper;
import edu.eci.cvds.model.entities.Role;
import org.apache.ibatis.exceptions.PersistenceException;

public class MyBatisRoleDAO implements RoleDAO {

    @Inject
    RoleMapper roleMapper;

    @Override
    public void registerRole(String roleName) throws PersistenceException {
        try {
            roleMapper.registerRole(roleName);
        } catch (PersistenceException e) {
            throw new PersistenceException("Fail to register role " + roleName, e);
        }
    }

    @Override
    public Role loadByRoleName(String roleName) throws PersistenceException {
        try {
            return roleMapper.loadByRoleName(roleName);
        } catch (PersistenceException e) {
            throw new PersistenceException("Fail to load role " + roleName, e);
        }
    }
}