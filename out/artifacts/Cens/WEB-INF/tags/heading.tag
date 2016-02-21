<%@tag pageEncoding="UTF-8" %>
<%@attribute name="titre" fragment="true" %>
<%@attribute name="description" fragment="true" %>
<div class="row">
    <div class="col-lg-12" id="contentHeader">
        <h1 class="panel panel-default" id="titreH1">
            <jsp:invoke fragment="titre"/>
            <%--<small>Statistics Overview</small>--%>
        </h1>
        <%--<ol class="breadcrumb">--%>
        <%--<li class="active">--%>
        <%--<i class="fa fa-dashboard"></i>--%>
        <%--<jsp:invoke fragment="description"/>--%>
        <%--</li>--%>
        <%--</ol>--%>

    </div>
</div>