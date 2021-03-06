<!DOCTYPE html>
<html lang="en">
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		
	
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Correção Provas</title>

  <!-- CSS  -->
	
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css" type="text/css" rel="stylesheet">
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/js/materialize.min.js"></script>
	<script src="criaInputs.js"></script>
  <style type="text/css">
    body {
        display: flex;
        min-height: 100vh;
        flex-direction: column;
      }
      main {
        flex: 1 0 auto;
      }
  </style>
  <link rel="icon" href="imgs/logo.png" >
</head>
<body>
	<nav class="light-blue darken-4" role="navigation">
    <div class="nav-wrapper container">
      <!-- MENU SLIDE OUT STRUCTURE-->
    <ul id="slide-out" class="side-nav">
      <br>
      <li>
        <div class="logo">
          <img class="background center-block responsive" src="C:\Users\Aluno\Desktop\portal-educacao\portal-educacao-master\imgs/logo.png">
        </div>
      </li>
      <br>
      <li><a class="waves-effect" href="index.html">Página Inicial</a></li>
      <li><a class="waves-effect" href="#!">Modelo de Provas/Trabalhos</a></li>
      <li><a class="waves-effect" href="#!">Fórum</a></li>
      <li><a class="waves-effect" href="#!">Download/Upload Aplicativos</a></li>
      <li><a class="waves-effect" href="#!">Correção Provas e Trabalhos</a></li>
      <li><a class="waves-effect" href="Mural/projeto/index.html">Mural</a></li>
      <li><a class="waves-effect" href="#!">Chat</a></li>
      <li><a class="waves-effect" href="#!">Repositório de Fotos</a></li>
      <li><a class="waves-effect" href="#!">Banco de Questões</a></li>
      <li><a class="waves-effect" href="#!">Calendário</a></li>
      <!--<li><div class="divider"></div></li>-->
      <!--<li><a class="subheader">Subheader</a></li>-->
    </ul>
      <ul class="left ">
        <li>
          <button data-activates="slide-out" class="waves-effect waves-light btn-flat button-collapse white-text ">Menu</button>
        </li>
      </ul>
      <ul class="right ">
        <!-- <li><button class="waves-effect waves-light btn-flat white-text light-blue darken-4">Entrar</button></li> -->
        <li><a class="waves-effect waves-light btn modal-trigger white-text light-blue darken-3" href="#modal1">Entrar</a></li>
      </ul>
    </div>
  </nav>
	
</body>
</html>
<html>
  <head>
  	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script src=criarGrafico.js></script>
		<script type=text/javascript>
			var nomes = Array();
			var notas = Array();
			$(document).ready(function(){
				var obj = <?php session_start(); echo json_encode($_SESSION['respostasAssociadas']); ?>;
				for (i=0; i<obj.length; i++){
					nomes.push(Object.keys(obj[i]));
					notas.push(obj[i][nomes[i]]);
				}	
			})
		</script>
		<script src=media.js></script>
  </head>
  <body>
		<br>
		<div class="container">
			<div class="center" id="barchart_material" style="width: 700px; height: 800px; display: table;
    	margin: 0 auto; "></div>
		</div>
		<div class="container">
			<h5 id="media" class="center blue-text text-darken-4"></h5>
		</div>


	 <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          </div>
        </div>
      </div>

    </div>
    
    <div class="section">

    </div>
  

  <footer class="page-footer blue">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Desenvolvedores</h5>
          <p class="grey-text text-lighten-4">Somos a turma de Informática 2A do ano de 2016 do CEFET-MG (Centro Federal de Educação Tecnológica de Minas Gerais) desenvolvendo o trabalho final multidisciplinar de Linguagem de Programação 1 e Aplicações para WEB.</p>


        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Sobre a Instituição</h5>
          <p class="grey-text text-lighten-4">
            Centro Federal de Educação Tecnológica de Minas Gerais
            <br>Av. Amazonas 5253 - Nova Suiça - Belo Horizonte - MG - Brasil
            <br>Telefone: +55 (31) 3319-7000 - Fax: +55 (31) 3319-7001
          </p>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Recursos</h5>
          <ul>
            <li><a class="white-text" href="https://github.com/cefet-inf-2015/portal-educacao/" target="_blank">Github</a></li>
            <li><a class="white-text" href="http://cefetmg.br/" target="_blank">CEFET-MG</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="blue-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
    </div>
  </footer> 


  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="C:\Users\Aluno\Desktop\portal-educacao\portal-educacao-master\template/js/materialize.js"></script>
  <script src="C:\Users\Aluno\Desktop\portal-educacao\portal-educacao-master\template/js/init.js"></script>
  <script src="C:\Users\Aluno\Desktop\portal-educacao\portal-educacao-master\index.js"></script>

</body>

</html>

  </body>
</html>
<?php
unset($_SESSION['alunos']);
unset($_SESSION['numeroCorretas']);
unset($_SESSION['respostasAssociadas']);
?>