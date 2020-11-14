package edu.eci.cvds.model.guice.mybatis;

import edu.eci.cvds.model.dao.*;
import edu.eci.cvds.model.dao.mybatis.*;
import edu.eci.cvds.model.services.*;
import edu.eci.cvds.model.services.impl.*;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBatisModuleFactory {

    private static final MyBatisModuleFactory instance = new MyBatisModuleFactory();

    private static XMLMyBatisModule myBatisModule;

    private static final transient Logger LOGGER =
            LoggerFactory.getLogger(MyBatisModuleFactory.class);

    public MyBatisModuleFactory() { }

    private XMLMyBatisModule myBatisModule(String env, String pathResource) {
        return new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId(env);
                setClassPathResource(pathResource);

                bind(AuthServices.class).to(AuthServicesImpl.class);
                bind(ElementServices.class).to(ElementServicesImpl.class);
                bind(ComputerServices.class).to(ComputerServicesImpl.class);
                bind(LabServices.class).to(LabServicesImpl.class);
                bind(NoveltyServices.class).to(NoveltyServicesImpl.class);

                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(RoleDAO.class).to(MyBatisRoleDAO.class);
                // bind(AuthDAO.class).to(AuthDAOImpl.class);
                bind(ElementTypeDAO.class).to(MyBatisElementTypeDAO.class);
                bind(ElementDAO.class).to(MyBatisElementDAO.class);
                // bind(ElementHistoryDAO.class).to(MyBatisElementHistoryDAO.class);
                bind(ComputerDAO.class).to(MyBatisComputerDAO.class);
                // bind(ComputerHistoryDAO.class).to(MyBatisComputerHistoryDAO.class);
                bind(LabDAO.class).to(MyBatisLabDAO.class);
                bind(NoveltyDAO.class).to(MyBatisNoveltyDAO.class);
            }
        };
    }

    public XMLMyBatisModule getMyBatisDevModule() {
        if (myBatisModule == null) {
            myBatisModule = myBatisModule(
                    "development", "development/mybatis-config.xml");
        }
        return myBatisModule;
    }

    public XMLMyBatisModule getMyBatisTestModule() {
        LOGGER.info("getMyBatisTestModule");
        if (myBatisModule == null) {
            LOGGER.info("getMyBatisTestModule - if myBatisModule == null");
            myBatisModule = myBatisModule(
                    "test", "mybatis-config-h2.xml");
        }
        return myBatisModule;
    }

    public static MyBatisModuleFactory getInstance() {
        LOGGER.info("getInstance");
        return instance;
    }
}
