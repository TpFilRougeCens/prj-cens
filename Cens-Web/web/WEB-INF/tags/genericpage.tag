<%@tag description="TEMPLATE-CENS" pageEncoding="UTF-8" %>
<%@attribute name="scriptHeader" fragment="true" %>
<%@attribute name="scriptFooter" fragment="true" %>

<%--//TODO Attention les chemins sont en relatif en ref au dossier 'web' Cause : Include. c'est normal...--%>
<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="LPC (Livret de compétences) du CENS">
    <meta name="author" content="imie-cdi12">

    <title>CENS - Livret de compétences</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="fonts/awesome/css/font-awesome.css" rel="stylesheet" type="text/css">

    <!--Favicon CENS-->
    <link rel="shortcut icon" type="image/x-icon" href="img/logo/favicon.ico">

    <!-- Custom chart with chart.js -->
    <script src="js/chart.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

    <%--Inject more script from tags--%>
    <jsp:invoke fragment="scriptHeader"/>

</head>
<body>
<div id="wrapper">

    <%--Navigation TOP ET LEFT--%>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <%--Barre TOP de navigation horizontale --%>
        <%@include file="menu-top.tag" %>
        <%--Barre LEFT de navigation verticale --%>
        <%@include file="menu-left.tag" %>
    </nav>

    <div id="page-wrapper">

        <div class="container-fluid">

            <%--ENTÊTE DE LA PAGE--%>
            <%@include file="heading.tag" %>


            <%--INJECTION DU CONTENU BODY--%>
            <jsp:doBody/>


        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<%--Inject more Script from tags--%>
<jsp:invoke fragment="scriptFooter"/>

</body>

</html>

