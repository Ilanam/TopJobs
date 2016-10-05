/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchBySkill;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="scont")
public class SkillController 
{
    
    private List<Skill> lst=new ArrayList<Skill>();

    public List<Skill> getLst() {
        return lst;
    }

    public void setLst(List<Skill> lst) {
        this.lst = lst;
    }
    
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public String search()
    {
        SkillDAO dao=new SkillDAO();
        this.lst=dao.search(keyword);
        return "Showskill";
    }
    
}
