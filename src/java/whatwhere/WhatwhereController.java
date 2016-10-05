/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatwhere;

import java.util.*;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="wcont")
public class WhatwhereController 
{
    
    private List<Whatwhere> lst=new ArrayList<Whatwhere>();

    public List<Whatwhere> getLst() {
        return lst;
    }

    public void setLst(List<Whatwhere> lst) {
        this.lst = lst;
    }
    
    private String keyword;
    private String keyword1;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(String keyword1) {
        this.keyword1 = keyword1;
    }
    
    
    
    public String search()
    {
        WhatwhereDAO dao=new WhatwhereDAO();
        this.lst=dao.search(keyword, keyword1);
        return "ShowWhatwhere";
    }
       
}