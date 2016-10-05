/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudcompany;

import crudpojo.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CompanyDao 
{

    public void addCompany(Companys company)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();

    try
    {
    trans=session.beginTransaction();
    session.save(company);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
        
    public void deleteCompany(int companyid)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Companys company=(Companys)session.load(Companys.class, new Integer(companyid));
    session.delete(company);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
    public List<Companys> getbycompanyid(int cno)
    {
    Companys company=new Companys();
    List<Companys> company1=new ArrayList();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from crudcompany.Companys where companyid= :companyid");
    query.setInteger("companyid", cno);
    company=(Companys)query.uniqueResult();
    company1=query.list();
    
    trans.commit();
    }
    catch(Exception e)
    {

    }
    return company1;
    }
    
    public List<Companys> retrieveCompany()
    {
    List company=new ArrayList<>();
    Companys company1=new Companys();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from Companys");
    company=query.list();
    //company.add(company1.getCompanyid());
    company.add(company1.getCompanyname());
    company.add(company1.getPost());
    company.add(company1.getCompanyaddress());
    company.add(company1.getStream());
    company.add(company1.getSkill());
    company.add(company1.getOpeningdate());
    company.add(company1.getClosingdate());
    
    trans.commit();
    }
    catch(Exception e)
    {
    }
    return company;
    }
    
    public void updateCompany(Companys company)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    session.update(company);
    trans.commit();
    }
    catch(Exception e)
    {
    }
    }
    
    
}
