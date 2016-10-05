package crudwhatwhere;
// Generated Sep 13, 2016 1:03:31 PM by Hibernate Tools 4.3.1


import java.util.*;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Whatwheres  implements java.io.Serializable {


     private String companyname;
     private String post;
     private String city;
     private String stream;
     private String skill;
     private Date openingdate;
     private Date closingdate;

    public Whatwheres() {
    }

	
    public Whatwheres(String companyname) {
        this.companyname = companyname;
    }
    public Whatwheres(String companyname, String post, String city, String stream, String skill, Date openingdate, Date closingdate) {
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
        WhatwhereDao wdao = new WhatwhereDao();
        wdao.addWhatwhere(this);
    }
    
    public void delete()
    {
        WhatwhereDao wdao=new WhatwhereDao();
        wdao.deleteWhatwhere(companyname);
    }
    public List<Whatwheres> getbycompanyname()
    {
        WhatwhereDao wdao=new WhatwhereDao();
        List<Whatwheres> wt=wdao.getbycompanyname(companyname);
        
        companyname=wt.get(0).companyname;
        post=wt.get(0).post;
        city=wt.get(0).city;
        stream=wt.get(0).stream;
        skill=wt.get(0).skill;
        openingdate=wt.get(0).openingdate;
        closingdate=wt.get(0).closingdate;
        
        return wt;
    
    }
    
    public List<Whatwheres> getallrecords(){
        WhatwhereDao wdao=new WhatwhereDao();
        List<Whatwheres>wt1=wdao.retrieveWhatwhere();
        return wt1;
    }
    
    public void update()
    {
        WhatwhereDao wdao=new WhatwhereDao();
        wdao.updateWhatwhere(this);
    }

}


