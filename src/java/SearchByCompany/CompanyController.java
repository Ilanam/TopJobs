/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchByCompany;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="ccont")
public class CompanyController 
{
    
    private List<Company> lst=new ArrayList<Company>();

    public List<Company> getLst() {
        return lst;
    }

    public void setLst(List<Company> lst) {
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
        CompanyDAO dao=new CompanyDAO();
        this.lst=dao.search(keyword);
        return "ShowCompany";
    }
}
