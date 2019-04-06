<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <spring:url value="/styles/superhero.bootstrap.min.css" var="superhero_css"/>
    <spring:url value="/styles/cosmo.bootstrap.min.css" var="cosmo_css"/>

    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" media="screen" href="${cosmo_css}"/>
    <title>Movie Database</title>
</head>


<body>
<div class="jumbotron">
    <h3 class="h3">Actors</h3>
</div>
<c:if test="${not empty actors}">
<section class="container col-md-6 col-md-offset-3">
    <table class="table table-striped table-hover">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Last Modified</th>
            <th>#</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${actors}" var="actor">
            <tr>
                <td>${actor.firstName}</td>
                <td>${actor.lastName}</td>
                <td><joda:format value="${actor.lastUpdate}" pattern="dd-MM-yyyy"/></td>
                <td>
                    <a href="<spring:url value="/web/actors/actor/${actor.id}"/>" class="btn btn-default btn-sm">
                        Info
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    </c:if>
</section>
</body>
