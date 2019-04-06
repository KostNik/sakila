<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <spring:url value="/styles/cosmo.bootstrap.min.css" var="cosmo_css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${cosmo_css}"/>

    <spring:url value="/scripts/jqgrid/css/ui.jqgrid.css" var="jqgrid_css"/>
    <spring:url value="/styles/custom-theme/jquery-ui-1.10.4.custom.css" var="jquery_ui_theme_css"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${jquery_ui_theme_css}"/>
    <link rel="stylesheet" type="text/css" media="screen" href="${jqgrid_css}"/>


    <spring:url value="/scripts/jqgrid/js/i18n/grid.locale-en.js" var="jqgrid_locale_url"/>
    <spring:url value="/scripts/jquery-ui-1.12.1/jquery-ui.js" var="jquery_ui"/>
    <spring:url value="/scripts/jqgrid/js/jquery.jqGrid.min.js" var="jqgrid_url"/>
    <spring:url value="/scripts/jqgrid/js/jquery-1.11.0.min.js" var="jquery_min_url"/>
    <spring:url value="/scripts/jquery-1.11.1.js" var="jquery_url"/>
    <spring:url value="/scripts/jquery-ui-1.10.4.custom.min.js" var="jquery_ui_min_url"/>

    <script type="text/javascript" src="${jquery_url}"></script>
    <script type="text/javascript" src="${jqgrid_locale_url}"></script>
    <script type="text/javascript" src="${jqgrid_url}"></script>

    <script type="text/javascript" src="${jquery_ui}"></script>
    <%--<script type="text/javascript" src="${jquery_min_url}"></script>--%>
    <%--<script type="text/javascript" src="${jquery_ui_min_url}"></script>--%>
</head>

<body>
<spring:url value="/rest/actors" var="actorsListURL"/>
<spring:url value="/web/actors/actor/" var="actorView"/>
<div class="jumbotron">
    <div class="container">
        <h2>Actors</h2>
    </div>
</div>
<script type="text/javascript">
    (function ($) {
        $(function () {
            $("#list").jqGrid({
                url: '${actorsListURL}/listgrid',
                datatype: 'json',
                mtype: 'GET',
                colNames: ['ID', 'First Name', 'Last Name', 'Last modification date'],
                colModel: [
                    {name: 'id', index: 'id', width: 50, align: 'center'},
                    {name: 'firstName', index: 'firstName', width: 150, align: 'center'},
                    {name: 'lastName', index: 'lastName', width: 150, align: 'center'},
                    {
                        name: 'lastUpdate', index: 'lastUpdate', width: 200, sorttype: 'date',
                        formatter: 'date', formatoptions: {newformat: 'd/m/Y'}, editable: true, datefmt: 'd-M-Y'
                        , align: 'center'
                    }
                ],
                jsonReader: {
                    root: "actorData",
                    page: "currentPage",
                    total: "totalPages",
                    records: "totalRecords",
                    id: "id",
                    repeatitems: true
                },
                pager: '#pager',
                rowNum: 20,
                rowList: [10, 20, 30],
                sortname: 'firstName',
                sortorder: 'desc',
                viewrecords: true,
                gridview: true,
                sortable: true,
                height: 400,
                width: 1000,
                onSelectRow: function (id) {
                    document.location.href = "${actorView}" + id;
                }
            }).jqGrid('gridResize', $(function () {
                $("#list").resizable({
                    animate: true
                });
            }))
//                .jqGrid('columnChooser', {
//                done: function (perm) {
//                    if (perm) {
//                        this.jqGrid("remapColumns", perm, true);
//                    } else {
//                    }
//                }
//            })
                .jqGrid('sortableRows', $(function () {
                $("#list").sortable();
                $("#list").disableSelection();
            }));
        });
    })(jQuery);

</script>
<div class="container">
    <table class="table table-hover" id="list">
        <tr>
            <td/>
        </tr>
    </table>
</div>
<div id="pager">

</div>
</body>
</html>