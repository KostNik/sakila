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

<div class="panel panel-default">
    <div class="panel-heading">Actor info</div>
    <div class="panel-body">
        <div class="col-md-5">
            <h3><strong><span class="label label-warning">ID: ${actor.id}</span></strong></h3>
            <p>
                First Name :${actor.firstName}
            </p>
            <p>
                Last Name :${actor.lastName}
            </p>
            <p>
                Last Update :${actor.lastUpdate}
            </p>
        </div>
    </div>
</div>

