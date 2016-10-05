/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import bean.RegisterUser;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import helper.LoginHelper;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class LoginController
{
    
 public String validateLogin(Login login)
 {
    ApplicationContext apx=new ClassPathXmlApplicationContext("Spring-Config.xml");
    LoginHelper helper=(LoginHelper)apx.getBean("loginHelper");
    RegisterUser user=helper.loginCheck(login.getUserID(), login.getPassword());
    if(user!=null)
    {
    if(user.getUserID().equals(login.getUserID()) && user.getPassword().equals(login.getPassword()))
    {
       return "JobSeeker";
    }
     else
    {
       FacesContext faces=FacesContext.getCurrentInstance();
       faces.addMessage("ValidationLogin", new FacesMessage("Username or Password is Incorrect"));
       
       return null;
    }
    }else{
            FacesContext faces=FacesContext.getCurrentInstance();
            faces.addMessage("ValidationLogin", new FacesMessage("Username or Password is Incorrect"));
       
            return null;
            }
    }
    public String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "ValidationLogin";
    }
 
 }
