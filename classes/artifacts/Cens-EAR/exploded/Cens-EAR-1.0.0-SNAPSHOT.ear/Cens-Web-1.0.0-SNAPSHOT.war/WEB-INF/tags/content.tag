<%@tag pageEncoding="UTF-8" %>
<%@attribute name="titre" fragment="true" %>
<%@attribute name="description" fragment="true" %>
<div class="row">
    <div class="col-lg-12" id="contentHeader">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h1 class="panel-title">
                    <jsp:invoke fragment="titre"/>
                    <%--<small>Statistics Overview</small>--%>
                </h1>
            </div>
            <div class="panel-body">
                <%--INJECTION DU CONTENU BODY--%>
                <jsp:doBody/>
            </div>
        </div>
    </div>
</div>