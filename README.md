# Desafio Automação Renner

Como executar via IDE Junit:

1. Importar na IDE de preferência o projeto como maven java
   Abra o arquivo RunnerTest.java (diretório: src/test/java/runner e executar via Junit

2.1 Executar o projeto como Junit

Como executar via linha de comando utilizando maven(necessario ter o maven configurado na maquina):

1. Abrir o terminal no diretorio do projeto
2. Executar o comando: mvn test

Como executar via linha de comando utilizando maven, para gerar relatorio(necessario ter o maven configurado na maquina):

1. Abra o terminal no diretorio do projeto
2. Executar o comando: mvn install
3. Abra o arquivo: \target\reports\cucumber-html-reports\overview-features.html


# Estrutura do Projeto
Pacotes


	
	Runner:
		Pacote responsavel pela parte das classes de execuções utilizando JUnit e RunWith Cucumber.class.
  
	Core:
		Pacote responsavel pela classe principal contendo as configurações de inicialização de um ou vários navegadores.
  
	Enums:
		Pacote responsável pelas variáveis de navegadores que posteriormente será escolhida pela classe principal.

	Pages:
		Pacote responsavel pela abstração dos métodos utilizados das páginas web.

	Steps:
		Pacote responsavel para guardar as Classes de Steps, as quais são geradas pelo cucumber. Nessas classes são chamadas as ações das paginas através das pages e validações.
   
	Map:
		Pacote responsavel pelas classes contendo as inspeções dos elemetos da tela.
	
	Features:
		Diretório responsável para guardar os arquivos .feature, onde estão gravados os arquivos relacionados ao cucumber e as escrita em gherkin.
