<%@ page import="it.edenred.bean.*" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<html>
<head>
<title>Test</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<a href="javascript:history.go(-1)">&lt;&lt; Indietro</a>
	
	<br><br>
	Risultati per <bean:write name="localita"/>: 
	<table class="tabel">
		<thead>
			<tr>
				<th>Cod. affiliato</th>
				<th>Nome locale</th>
				<th>Indirizzo</th>
				<th>Telefono</th>	
				<th>Localit�</th>
			</tr>
		</thead>
		<tbody>		
			<logic:present name="affiliati">	
				<logic:iterate name="affiliati" id="affiliato">
					<tr>
						<td align="center"><bean:write name="affiliato" property="codAffiliato"/></td>
						<td align="center"><bean:write name="affiliato" property="nomeLocale"/></td>
						<td align="center"><bean:write name="affiliato" property="indirizzoLocale"/></td>
						<td align="center"><bean:write name="affiliato" property="telefono"/></td>				
						<td align="center"><bean:write name="affiliato" property="localita"/></td>			
					</tr>
		     	</logic:iterate>
	     	</logic:present>
	     </tbody>
	</table>	
</body>
</html>