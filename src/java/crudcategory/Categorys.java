package crudcategory;
// Generated Sep 13, 2016 1:03:31 PM by Hibernate Tools 4.3.1


import java.util.*;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Categorys  implements java.io.Serializable {


     private int companyid;
     private String companyname;
     private String post;
     private String city;
     private String category;
     private Date openingdate;
     private Date closingdate;

    public Categorys() {
    }

	
    public Categorys(int companyid) {
        this.companyid = companyid;
    }
    public Categorys(int companyid, String companyname, String post, String city, String category, Date openingdate, Date closingdate) {
       this.companyid = companyid;
       this.companyname = companyname;
       this.post = post;
       this.city = city;
       this.category = category;
       this.openingdate = openingdate;
       this.closingdate = closingdate;
    }
   
    public int getCompanyid() {
        return this.companyid;
    }
    
    public void setCompanyid(int companyid) {
        this.companyid = companyid;
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
    public String getCategory() {
        return this.category;
    }
    
    public void setCategory(String category) {
        this.category = category;
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
        CategoryDao cdao = new CategoryDao();
        cdao.addCategory(this);
    }
    
    public void delete()
    {
        CategoryDao cdao=new CategoryDao();
        cdao.deleteCategory(companyid);
    }
    public List<Categorys> getbycompanyid()
    {
        CategoryDao cdao=new CategoryDao();
        
        List<Categorys> ct=cdao.getbycompanyid(companyid);
        companyid=ct.get(0).companyid;
        companyname=ct.get(0).companyname;
        post=ct.get(0).post;
        city=ct.get(0).city;
        category=ct.get(0).category;
        openingdate=ct.get(0).openingdate;
        closingdate=ct.get(0).closingdate;
        
        return ct;
    
    }
    
    public List<Categorys> getallrecords(){
        CategoryDao cdao=new CategoryDao();
        List<Categorys>ct1=cdao.retrieveCategory();
        return ct1;
    }
    
    public void update()
    {
        CategoryDao cdao=new CategoryDao();
        cdao.updateCategory(this);
    }

}


