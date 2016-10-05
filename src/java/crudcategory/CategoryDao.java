/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudcategory;

import crudpojo.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CategoryDao {
    
    public void addCategory(Categorys category)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();

    try
    {
    trans=session.beginTransaction();
    session.save(category);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
        
    public void deleteCategory(int companyid)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Categorys category=(Categorys)session.load(Categorys.class, new Integer(companyid));
    session.delete(category);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
    public List<Categorys> getbycompanyid(int cno)
    {
    Categorys category=new Categorys();
    List<Categorys> category1=new ArrayList();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from crudcategory.Categorys where companyid= :companyid");
    query.setInteger("companyid", cno);
    category=(Categorys)query.uniqueResult();
    category1=query.list();
    trans.commit();
    }
    catch(Exception e)
    {

    }
    return category1;
    }
    public List<Categorys> retrieveCategory()
    {
    List category=new ArrayList();
    Categorys category1=new Categorys();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from Categorys");
    category=query.list();
    //category.add(category1.getCompanyid());
    category.add(category1.getCompanyname());
    category.add(category1.getPost());
    category.add(category1.getCity());
    category.add(category1.getCategory());
    category.add(category1.getOpeningdate());
    category.add(category1.getClosingdate());
    
    trans.commit();
    }
    catch(Exception e)
    {
    }
    return category;
    }
    public void updateCategory(Categorys category)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    session.update(category);
    trans.commit();
    }
    catch(Exception e)
    {
    }
    }

    
}
