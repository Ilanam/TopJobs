/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.ValidationException;

@ManagedBean
public class AdminBean 
{
    
    private String ID;
    private String PASS;
    
    public AdminBean() {
    }

    public String Action() throws ValidationException
    {
        FacesContext c=FacesContext.getCurrentInstance();
        
        if(ID.equals("admin")&&PASS.equals("admin@123"))
        {
          return "AdminSuccess";
        }else{
            
            c.addMessage("AdminLogin", new FacesMessage("Username or Password is Incorrect"));
            return null;
        }
    }
    
    //Logout method for admin...
    public String logout()
    {
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "AdminLogin";
    }
    
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPASS() {
        return PASS;
    }

    public void setPASS(String PASS) {
        this.PASS = PASS;
    }
    
    
}
