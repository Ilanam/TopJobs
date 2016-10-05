/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.RegisterUser;
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import validation.Login;

 public class LoginHelper implements LoginDAO
{
    private SessionFactory sessionFactory;
    private RegisterUser rs;

    public SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) 
    {
        this.sessionFactory = sessionFactory;
    }

     public LoginHelper()
    {
       Configuration configuration=new Configuration().configure();
    }
    
    
     public RegisterUser loginCheck(String userID, String password)
    {
        Session session=sessionFactory.openSession();
       String str=null;
       
       try
       {
       Transaction tx=session.beginTransaction();
       String strQuery="From bean.RegisterUser where userID=:userID AND password=:password";
       Query query=session.createQuery(strQuery);
       query.setString("userID", userID);
       query.setString("password", password);
       List<RegisterUser> customerList=query.list();
       Iterator itr=customerList.iterator();
       tx.commit();
       while(itr.hasNext())
       {
       rs=(RegisterUser)itr.next();
       }
       }
       catch(HibernateException ex)
       {
       ex.printStackTrace();
       }
       finally
       {
       if(session!=null)
       {
       session.close();
       }
       }
       return rs;
    }
      
    }
    

