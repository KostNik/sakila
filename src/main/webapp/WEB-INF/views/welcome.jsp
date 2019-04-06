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
    <div class="container">
        <h1>${welcomeMessage}</h1>
    </div>
</div>

<section class="container col-md-6 col-md-offset-3">
    <c:if test="${not empty urlModels}">
        <c:forEach items="${urlModels}" var="componentDevURLModel">
            <div class="panel panel-default">
                <div class="panel-heading">${componentDevURLModel.name}</div>
                <c:if test="${not empty componentDevURLModel.modelList}">
                    <div class="panel-body">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Type</th>
                                <th>URL suffix</th>
                                <th>Description</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${componentDevURLModel.modelList}" var="devURLModel">
                                <tr>
                                    <td>${devURLModel.type}</td>
                                    <td>${devURLModel.urlPath}</td>
                                    <td>${devURLModel.description}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </c:if>
</section>

</body>