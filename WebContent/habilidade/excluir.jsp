<!DOCTYPE html>
<%@page import="br.edu.unifei.ecoe18.supernatural.model.Habilidade"%>
<%@page import="br.edu.unifei.ecoe18.supernatural.dao.FonteDados"%>
<%@page import="javax.persistence.RollbackException"%>
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
	EntityManager em = FonteDados.createManager();
	Habilidade h = em.find(Habilidade.class, request.getParameter("nome"));
	if(h!=null){
		try{
			em.getTransaction().begin();
			em.remove(h);
			em.getTransaction().commit();
			out.println("<h3>Habilidade removida com sucesso!</h3>");
		}catch(Exception ex){
			out.println("<h3>Habilidade não pode ser removido!</h3>");
		}
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