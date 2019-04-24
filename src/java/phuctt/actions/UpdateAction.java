/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.actions;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import phuctt.daos.EmployeeDAO;
import phuctt.dtos.EmployeeDTO;

/**
 *
 * @author Thien Phuc
 */
public class UpdateAction extends ActionSupport {
    private String id, lname, fname, postfix, searchValue;
    
    private final String FAIL = "fail";
    
    public UpdateAction() {
    }
    
    public String execute() throws Exception {
        EmployeeDAO dao = new EmployeeDAO();
        boolean result = dao.update(id, fname, lname);
        
        if (result) {
            return SUCCESS;
        }
        return FAIL;
    }

    @Override
    public void validate() {
        boolean error = false;
        if (fname.trim().isEmpty()) {
            addFieldError("fname_" + postfix, "First name is required!");
            error = true;
        } else if (!fname.matches("[a-zA-Z ]+")) {
            addFieldError("fname_" + postfix, "First name is only character a-z A-Z");
            error = true;
        }
        
        if (lname.trim().isEmpty()) {
            addFieldError("lname_" + postfix, "Last name is required!");
            error = true;
        } else if (!lname.matches("[a-zA-Z ]+")) {
            addFieldError("lname_" + postfix, "Last name is only character a-z A-Z");
            error = true;
        }
        
        if (error) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("ERROR", new EmployeeDTO(id, fname, lname));
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    
}
