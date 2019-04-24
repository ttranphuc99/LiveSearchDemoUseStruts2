<%-- 
    Document   : create
    Created on : Apr 16, 2019, 1:04:33 PM
    Author     : Thien Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <body>
        <s:if test="%{exception.message.indexOf('duplicate') > -1}">
            <font style="color:red;">Emp_id is existed</font>
        </s:if>
        <s:textfield id="emp_id" label="Emp_Id" name="empId" theme="css_xhtml"
                     cssStyle="margin-bottom: 5px;" cssClass="txtText" labelposition=""/>
        <s:textfield id="fname" label="First Name" name="fname" theme="css_xhtml"
                     cssStyle="margin-bottom: 5px;" cssClass="txtText" labelposition=""/>
        <s:textfield id="lname" label="Last Name" name="lname" theme="css_xhtml"
                     cssStyle="margin-bottom: 5px;" cssClass="txtText" labelposition=""/>
        <s:textfield id="job_id" label="Job_Id" name="jobId" theme="css_xhtml"
                     style="margin-bottom: 5px;" cssClass="txtText" labelposition=""/>
        <s:textfield id="job_lvl" label="Job_Lvl" name="jobLvl" theme="css_xhtml"
                     style="margin-bottom: 5px;" cssClass="txtText" labelposition=""/>
        <s:if test="%{#request.NOTIFY != null}">
            <s:property value="%{#request.NOTIFY}"/> <br/>
        </s:if>
        <input type="button" value="Insert" onclick="ajaxInsert()"/>
    </body>
</html>
