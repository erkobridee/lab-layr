# Layr - Hello World 03 - Maven Webapp

Este Hello World foi baseado na estrutura de webapp do Maven, reaproveitando os fontes do **Layr - Hello World 02 - Advanced**


## Utilizado neste projeto

* Archetype do Maven que gerou a estrutura inicial do projeto

```
mvn archetype:generate \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DarchetypeArtifactId=maven-archetype-webapp \
  -Dversion=1.0 \
  -DgroupId=com.erkobridee.layr.helloworld.mvn.webapp01 \
  -DartifactId=layr-helloworld-03
```

> **Observação:** foi utilizado a cópia do arquivo `/WEB-INF/web.xml` do projeto **Layr - Hello World 02 - Advanced**, pois a versão gerada pelo Maven, ao ser importada causa uma mensagem de erro de versão de aplicação dinâmica web incompatível com as dependências utilizadas no projeto.

Os fontes java, ficaram no respectivo pacote:

`com.erkobridee.layr.helloworld.mvn.webapp01.hello`

No diretório: 

`/src/main/java/`

E os fontes referente a interface, no diretório:

`/src/main/webapp/`

--

* Ambiente de desenvolvimento
  * [Java](http://www.java.com/) 1.6+
  * [Maven](http://maven.apache.org/) 3
  * [Eclipse](http://eclipse.org/) Juno JEE (32 bits)
    * [JBoss Tools](https://www.jboss.org/tools), instalado via [Eclipse Marketplace](http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=420896) | **Atenção:** o plugin não funciona corretamente no Eclipse 64 [ref](https://community.jboss.org/wiki/JBosstoolsVisualEditorFAQ).
  * [JBoss 7+ AS](https://www.jboss.org/jbossas/downloads/)
  
Quanto as versões das dependências Java:

`Verificar o arquivo pom.xml`
  

## Montando o ambiente local para uso desse projeto


### Dependência - Layr Framework

Antes de tudo, vai uma nota, o Layr Framework não está disponível no Maven Repository, caso seja a primeira vez que irá utilizar o framework deverá executar o respectivo procedimento.

```
1. Baixar o fonte do GitHub

2. Acessar o diretório /layr-parent

3. Executar o comando maven
```

exemplo:

```
git clone git://github.com/miere/Layr.git
cd Layr/layr-parent
mvn clean install
```

### Importando este projeto para o Eclipse IDE

Tendo o Layr Framework no seu computador, realize o respectivos passos a seguir:

1 . Importe o projeto no Eclipse

Como o Eclipse está com o JBoss Tools e este utiliza como dependência o Maven Puglin, faça a importação para o Eclipse utilizando : `Maven > Existing Maven Projects` que irá configurar o seu projeto corretamente para o Eclipse
  
2 . Para executar o projeto:

Selecione: `Run As > Run on Server` nesta janela selecione o servidor `JBoss Community > JBoss AS 7.1` e indique o diretório onde ele está no seu computador (caso for a primeira vez que irá executar o JBoss, cao contrário, basta selecionar o JBoss e mandar executar a aplicação).

  
3 . Caso queira gerar o .war do projeto utilize o comando, no diretório da aplicação, ou através do plugin Maven no Eclipse

`mvn clean install`
