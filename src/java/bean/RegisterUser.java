/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import helper.RegisterHelper;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.PrePersist;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ManagedBean

public class RegisterUser  implements Serializable
{

    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String emailID;
    private Date   dateofBirth;
    private String userID;
    private String password;
    private String cPassword;
    private String contactNumber;
    private String finalPassword;
    private String qualification;
    private String experience;
    private String curindustry;
    
    public RegisterUser()
    {
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String FirstName) {
        this.firstName = FirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String EmailID) {
        this.emailID = EmailID;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date DateofBirth) {
        this.dateofBirth = DateofBirth;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String UserID) {
        this.userID = UserID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String ContactNumber) {
        this.contactNumber = ContactNumber;
    }
    
    public void validateEmail(FacesContext fc, UIComponent c, Object value)throws ValidatorException
    {
        String email= (String)value;

        Pattern mask = null;
        mask = Pattern.compile(".+@.+\\.[a-z]+");
       Matcher matcher = mask.matcher(email);
        if (!matcher.matches())
         {
           FacesMessage message = new FacesMessage();
           message.setDetail("You must enter an e-mail address in the format, abc@domain.com");
           message.setSummary("You must enter an e-mail address in the format, abc@domain.com");
           throw new ValidatorException(message);
        }
    }
  
    public void validateFinalPassword(FacesContext fc, UIComponent c, Object value)throws ValidatorException
    {
        finalPassword= (String)value;
    }
      public void validateCPassword(FacesContext fc, UIComponent c, Object value)throws ValidatorException
    {
        String cPassword= (String)value;

        RegisterUser rf=new RegisterUser();
        System.out.println(getFinalPassword());
        if (cPassword.compareTo(getFinalPassword())!=0 )
        {
           FacesMessage message = new FacesMessage();
           message.setSummary("Password does not match");
           throw new ValidatorException(message);
        }
    }
      public void validatefname(FacesContext fc, UIComponent c, Object value)
      {
          if(((String)value).contains("~")||((String)value).contains("!")||
          ((String)value).contains("@")||((String)value).contains("#")||
          ((String)value).contains("$")||((String)value).contains("%")||
          ((String)value).contains("^")||((String)value).contains("&")||
          ((String)value).contains("*")||((String)value).contains("(")||
          ((String)value).contains(")")||((String)value).contains("_")||
          ((String)value).contains("-")||((String)value).contains("=")||
          ((String)value).contains("+")) throw new 
           ValidatorException(new  FacesMessage("First Name cannot contain special characters"));
          
      }
      
      public void validatelname(FacesContext fc, UIComponent c, Object value)
      {
          if(((String)value).contains("~")||((String)value).contains("!")||
          ((String)value).contains("@")||((String)value).contains("#")||
          ((String)value).contains("$")||((String)value).contains("%")||
          ((String)value).contains("^")||((String)value).contains("&")||
          ((String)value).contains("*")||((String)value).contains("(")||
          ((String)value).contains(")")||((String)value).contains("_")||
          ((String)value).contains("-")||((String)value).contains("=")||
          ((String)value).contains("+")) throw new 
           ValidatorException(new  FacesMessage("Last Name cannot contain special characters"));
          
      }
   
    public String getFinalPassword() {
        return finalPassword;
    }

    public void setFinalPassword(String FinalPassword) {
        this.finalPassword = FinalPassword;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String Qualification) {
        this.qualification = Qualification;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String Experience) {
        this.experience = Experience;
    }

    public String getCurindustry() {
        return curindustry;
    }

    public void setCurindustry(String Curindustry) {
        this.curindustry = Curindustry;
    }
    
       public String adddata()
    {
          ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Config.xml");
          
            RegisterUser ru=(RegisterUser)context.getBean("register");
            
            ru.setFirstName(this.firstName);
            ru.setLastName(this.lastName);
            ru.setGender(this.gender);
            ru.setAddress(this.address);
            ru.setDateofBirth(this.getDateofBirth());
            ru.setEmailID(this.emailID);
            ru.setContactNumber(this.contactNumber);
            ru.setQualification(this.qualification);
            ru.setExperience(this.experience);
            ru.setCurindustry(this.curindustry);
            ru.setUserID(this.userID);
            ru.setPassword(this.password);
            ru.setcPassword(this.cPassword);
            
            RegisterHelper helper=(RegisterHelper)context.getBean("registerHelper");
            helper.addRegisterUser(ru);
            return "Welcome.xhtml";       
    }  
}
