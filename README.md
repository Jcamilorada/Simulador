Simulador
=========
This project is created using spring boot technology. The "Simulador" backend module is mainly rest services.

To run the project
------------------

    1 Using maven and java command line.
        a. mvn clean package on main project (the one with pom.xml)
        b. java -jar /target/generated jar

    2 Using maven
        a. mvn spring-boot:run

Technical Information
---------------------
* [Spring Boot.](http://projects.spring.io/spring-boot/) For self hosting application.
* [Spring MVC.](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) For handle Json request. 
* [Spring data Jpa.](http://projects.spring.io/spring-data-jpa/) For data access.

Before Run the Project
----------------------
Install [Maven](http://maven.apache.org/download.cgi) For the dependency management.

Maven on Unix based systems.
----------------------------
    export M2_HOME=/home/juan/Applications/apache-maven-3.2.3
    export M2=$M2_HOME/bin
    export PATH=$M2:$PATH

___
Getting Started
===============
How to create the project on IntelliJ IDEA
------------------------------------------

    1 On Idea main menu.
        a. Import project. Select the folder that contain the pom.xml file.
        b. Choose maven as project type.
        c. Enabled automatically download sources and documentation (Is really usefull).
    2. To run/debug the project run Application on configuration package.
    
