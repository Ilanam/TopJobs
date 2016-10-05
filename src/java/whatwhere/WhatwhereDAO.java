/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatwhere;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utility.HibernateUtil;

public class WhatwhereDAO 
{
    
    public List<Whatwhere> search(String keyword, String keyword1)
    {
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        List<Whatwhere> lst=new ArrayList<>();
        try
        {
            s.beginTransaction();
            Query q=s.createQuery("select p from whatwhere.Whatwhere p where p.skill like:keyword and p.city like:keyword1");
            q.setParameter("keyword", "%"+keyword+"%");
            q.setParameter("keyword1", "%"+keyword1+"%");
            
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
