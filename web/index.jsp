<%-- 
    Document   : index
    Created on : Apr 16, 2019, 12:20:15 PM
    Author     : Thien Phuc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css.css" rel="stylesheet"/>
        <script type="text/javascript" src="script.js"></script>
        <title>JSP Page</title>
        <s:head/>
    </head>
    <body>
        <h1>Hello World!</h1>
        <input type="button" value="Search" onclick="showTable(this.value)"/>
        <input type="button" value="Insert" onclick="showTable(this.value)"/>
        <br/> <br/>
        <s:div id="containerSearch" cssStyle="display: none">
            <s:textfield id="searchValue" label="Search by name" value="%{searchValue}" onkeyup="ajaxSearch(this.value)"/>
            <s:div id="tableSearch">
                <s:include value="searchpage.jsp"/>
            </s:div>
        </s:div>
        
        <s:div id="tableInsert" cssStyle="display: none">
            
            <s:include value="create.jsp"/>
        </s:div>
    </body>
</html>
