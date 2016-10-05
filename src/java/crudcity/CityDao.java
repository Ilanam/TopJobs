/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudcity;

import crudpojo.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CityDao {
    
    public void addCity(Citys city)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();

    try
    {
    trans=session.beginTransaction();
    session.save(city);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
        
    public void deleteCity(String companyname)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Citys city=(Citys)session.load(Citys.class, new String(companyname));
    session.delete(city);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
    public List<Citys> getbycompanyname(String cmp)
    {
    Citys city=new Citys();
    List<Citys> city1=new ArrayList();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from crudcity.Citys where companyname= :companyname");
    query.setString("companyname", cmp);
    city=(Citys)query.uniqueResult();
    city1=query.list();
    trans.commit();
    }
    catch(Exception e)
    {

    }
    return city1;
    }
    public List<Citys> retrieveCity()
    {
    List city=new ArrayList();
    Citys city1=new Citys();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from Citys");
    city=query.list();
    city.add(city1.getCompanyname());
    city.add(city1.getPost());
    city.add(city1.getCity());
    city.add(city1.getStream());
    city.add(city1.getSkill());
    city.add(city1.getOpeningdate());
    city.add(city1.getClosingdate());
    trans.commit();
    }
    catch(Exception e)
    {
    }
    return city;
    }
    public void updateCity(Citys city)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    session.update(city);
    trans.commit();
    }
    catch(Exception e)
    {
    }
    }

    
}
