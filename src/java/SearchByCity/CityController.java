/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SearchByCity;

import java.util.*;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="ccity")
public class CityController 
{
    
    private List<City> lst=new ArrayList<City>();

    public List<City> getLst() {
        return lst;
    }

    public void setLst(List<City> lst) {
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
        CityDAO dao=new CityDAO();
        this.lst=dao.search(keyword);
        return "ShowCity";
    }
    
}

