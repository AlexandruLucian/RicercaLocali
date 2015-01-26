<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
 
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#localita').keyup(function () {
    	var localita = $('#localita').val();	
        $.ajax({
            type: "post",
            url: "getAffiliati.do",
            data: "localita="+$('#localita').val(),
            success: function(){   
            	$('#affiliati').load("affiliati.jsp");
            }
        });
    });
});
</script>
<script type="text/javascript">
<!--
 
var stile = "top=10, left=10, width=250, height=200, status=no, menubar=no, toolbar=no scrollbars=no";
 
function Popup(apri) 
{
  window.open(apri, "", stile);
}
//-->
</script>

<html>
<head>
<title>Test</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
</head>

<body>
	<html:form action="getAffiliati">
         Localita:
         <html:text property="localita" styleId="localita"></html:text>
         <html:submit value="Cerca" styleId="cerca"/>       
    </html:form>
    <a href="#" id="link_cerca">Cerca</a>
    <br><br>
    
    <div id="affiliati"></div>
	
</body>
</html>