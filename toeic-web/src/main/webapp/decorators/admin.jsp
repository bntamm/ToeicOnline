
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<html>
<head>
    <title><dec:title default="Admin Page"/> </title>
    <dec:head/>
</head>
    <body>
            //import header
            <%@include file="/common/admin/header.jsp"%>
            //import menu
            <%@include file="/common/admin/menu.jsp"%>
            //import body
            <dec:body/>
            //import footer
            <%@include file="/common/admin/footer.jsp"%>
    </body>
</html>
