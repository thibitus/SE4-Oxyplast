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
           <li>
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Projecten <span class="caret"></span></a>
           <ul class="dropdown-menu">
            <li><a href="<c:url value="/" />">Overzicht Projecten</a></li>
            <li><a href="<c:url value="/aanvraagOverzicht" />">Overzicht Aanvragen</a></li>
            <li><a href="<c:url value="/prototypeOverzicht" />"">Overzicht Onderzoekers</a></li>
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
<h1>Details van team</h1>
    <div class="table-responsive">
     <table class="table table-striped">
              
              <tbody>
              <tr>
              <td>ID</td>
              <td><c:out value="${team.id}" /></td>
              </tr>
              <tr>
              <td>Naam</td>
              <td><c:out value="${team.naam}" /></td>
              </tr>
              <tr>            
      </tbody>
      </table>
       <h2>Onderzoekers van het gekozen team</h2>
                
                <table class="table table-striped">
                </tbody>
                <c:forEach items="${onderzoeker}" var="onderzoeker">
                <c:url var="onderzoekerUrl" value="onderzoeker/onderzoeker.html">
                    <c:param name="id" value="${onderzoeker.id}" />
                </c:url>
                <tr>
                  <td> 
                 <a href='<c:out value="${onderzoekerUrl}"/>'> <c:out value="${onderzoeker.id}" /></a>
                </td>
                  <td>    <c:out value="${onderzoeker.voornaam}" /></td>
                  <td>    <c:out value="${onderzoeker.naam}" /></td>
                
                 <td>   
                <c:url var="editOnderzoeker" value="onderzoeker/editOnderzoeker.html">
                <c:param name="id" value="${onderzoeker.id}" />
                </c:url>
        		<a href='<c:out value="${editOnderzoeker}"/>'>Onderzoeker aanpassen</a>
                </td>
                
                <td>   
                <c:url var="deleteOnderzoeker" value="onderzoeker/deleteOnderzoeker.html">
                <c:param name="id" value="${onderzoeker.id}" />
                </c:url>
        		<a href='<c:out value="${deleteOnderzoeker}"/>'>Onderzoeker ontslaan</a>
                </td>
                </tr>
                  </c:forEach>
                
                </tbody>
                </table>
                
          
        
        
        <c:url var="terug" value="/team/teamOverzicht.html" />
        <a href='<c:out value="${terug}"/>'>Terug</a>        
       </div>
      </div>
    </body>
</html>
