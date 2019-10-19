<!DOCTYPE html>
<%@page import="br.edu.unifei.ecoe18.supernatural.dao.FonteDados"%>
<%@page import="br.edu.unifei.ecoe18.supernatural.model.Habilidade"%>
<%@page import="javax.persistence.RollbackException"%>
<%@page import="javax.persistence.EntityManager"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/site.css">
<link rel="stylesheet" href="../css/site-conteudo2.css">
<title>Inserir Habilidade</title>
</head>
<body>
<div id="tudo">
<div id="navegacao">
<ul class="menulist ">
	<li class="menuitem">
	<a href="..">Home</a></li>
	<li class="menuitem dropdown">
		<a href="#" class="dropbutton">Cadastro</a>
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
	Habilidade h = new Habilidade();
	h.setNome(
			request.getParameter("nome"));
	h.setDescricao(
			request.getParameter("descricao"));
	
	EntityManager em = 
			FonteDados.createManager();
	try{
		em.getTransaction().begin();
		em.persist(h);
		em.getTransaction().commit();
		out.println("<h3>Habilidade inserido com sucesso!</h3>");		
	}catch(Exception ex){
		if (ex instanceof RollbackException){
			out.println("<h3>Nome de habilidade j� existe!</h3>");
		}
	}
	%>
</div>
</div>
<div id="rodape">
<div id="rodape-tudo">
	<h4>Trabalho hipermidia JSP baseado na s�rie Supernatural</h4>
	<p>Jos� Marcel Mendes Nogueira - 2016</p></div>
</div>
</body>
</html>