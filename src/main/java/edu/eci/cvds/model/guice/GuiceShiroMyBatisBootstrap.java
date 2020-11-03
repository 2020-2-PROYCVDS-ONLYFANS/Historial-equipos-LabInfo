package edu.eci.cvds.model.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import edu.eci.cvds.model.guice.mybatis.MyBatisModuleFactory;
import edu.eci.cvds.model.guice.shiro.ShiroWebModuleImpl;
import org.apache.shiro.guice.web.ShiroWebModule;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class GuiceShiroMyBatisBootstrap extends GuiceServletContextListener {

    private ServletContext servletContext; // to shiro

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.servletContext = servletContextEvent.getServletContext(); // to shiro
        super.contextInitialized(servletContextEvent);
    }

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(
                new ShiroWebModuleImpl(servletContext),
                ShiroWebModule.guiceFilterModule(),
                MyBatisModuleFactory.getInstance().getMyBatisModuleLocal()
        );
    }
}
