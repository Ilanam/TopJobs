/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudskill;

import crudpojo.NewHibernateUtil;
import java.util.*;
import org.hibernate.*;

public class SkillDao {
    
    public void addSkill(Skills skill)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();

    try
    {
    trans=session.beginTransaction();
    session.save(skill);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
    public void deleteSkill(String companyname)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Skills skill=(Skills)session.load(Skills.class, new String(companyname));
    session.delete(skill);
    trans.commit();
    }
    catch (Exception e)
    {
    e.printStackTrace();
    }
    }
    public List<Skills> getbycompanyname(String cmp)
    {
    Skills skill=new Skills();
    List<Skills> skill1=new ArrayList();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from crudskill.Skills where companyname= :companyname");
    query.setString("companyname", cmp);
    skill=(Skills)query.uniqueResult();
    skill1=query.list();
    trans.commit();
    }
    catch(Exception e)
    {

    }
    return skill1;
    }
    public List<Skills> retrieveSkill()
    {
    List skill=new ArrayList();
    Skills skill1=new Skills();
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    Query query=session.createQuery("from Skills");
    skill=query.list();
    skill.add(skill1.getCompanyname());
    skill.add(skill1.getPost());
    skill.add(skill1.getCity());
    skill.add(skill1.getStream());
    skill.add(skill1.getSkill());
    skill.add(skill1.getOpeningdate());
    skill.add(skill1.getClosingdate());
    trans.commit();
    }
    catch(Exception e)
    {
    }
    return skill;
    }
    public void updateSkill(Skills skill)
    {
    Transaction trans=null;
    Session session=NewHibernateUtil.getSessionFactory().openSession();
    try
    {
    trans=session.beginTransaction();
    session.update(skill);
    trans.commit();
    }
    catch(Exception e)
    {
    }
    }

    
}
