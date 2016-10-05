/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.RegisterUser;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author TAMANNA
 */
public class RegisterHelper implements RegisterDAO{
    
    public SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public RegisterHelper()
    {
        Configuration configuration=new Configuration().configure();
    }
    
    @Override
    public void addRegisterUser(RegisterUser registerUser)
    {
        Session session=sessionFactory.openSession();
        Transaction tx=null; 
        try
        {
            tx=session.beginTransaction();
            Serializable objId=session.save(registerUser);
            tx.commit();
            System.out.println("Register success ! Id: "+objId);
        }
        catch(HibernateException ex)
        {
            if(tx!=null)
                tx.rollback();
            ex.printStackTrace();
        }finally
        {
            if(session!=null)
            {
                session.close();
            }
        }   
    }    
}
