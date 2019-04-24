<%-- 
    Document   : searchpage
    Created on : Apr 17, 2019, 3:30:35 PM
    Author     : Thien Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <body>
        
        <br/><br/>
        <s:if test="%{searchValue != null and !searchValue.isEmpty()}">
            <s:if test="%{list != null}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th colspan="2">Action</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <s:iterator value="list" status="counter">
                            <tr>
                                <td>
                                    <s:property value="%{emp_id}"/>
                                    <s:hidden id="id_%{#counter.count}" value="%{emp_id}"/>
                                </td>
                                <td>
                                    <s:textfield name="fname_%{#counter.count}" id="fname_%{#counter.count}"
                                                 value="%{fname}" cssClass="fname" theme="css_xhtml"/>
                                </td>
                                <td>
                                    <s:textfield name="lname_%{#counter.count}" id="lname_%{#counter.count}"
                                                 value="%{lname}" cssClass="lname" theme="css_xhtml"/>
                                </td>
                                <td>
                                    <input type="button" value="Update" onclick="ajaxUpdate(${counter.count})"/>
                                </td>
                                <td>
                                    <input type="button" value="Delete" onclick="ajaxDelete(${counter.count})"/>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if> 
            <s:if test="%{list==null}">
                <h2>Not found record!!</h2>
            </s:if>
        </s:if>
    </body>
</html>
