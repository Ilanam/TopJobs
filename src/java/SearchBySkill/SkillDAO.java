/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchBySkill;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utility.HibernateUtil;

public class SkillDAO 
{
    
    public List<Skill> search(String keyword)
    {
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        List<Skill> lst=new ArrayList<>();
        try
        {
            s.beginTransaction(); 
            Query q=s.createQuery("select p from SearchBySkill.Skill p where p.skill like:keyword");
            
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
