/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchByCategory;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="ccate")
public class CategoryController 
{
    
        private List<Category> lst=new ArrayList<Category>();

    public List<Category> getLst() {
        return lst;
    }

    public void setLst(List<Category> lst) {
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
        CategoryDAO dao=new CategoryDAO();
        this.lst=dao.search(keyword);
        return "ShowCategory";
    }

    
}
