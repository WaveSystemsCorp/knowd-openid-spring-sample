<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>

    <link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.0/themes/base/jquery-ui.css" rel="stylesheet" />
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
    <link href="<c:url value="/css/style.css" />" rel="stylesheet">

</head>
<body>
<div class="container">

    <div class="form-signin">

        <form action="<c:url value="/j_spring_openid_security_check" />" method="post" >
            <input type="text" name="openid_identifier" id="openid_identifier" class="input-block-level" placeholder="OpenID Login / OpenID Identifier"
                   value="">
            <button class="btn btn-large">Sign with OpenID</button>
            <img src="<c:url value="/images/logo_openid.png" />" style="height: 40px" alt="openid logo" />
        </form>
        <br/><strong>OpenID Identifiers</strong>
        <br/>
        <table>
            <tr>
                <td>DeviceID</td>
                <td><span class="label label-info openIdIdentifier">http://staging.machineid.com/device/id</span></td>
            </tr>
            <tr>
                <td>Google</td>
                <td><span class="label label-info openIdIdentifier">https://www.google.com/accounts/o8/id</span></td>
            </tr>
        </table>

    </div>

    <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
        <div class="form-signin text-error">
            Your login attempt was not successful, try again.<br/><br/>
            Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.<br/><br/>
            <span class="text-warning">Exception: ${SPRING_SECURITY_LAST_EXCEPTION}</span>
        </div>
    </c:if>

    <script type="text/javascript">
        $(document).ready(function(){
            $(".openIdIdentifier").unbind("click").bind("click", function(el){
                var url = $(el.currentTarget).text();
                $("#openid_identifier").val(url);
            });
        });
    </script>

</div> <!-- /container -->
</body>
</html>