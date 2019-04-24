/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import phuctt.daos.EmployeeDAO;

/**
 *
 * @author Thien Phuc
 */
public class InsertAction extends ActionSupport {
    
    private String empId;
    private String fname;
    private String lname;
    private String jobId;
    private String jobLvl;
    
    public InsertAction() {
    }
    
    public String execute() throws Exception {
        EmployeeDAO dao = new EmployeeDAO();
        boolean result = dao.insert(empId, fname, lname, jobId, jobLvl);
        
        if (result) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("NOTIFY", "Insert successfully");
        } else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("NOTIFY", "Insert error");
        }
        
        return "success";
    }

    public String getEmpId() {
        return empId;
    }

    @RequiredStringValidator(trim = true, message = "Field is not empty")
    @RegexFieldValidator(regexExpression = "^[a-zA-Z]{3}\\d{5}$", message = "Not match format ABC00000")
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFname() {
        return fname;
    }

    @RequiredStringValidator(trim = true, message = "Field is not empty")
    @RegexFieldValidator(regexExpression = "^[a-zA-Z ]+$", message = "Not match format")
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    @RequiredStringValidator(trim = true, message = "Field is not empty")
    @RegexFieldValidator(regexExpression = "^[a-zA-Z ]+$", message = "Not match format")
    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getJobId() {
        return jobId;
    }

    @RequiredStringValidator(trim = true, message = "Field is not empty")
    @RegexFieldValidator(regexExpression = "^\\d+$", message = "Number only")
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobLvl() {
        return jobLvl;
    }

    @RequiredStringValidator(trim = true, message = "Field is not empty")
    @RegexFieldValidator(regexExpression = "^\\d+$", message = "Number only")
    public void setJobLvl(String jobLvl) {
        this.jobLvl = jobLvl;
    }
    
}
