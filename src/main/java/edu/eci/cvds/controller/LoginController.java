package edu.eci.cvds.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name = "loginController", eager = true)
@RequestScoped
public class LoginController {

    private String username;
    private String password;
    private boolean rememberMe;
    private String message;

    private static final transient Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    public void doLogin() {
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(rememberMe);
            try {
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                LOGGER.info("There is no user with username of " + token.getPrincipal());
                message = "There is no user with username of " + token.getPrincipal();
            } catch (IncorrectCredentialsException ice) {
                LOGGER.info("Password for account " + token.getPrincipal() + " was incorrect!");
                message = "Password for account " + token.getPrincipal() + " was incorrect!";
            } catch (LockedAccountException lae) {
                LOGGER.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
                message = "The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.";
            } catch (AuthenticationException ae) {
                message = "Pair username/password was incorrect!.";
                ae.printStackTrace();
            }
        }
    }

    public void redirectToAccount() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("account");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
