/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchByCategory;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utility.HibernateUtil;

public class CategoryDAO 
{
    
    public List<Category> search(String keyword)
    {
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        List<Category> lst=new ArrayList<>();
        try
        {
            s.beginTransaction();
            Query q=s.createQuery("select p from SearchByCategory.Category p where p.category like:keyword");
            
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