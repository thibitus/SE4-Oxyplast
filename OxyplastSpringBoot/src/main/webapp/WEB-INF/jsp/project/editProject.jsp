<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Project Aanpassen</title>
    <c:url value="/resources/css/bootstrap.min.css" var="bootstrapcss" />
    <c:url value="/resources/css/bootstrap-theme.min.css" var="bootstraptheme" />
    <c:url value="/resources/js/bootstrap.min.js" var="bootstrapjs" />
    <c:url value="/resources/js/jquery-2.2.2.min.js" var="jq" />

    <script src="${jq}"></script>

    <link href="${bootstrapcss}" rel="stylesheet">
    <link href="${bootstraptheme}" rel="stylesheet">
    <script src="${bootstrapjs}"></script>

</head>

<body style="padding-top: 50px;">

   <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Oxplast</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="<c:url value="/" />">Home</a></li>
           <li>
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Projecten <span class="caret"></span></a>
           <ul class="dropdown-menu">
            <li><a href="<c:url value="/" />">Overzicht Projecten</a></li>
            <li><a href="<c:url value="/aanvraagOverzicht" />">Overzicht Aanvragen</a></li>
            <li><a href="<c:url value="/prototypeOverzicht" />"">Overzicht Prototypes</a></li>
            <li><a href="<c:url value="/leverancierOverzicht" />"">Overzicht Leveranciers</a></li>
            <li><a href="<c:url value="/teamoverzicht" />"">Overzicht Teams</a></li>
          </ul>    
           </li>
            <li><a href="<c:url value="/profiel" />">Profiel</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
<div class="container">
<h1>Details van project</h1>
    
        
       <c:url var="url" value="/editProject.html" />
        <form:form action="${url}" commandName="projectAanpassen" class="form-horizontal" method="POST">   <%-- Spring form tags --%>
                <div class="form-group">
                    <label for="id" class="col-sm-2 control-label">ID</label>
                    <div class="col-sm-10">
                        <form:input type="number" class="form-control" id="id" path="id" placeholder="id" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="naam" class="col-sm-2 control-label">Naam</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="naam" path="naam" placeholder="De Naam" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="status" class="col-sm-2 control-label">Status</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="status" path="status" placeholder="De status" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="teamId" class="col-sm-2 control-label">TeamId</label>
                    <div class="col-sm-10">
                        <form:input type="teamId" class="form-control" id="teamId" path="teamId" placeholder="Team ID" />
                    </div>
                </div>
                 <div class="form-group">
                    <label for="startdate" class="col-sm-2 control-label">Start Datum</label>
                    <div class="col-sm-10">
                        <form:input type="date" class="form-control" id="startdate" path="startdate" placeholder="startdate" />
                    </div>
                </div>
                 <div class="form-group">
                    <label for="enddate" class="col-sm-2 control-label">Eind Datum</label>
                    <div class="col-sm-10">
                        <form:input type="date" class="form-control" id="enddate" path="enddate" placeholder="enddate" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" value="save" name="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>

        </form:form>

        <div class="table-responsive">
            <table class="table table-striped">

                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>
                            <c:out value="${project.id}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Naam</td>
                        <td>
                            <c:out value="${project.naam}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td>
                            <c:out value="${project.status}" />
                        </td>
                    </tr>
                    <tr>
                        <td>TeamId</td>
                        <td>
                            <c:out value="${project.teamId}" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>