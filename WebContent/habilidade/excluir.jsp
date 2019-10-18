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
	<a href="#home">Home</a></li>
	<li class="menuitem dropdown">
		<a href="#" class="dropbutton">Cadastro</a>
		<div class="dropdown-content">
			<a href="menu.html">Habilidade</a>
	</div></li>
	<li class="menuitem">
	<a href="#contact">Galeria</a></li>
	<li class="menuitem">
	<a href="#about">Contato</a></li>
</ul>
</div>
<div id="conteudo1">
	<p><a href="inserir-form.html">inserir</a></p>
	<p><a href="alterar-busca.html">alterar</a></p>
	<p><a href="excluir-busca.html">excluir</a></p>
	<p><a href="consultar-busca.html">consultar</a></p>
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
			out.println("habilidade removido");
		}catch(Exception ex){
			out.println("habilidade não pode ser removido");
		}
	}else{
		out.println("nome de habilidade não existe");
	}
	%>
</div>
</div>
<div id="rodape">
<div id="rodape-tudo"></div>
</div>
</body>
</html>