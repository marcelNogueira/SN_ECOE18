<!DOCTYPE html>
<%@page import="br.edu.unifei.ecoe18.supernatural.model.Habilidade"%>
<%@page import="br.edu.unifei.ecoe18.supernatural.dao.FonteDados"%>
<%@page import="javax.persistence.EntityManager"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/site.css">
<link rel="stylesheet" href="../css/site-conteudo2.css">
<title>Alterar Habilidade</title>
</head>
<body>
<div id="tudo">
<div id="navegacao">
<ul class="menulist ">
	<li class="menuitem">
	<a href="../index.html">Home</a></li>
	<li class="menuitem dropdown">
		<a href="#" class="dropbutton">CRUD</a>
		<div class="dropdown-content">
			<a href="menu.html">Habilidade</a>
	</div></li>
</ul>
</div>
<div id="conteudo1">
	<p><a href="alterar-busca.html">Alterar</a></p>
	<p><a href="consultar-busca.html">Consultar</a></p>
	<p><a href="excluir-busca.html">Excluir</a></p>
	<p><a href="inserir-form.html">Inserir</a></p>
</div>
<div id="conteudo2">
	<% 
		EntityManager em = FonteDados.createManager();
		Habilidade h = (Habilidade)em.find(Habilidade.class, request.getParameter("nome"));
		if(h!=null){
			out.println("<h3>Alterar Habilidade</h3>");
			out.println("<form action=\"alterar.jsp\">");
			out.println("<div><label>Nome</label></div>");
			out.println("<div><input type=\"text\" name=\"nome\" readonly=\"true\" size=\"50\" value=\""+h.getNome()+"\"/></div>");		
			out.println("<div><label>Descricao</label></div>");
			out.println("<div><input type=\"text\" name=\"descricao\" size=\"50\" value=\""+h.getDescricao()+"\"/></div>");		
			out.println("<div class=\"send-button\"><input type=\"submit\" value=\"Alterar\"/></div>");
			out.println("</form>");
		}else{
			out.println("<h3>Nome de habilidade não existe!</h3>");			
		}
	%>
</div>
</div>
<div id="rodape">
<div id="rodape-tudo">
	<h4>Trabalho hipermidia JSP baseado na série Supernatural</h4>
	<p>José Marcel Mendes Nogueira - 2016</p></div>
</div>
</body>
</html>