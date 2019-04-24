/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.actions;

import phuctt.daos.EmployeeDAO;

/**
 *
 * @author Thien Phuc
 */
public class DeleteAction {
    private String id, searchValue;
    private final String SUCCESS = "success";
    public DeleteAction() {
    }
    
    public String execute() throws Exception {
        EmployeeDAO dao = new EmployeeDAO();
        dao.delete(id);
        return SUCCESS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
}
