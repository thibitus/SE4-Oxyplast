<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Overzicht Project</title>
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
            <li><a href="<c:url value="/" />">Projecten</a></li>
            <li><a href="<c:url value="/" />">Profiel</a></li>
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
    <div class="table-responsive">
     <table class="table table-striped">
              
              <tbody>
              <tr>
              <td>ID</td>
              <td><c:out value="${project.id}" /></td>
              </tr>
              <tr>
              <td>Naam</td>
              <td><c:out value="${project.naam}" /></td>
              </tr>
              <tr>
              <td>Status</td>
              <td><c:out value="${project.status}" /></td>
              </tr>
              <tr>
              <td>TeamId</td>
              <td><c:out value="${project.teamId}" /></td>
              </tr>              
      </tbody>
      </table>
      
        
        
        <c:url var="home" value="/index.html" />
        <a href='<c:out value="${home}"/>'>Terug</a>        
       </div>
      </div>
    </body>
</html>
