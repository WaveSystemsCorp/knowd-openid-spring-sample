<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Secure content</title>

    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>

    <link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.0/themes/base/jquery-ui.css" rel="stylesheet" />
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <div class="form-signin text">
        <form action="<c:url value="/logout" />" class="pull-right">
            <input type="submit" value="Sign out" class="btn"/>
        </form>
        <h3>Login successful:</h3><br/>
        <br/>
        <li><strong>Username / OpenID Login:</strong>
            <ul>
                <li><sec:authentication property="principal.username" /></li>
            </ul>
        </li>
        <br/><li><strong>Enabled:</strong> <sec:authentication property="principal.enabled" /></li>
        <br/><li><strong>Authorities:</strong> <sec:authentication property="principal.authorities" /></li>
        <br/><li><strong>Last auth:</strong> ${pageContext['request'].userPrincipal.principal.lastUpdate.time}</li>
        <br/><li><strong>First auth:</strong> ${pageContext['request'].userPrincipal.principal.createTime.time}</li>
        <br/><li><strong>Trust score:</strong> ${trustScore}</li>
        <br/><li><strong>Needs setup:</strong> ${needsSetup}</li>
        <br/><li><strong>Setup URL:</strong> ${setupURL}</li>

    </div>

</div> <!-- /container -->
</body>
</html>