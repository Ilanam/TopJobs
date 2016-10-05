/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudwhatwhere;

import crudpojo.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class WhatwhereDao {
    
    public void addWhatwhere(Whatwheres whatwhere)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();

    try
    {
    trans=session.beginTransaction();
    session.save(whatwhere);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
        
    public void deleteWhatwhere(String companyname)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Whatwheres whatwhere=(Whatwheres)session.load(Whatwheres.class, new String(companyname));
    session.delete(whatwhere);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
    public List<Whatwheres> getbycompanyname(String cmp)
    {
    Whatwheres whatwhere=new Whatwheres();
    List<Whatwheres> whatwhere1=new ArrayList();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from crudwhatwhere.Whatwheres where companyname= :companyname");
    query.setString("companyname", cmp);
    whatwhere=(Whatwheres)query.uniqueResult();
    whatwhere1=query.list();
    trans.commit();
    }
    catch(Exception e)
    {

    }
    return whatwhere1;
    }
    public List<Whatwheres> retrieveWhatwhere()
    {
    List whatwhere=new ArrayList();
    Whatwheres whatwhere1=new Whatwheres();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from Whatwheres");
    whatwhere=query.list();
    whatwhere.add(whatwhere1.getCompanyname());
    whatwhere.add(whatwhere1.getPost());
    whatwhere.add(whatwhere1.getCity());
    whatwhere.add(whatwhere1.getStream());
    whatwhere.add(whatwhere1.getSkill());
    whatwhere.add(whatwhere1.getOpeningdate());
    whatwhere.add(whatwhere1.getClosingdate());
    trans.commit();
    }
    catch(Exception e)
    {
    }
    return whatwhere;
    }
    public void updateWhatwhere(Whatwheres whatwhere)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    session.update(whatwhere);
    trans.commit();
    }
    catch(Exception e)
    {
    }
    }

    
}
