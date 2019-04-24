/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.dtos;

import java.util.Objects;

/**
 *
 * @author Thien Phuc
 */
public class EmployeeDTO{
    private String emp_id, fname, lname;
    private int job_id, job_lvl;

    public EmployeeDTO(String emp_id, String fname, String lname) {
        this.emp_id = emp_id;
        this.fname = fname;
        this.lname = lname;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public int getJob_lvl() {
        return job_lvl;
    }

    public void setJob_lvl(int job_lvl) {
        this.job_lvl = job_lvl;
    }

    @Override
    public boolean equals(Object obj) {
        return ((EmployeeDTO) obj).emp_id.equals(this.emp_id); //To change body of generated methods, choose Tools | Templates.
    }
}
