/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchByCity;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utility.HibernateUtil;

public class CityDAO 
{
    
    public List<City> search(String keyword)
    {
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        List<City> lst=new ArrayList<>();
        try
        {
            s.beginTransaction();
            Query q=s.createQuery("select p from SearchByCity.City p where p.city like:keyword");
            
            q.setParameter("keyword", "%"+keyword+"%");
            lst=q.list();
            s.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            s.getTransaction().rollback();
        }
        return lst;
    }
    
}
