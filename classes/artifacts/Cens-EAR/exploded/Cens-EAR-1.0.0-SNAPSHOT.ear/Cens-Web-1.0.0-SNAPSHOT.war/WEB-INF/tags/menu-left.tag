<%@tag pageEncoding="UTF-8" %>
<%@attribute name="menu" fragment="true" %>
<div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav side-nav">
        <li class="entete">
            NAVIGATION
        </li>
        <li class="active">
            <a href="#"><i class="fa fa-fw fa-dashboard"></i> Tableau de bord</a>
        </li>
        <li>
            <a href="#"><i class="fa fa-fw fa-arrows-v"></i> Mes élèves</a>
        </li>
        <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i
                    class="fa fa-fw fa-bar-chart-o"></i> Évaluations <i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="demo" class="collapse">
                <li>
                    <a href="#">Ajouter une évaluation à une classe</a>
                </li>
                <li>
                    <a href="#">Vérifier les évaluations</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="samples/bootstrap/blank-page.html"><i class="fa fa-fw fa-file"></i> Samples</a>
        </li>
        <jsp:invoke fragment="menu"/>
    </ul>
</div>
