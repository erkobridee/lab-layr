Layr - Hello World 01 - Simple
====================================

Como tudo que é novo e vou utilizar pela primeira vez, vamos ao clássico Hello World, ultra simples, para ver este framework funcionando no Web Browser.

Utilizado neste projeto
-----------------------

* Estrutura modelo

	[Layr / layr-jee-natural-routing-sample](https://github.com/miere/Layr/tree/master/layr-jee-natural-routing-sample)


* Ambiente de desenvolvimento
  * [Java](http://www.java.com/) 1.6+
  * [Maven](http://maven.apache.org/) 3
  * [Eclipse](http://eclipse.org/) Juno JEE (32 bits)
    * [JBoss Tools](https://www.jboss.org/tools), instalado via [Eclipse Marketplace](http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=420896) | **Atenção:** o plugin não funciona corretamente no Eclipse 64 [ref](https://community.jboss.org/wiki/JBosstoolsVisualEditorFAQ).
  * [JBoss 7+ AS](https://www.jboss.org/jbossas/downloads/)
  
Quanto as versões das dependências Java:

	Verificar o arquivo pom.xml
  

Montando o ambiente local para uso desse projeto
------------------------------------------------

Antes de tudo, vai uma nota, o Layr Framework não está disponível no Maven Repository, caso seja a primeira vez que irá utilizar o framework deverá executar o respectivo procedimento.

1. Baixar o fonte do GitHub
2. Acessar o diretório /layr-parent
3. Executar o comando maven

exemplo:

		git clone git://github.com/miere/Layr.git
		cd Layr/layr-parent
		mvn clean install


Tendo o Layr Framework no seu computador, realize o respectivos passos a seguir:

1. Importe o projeto no Eclipse

	Como o Eclipse está com o JBoss Tools e este utiliza como dependência o Maven Puglin, faça a importação para o Eclipse utilizando : `Maven > Existing Maven Projects` que irá configurar o seu projeto corretamente para o Eclipse
  
2. Para executar o projeto:

	Selecione: `Run As > Run on Server` nesta janela selecione o servidor `JBoss Community > JBoss AS 7.1` e indique o diretório onde ele está no seu computador (caso for a primeira vez que irá executar o JBoss, cao contrário, basta selecionar o JBoss e mandar executar a aplicação).

  
3. Caso queira gerar o .war do projeto utilize o comando, no diretório da aplicação, ou através do plugin Maven no Eclipse

  		mvn clean install
