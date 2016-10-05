package crudcompany;
// Generated Sep 13, 2016 1:03:31 PM by Hibernate Tools 4.3.1


import java.util.*;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Companys  implements java.io.Serializable {


     private int companyid;
     private String companyname;
     private String post;
     private String companyaddress;
     private String stream;
     private String skill;
     private Date openingdate;
     private Date closingdate;

    public Companys() {
    }

	
    public Companys(int companyid) {
        this.companyid = companyid;
    }
    public Companys(int companyid, String companyname, String post, String companyaddress, String stream, String skill, Date openingdate, Date closingdate) {
       this.companyid = companyid;
       this.companyname = companyname;
       this.post = post;
       this.companyaddress = companyaddress;
       this.stream = stream;
       this.skill = skill;
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
    public String getCompanyaddress() {
        return this.companyaddress;
    }
    
    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
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
        CompanyDao cdao = new CompanyDao();
        cdao.addCompany(this);
    }
    
    public void delete()
    {
        CompanyDao cdao=new CompanyDao();
        cdao.deleteCompany(companyid);
    }
    public List<Companys> getbycompanyid()
    {
        CompanyDao cdao=new CompanyDao();
        
        List<Companys> ct=cdao.getbycompanyid(companyid);
        companyid=ct.get(0).companyid;
        companyname=ct.get(0).companyname;
        post=ct.get(0).post;
        companyaddress=ct.get(0).companyaddress;
        stream=ct.get(0).stream;
        skill=ct.get(0).skill;
        openingdate=ct.get(0).openingdate;
        closingdate=ct.get(0).closingdate;
                
        return ct;
    
    }
    
    public List<Companys> getallrecords(){
        CompanyDao cdao=new CompanyDao();
        List<Companys>ct1=cdao.retrieveCompany();
        return ct1;
    }
    
    public void update()
    {
        CompanyDao cdao=new CompanyDao();
        cdao.updateCompany(this);
    }

}


