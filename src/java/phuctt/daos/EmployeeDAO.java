/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import phuctt.dbutils.DBUtils;
import phuctt.dtos.EmployeeDTO;

/**
 *
 * @author Thien Phuc
 */
public class EmployeeDAO implements Serializable {
    private List<EmployeeDTO> list;

    public List<EmployeeDTO> getList() {
        return list;
    }

    public void setList(List<EmployeeDTO> list) {
        this.list = list;
    }
   
    public boolean insert(String empId, String fname, String lname, String jobId, String jobLvl) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stat = null;
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO employee(emp_id, fname, lname, job_id, job_lvl) "
                        + "VALUES(?,?,?,?,?)";
                stat = conn.prepareStatement(sql);
                stat.setString(1, empId);
                stat.setString(2, fname);
                stat.setString(3, lname);
                stat.setInt(4, Integer.parseInt(jobId));
                stat.setInt(5, Integer.parseInt(jobLvl));
                
                return stat.executeUpdate() > 0;
            }
        } finally {
            if (stat != null) stat.close();
            if (conn != null) conn.close();
        }
        return false;
    }
    
    public void search(String searchValue) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "Select emp_id, fname, lname From employee WHERE fname like ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, "%" +searchValue+ "%");
                rs = stmt.executeQuery();
                
                while (rs.next()) {
                    String id = rs.getString("emp_id");
                    String lname = rs.getString("lname");
                    String fname = rs.getString("fname");
                    
                    EmployeeDTO dto = new EmployeeDTO(id, fname, lname);
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(dto);
                }
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
    
    public boolean delete(String id) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        
        try {
            con = DBUtils.getConnection();
            
            if (con != null) {
                String sql = "DELETE FROM employee WHERE emp_id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, id);
                return stmt.executeUpdate() > 0;
            }
        } finally {
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        }
        return false;
    }
    
    public boolean update(String id, String fname, String lname) throws Exception {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
             conn = DBUtils.getConnection();
             String sql = "UPDATE employee SET fname = ?, lname = ? WHERE emp_id = ?";
             ps = conn.prepareStatement(sql);
             ps.setString(1, fname);
             ps.setString(2, lname);
             ps.setString(3, id);
             check = ps.executeUpdate() > 0;
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return check;
    }
}
