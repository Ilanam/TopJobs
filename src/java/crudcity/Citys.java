package crudcity;
// Generated Sep 13, 2016 1:03:31 PM by Hibernate Tools 4.3.1


import java.util.*;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Citys  implements java.io.Serializable {


     private String companyname;
     private String post;
     private String city;
     private String stream;
     private String skill;
     private Date openingdate;
     private Date closingdate;

    public Citys() {
    }

	
    public Citys(String companyname) {
        this.companyname = companyname;
    }
    public Citys(String companyname, String post, String city, String stream, String skill, Date openingdate, Date closingdate) {
       this.companyname = companyname;
       this.post = post;
       this.city = city;
       this.stream = stream;
       this.skill = skill;
       this.openingdate = openingdate;
       this.closingdate = closingdate;
    }
   
    public String getCompanyname() {
        return this.companyname;
    }
    
    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
    public String getPost() {
        return this.post;
    }
    
    public void setPost(String post) {
        this.post = post;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getStream() {
        return this.stream;
    }
    
    public void setStream(String stream) {
        this.stream = stream;
    }
    public String getSkill() {
        return this.skill;
    }
    
    public void setSkill(String skill) {
        this.skill = skill;
    }
    public Date getOpeningdate() {
        return this.openingdate;
    }
    
    public void setOpeningdate(Date openingdate) {
        this.openingdate = openingdate;
    }
    public Date getClosingdate() {
        return this.closingdate;
    }
    
    public void setClosingdate(Date closingdate) {
        this.closingdate = closingdate;
    }

    public void save()
    {
        CityDao cdao = new CityDao();
        cdao.addCity(this);
    }
    
    public void delete()
    {
        CityDao cdao=new CityDao();
        cdao.deleteCity(companyname);
    }
    public List<Citys> getbyname()
    {
        CityDao cdao=new CityDao();
        List<Citys> ct=cdao.getbycompanyname(companyname);
        
        companyname=ct.get(0).companyname;
        post=ct.get(0).post;
        city=ct.get(0).city;
        stream=ct.get(0).stream;
        skill=ct.get(0).skill;
        openingdate=ct.get(0).openingdate;
        closingdate=ct.get(0).closingdate;
        return ct;
    
    }
    
    public List<Citys> getallrecords(){
        CityDao cdao=new CityDao();
        List<Citys>ct1=cdao.retrieveCity();
        return ct1;
    }
    
    public void update()
    {
        CityDao cdao=new CityDao();
        cdao.updateCity(this);
    }



}


