/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchByCompany;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utility.HibernateUtil;

public class CompanyDAO 
{
    
    public List<Company> search(String keyword)
    {
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        List<Company> lst=new ArrayList<>();
        try
        {
            s.beginTransaction();
            Query q=s.createQuery("select p from SearchByCompany.Company p where p.companyname like:keyword");
            
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
