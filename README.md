# prj-cens
<i>Projet pour le Cens</i>

Login et mot de passe:
<ul>
<li>theo/password (élève)</li>
<li>jean/password (enseignant)</li>
<li>paul/password (manager)</li>
<li>delphine/password (coordinateur)</li>
<li>philippe/password (directeur)</li>
</ul>

<hr/>
<h2>Dev Server pour le front :</h2>
<ul>
<li>Basé sur : https://github.com/AngularClass/angular2-webpack-starter</li>
<li>Support de sass</li>
<li>Proxy : vérifier que celui-ci pointe bien vers le web service (fichier 'front/config/webpack.dev.js')</li>
</ul>



```javascript
proxy: {
      '/rest/*': {
        target: 'http://localhost:8080/Cens-Web-1.0.0-SNAPSHOT',
        secure: false,
      },
    }
```




<hr/>
<h2>DataBase :</h2>
<ul>
<li>Name : cens </li>
<li>User : postgres</li>
<li>Password : P@ssword</li>
<li>URL : jdbc:postgresql://127.0.0.1:5432/cens</li>
<li>Port : 5432</li>
<li>Driver.class : org.postgresql.Driver</li>
<li>Driver.version : postrgesql-9.4-1201.jdbc4</li>
</ul>
<hr/>
<h2>Server</h2>
<ul>
<li>Server : WildFly Jboss</li>
<li>Version : 10.0.1</li>
<li>Config. : see standalone.xml</li>
</ul>
<hr/>
<h2>App</h2>
<ul>
<li>IDE : IntelliJ iDEA 15 <small>(DEV. WITH INTELLIJ IDEA 15 64Bits for use last JRE)<br/>path : "C:\Program Files (x86)\JetBrains\IntelliJ IDEA 15.0.3\bin\idea64.exe"</small></li>
<li>JDK : Java 1.8.0_73 (for system environnement, app, IDEA and Wildfly</li>
<li>ORM :  JPA Hibernate 2.1</li>
<li>Class service : EJB</li>
<li>Front : Angular 2, Bootstrap CSS</li>
<li>Template : tags (JEE)</li>
<li>Artefact: 'Cens'</li>
<li>Demo : http://127.0.0.1:8080/Cens/TestNiveau</li>
</ul>

<hr/>
<h2>View : <h2/>
<img src="git/demo1.png"/>

<h2>IntelliJ Environnement: <h2/>
<img src="git/intelliJ1.png"/>
