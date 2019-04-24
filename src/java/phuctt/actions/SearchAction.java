/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.actions;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import phuctt.daos.EmployeeDAO;
import phuctt.dtos.EmployeeDTO;

/**
 *
 * @author Thien Phuc
 */
public class SearchAction extends ActionSupport {
    
    private String searchValue;
    private List<EmployeeDTO> list;
    private final String SUCCESS = "success";
    
    public SearchAction() {
    }
    
    public String execute() throws Exception {
        if (!searchValue.isEmpty()) {
            EmployeeDAO dao = new EmployeeDAO();
            dao.search(searchValue);
            list = dao.getList();
            
            HttpServletRequest request = ServletActionContext.getRequest();
            EmployeeDTO dto = (EmployeeDTO) request.getAttribute("ERROR");
            
            if (dto != null) {
                int index = list.indexOf(dto);
                list.set(index, dto);
            }
        }
        return SUCCESS;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<EmployeeDTO> getList() {
        return list;
    }

    public void setList(List<EmployeeDTO> list) {
        this.list = list;
    }
    
    
}
