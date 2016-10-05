package crudskill;
// Generated Sep 13, 2016 1:03:31 PM by Hibernate Tools 4.3.1


import java.util.*;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Skills  implements java.io.Serializable {


     private String companyname;
     private String post;
     private String city;
     private String stream;
     private String skill;
     private Date openingdate;
     private Date closingdate;

    public Skills() {
    }

	
    public Skills(String companyname) {
        this.companyname = companyname;
    }
    public Skills(String companyname, String post, String city, String stream, String skill, Date openingdate, Date closingdate) {
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
        SkillDao sdao = new SkillDao();
        sdao.addSkill(this);
    }
    
    public void delete()
    {
        SkillDao sdao=new SkillDao();
        sdao.deleteSkill(companyname);
    }
    public List<Skills> getbycompanyname()
    {
        SkillDao sdao=new SkillDao();
        List<Skills> st=sdao.getbycompanyname(companyname);
        
        companyname=st.get(0).companyname;
        post=st.get(0).post;
        city=st.get(0).city;
        stream=st.get(0).stream;
        skill=st.get(0).skill;
        openingdate=st.get(0).openingdate;
        closingdate=st.get(0).closingdate;
        return st;
    
    }
    
    public List<Skills> getallrecords(){
        SkillDao sdao=new SkillDao();
        List<Skills>st1=sdao.retrieveSkill();
        return st1;
    }
    
    public void update()
    {
        SkillDao sdao=new SkillDao();
        sdao.updateSkill(this);
    }

}


