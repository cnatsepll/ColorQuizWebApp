# Java Webapp on Heroku

The follow instructions show you how to run a Java Webapp on Heroku.  It also includes the additional steps needed to optionally deploy a PostgreSQL database to Heroku, and to enable your application to connect to it.  

Free has its cost
===

Heroku provides Java hosting for free, however, there are limits.  You may have only 5 Heroku applications registered at one time. You can increase this limit if you are willing to "verify" your account by attaching a credit card to it.  Additionally, the free "hobby-dev" database option used in the instructions below is limited to 10,000 rows across all tables. More rows come at a cost.  Finally, your free "dynos" (slices of a VM) are quicker to spin down, and slower to spin up.

Still, it's hard to beat the price of free.

You can find more detailed information at:  
[Limits](https://devcenter.heroku.com/articles/limits#heroku-postgres)  
[Choosing the Right Postgres Plan](https://devcenter.heroku.com/articles/heroku-postgres-plans#plan-tiers)  

One Time Heroku Setup
===

Create Heroku account, see the Heroku site.

Install Heroku Toolbelt, see Heroku site.

Confirm your installation by asking the Heroku Toolbelt for its version. Whether a version is shown is more important than the actual value displayed at this time.

```
$ heroku --version
```

***Note: All commands shown throughout this document are entered in the terminal.*** You should always skip the beginning `$`. It represents the standard command line prompt.

Deploy Java WebApp to Heroku
===

***NOTE: Your Java WebApp must be a Maven project, and have a local Git repository, in order to be deployed to Heroku using these instructions.***

Login using your Heroku account.

```
$ heroku login
```

Navigate to your Java Project, and confirm that `pom.xml` has the Heroku `<plugin>` under `<build><plugins>`

```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <version>2.3</version>
    <executions>
        <execution>
            <phase>package</phase>
            <goals><goal>copy</goal></goals>
            <configuration>
                <artifactItems>
                    <artifactItem>
                        <groupId>com.github.jsimone</groupId>
                        <artifactId>webapp-runner-main</artifactId>
                        <version>8.5.15.1</version>
                        <destFileName>webapp-runner.jar</destFileName>
                    </artifactItem>
                </artifactItems>
            </configuration>
        </execution>
    </executions>
</plugin>
```

Add a file called `Procfile` in the same directory as the pom.xml file in the root of your application. Give it the following contents:

```
web: java $JAVA_OPTS -jar target/dependency/webapp-runner.jar $WEBAPP_RUNNER_OPTS --port $PORT target/*.war
```

Create a Heroku application (`HEROKU_APPNAME`) for your project.  

```
$ heroku create
Creating app... done, ⬢ partying-squirrel-54123
https://partying-squirrel-54123.herokuapp.com/ | https://git.heroku.com/partying-squirrel-54123.git
```

You should verify that the creation went well by checking the `heroku` remote added to your local Git repo. Both the `fetch` and `push` remote URLs should contain the new `HEROKU_APPNAME`.

```
$ git remote -v
heroku https://git.heroku.com/partying-squirrel-54123.git (fetch)
heroku https://git.heroku.com/partying-squirrel-54123.git (push)
origin git@bitbucket.org:te-curriculum/citystate.git (fetch)
origin git@bitbucket.org:te-curriculum/citystate.git (push)
```

***If the app name does not appear in the*** `heroku` ***remote, you have two options to correct to situation.***

**(Option 1)** Update the heroku remote with the correct `HEROKU_APPNAME`.

```
$ heroku git:remote -a HEROKU_APPNAME
```

**(Option 2)** Delete the newly created app from the command line, and create a new app

```
$ heroku apps:destroy --app HEROKU_APPNAME
$ heroku create
```

Regardless of which option you use, don't forget to check that the `HEROKU_APPNAME` was added correctly.

```
$ git remote -v
.
.
.
```

***NOTE: If you are repeatedly asked to add '--app' to a Heroku command, or are told to supply a Heroku application name while running a Heroku command, it may mean the `heroku` remote is not set.***  Please confirm, and if necessary fix the Heroku remote as instructed above.

Deploy the project to your Heroku application.

```
$ git push heroku master
```

***Note: You need to redeploy the project by committing all your changes and using the `git push heroku master` command every time you make a local change that you want to push up to Heroku.***

Deploy Database for Your Application to Heroku *(Optional)*
===

Attach an instance of PostgreSQL to your Heroku application. ***This might have happened by default. You can check this from your heroku.com dashboard.***

```
$ heroku addons:create heroku-postgresql:hobby-dev
```

Export your existing database using PostgreSQL's `pg_dump`.

```
$ pg_dump -U USERNAME DATABASE --no-owner --no-acl -f dump.sql

Example:  
$ pg_dump -U postgres world --no-owner --no-acl -f world.sql
```

Use the Heroku Toolbelt to import the dumped database into your Heroku application's PostgreSQL database.

```
$ heroku pg:psql --app HEROKU_APPNAME < dump.sql

Example:  
$ heroku pg:psql --app voyage-livre-56152 < world.sql
```

Add the Heroku Profile beanset, `<beans profile="heroku">` shown below to the application's Spring Context XML (`spring-servlet.xml`).  You should the leave the existing `<bean id="datasource"...>` and `<bean id="txManager"...>` beans untouched.  They are still needed in order to run your application in your local development environment. Replace the dataSource bean with the following to the Spring Context XML. 

```
<!-- Leave the "datasource" and "txManager" beans in place in order to run the application locally -->
<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
    <property name="driverClassName" value="org.postgresql.Driver" />
    <property name="url" value="jdbc:postgresql://localhost:5432/world" />
    <property name="username" value="postgres" />
    <property name="password" value="postgres1" />
</bean>
.
.
.
<!-- Add the "heroku" beanset to connect to the Heroku Postgres database when running your application on Heroku. -->
<!-- Note: There is no need to modify the Heroku beanset. It should work as-is. -->

<beans profile="heroku">
    <bean class="java.net.URI" id="dbUrl">
        <constructor-arg value="#{systemEnvironment['DATABASE_URL']}"/>
    </bean>
    <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
        <property name="url" value="#{ 'jdbc:postgresql://' + @dbUrl.getHost() + ':' + @dbUrl.getPort() + @dbUrl.getPath() }"/>
        <property name="username" value="#{ @dbUrl.getUserInfo().split(':')[0] }"/>
        <property name="password" value="#{ @dbUrl.getUserInfo().split(':')[1] }"/>
    </bean>	
</beans>
```

Before redeploying to push the change to the Spring Context XML, set the SPRING_PROFILES_ACTIVE environment variable to "heroku" on the Heroku application.  This enables the "heroku" beanset which will override the default `datasource`, allowing the application to connect the Heroku database.

```
$ heroku config:set SPRING_PROFILES_ACTIVE=heroku
```

Confirm the environment variable has been set.

```
$ heroku config
=== partying-squirrel-54123 Config Vars
DATABASE_URL:           postgres://xfacximftlurch:b3da9fc...023aea7cce148ee@ec2-184-73-199-72.compute-1.amazonaws.com:5432/d3d9h517t8k1e3
SPRING_PROFILES_ACTIVE: heroku
```

Finally, redeploy the app on Heroku once all the database related changes have been made.

```
$ git commit -a -m"Add heroku database configuration"
$ git push heroku master
```

Fun and Interesting Things to Know
===

You may open the app from the command line
---
```
$ heroku open
```

You can determine who you are logged in as by examining `~/.netrc`.
---
```
$ less ~/.netrc
```

Rename the app
---
```
$ heroku apps:rename newname
```

***Note: Don't forget to update git remotes for all other local checkouts of the app.***

Delete the app
---
```	
$ heroku apps:destroy --app appname
```

***Note: You should always use the command line to delete Heroku apps.*** It removes the heroku remote from the local Git repo, and avoids the problems discussed earlier in Heroku create section. ***Do not delete Heroku apps via the web UI.***

You can explore the deployed application's database with the PostgreSQL client `psql` running on Heroku.
---
```
$ heroku pg:psql --app HEROKU_APPNAME

Example:  
$ heroku pg:psql --app partying-squirrel-54123
```

If necessary, you can clear/reset the the Heroku Postgres database using the Heroko's Toolbelt.
---
```
$ heroku pg:reset DATABASE_URL
```

Documentation and Help
===

[Getting Started](https://devcenter.heroku.com/start)  
[References](https://devcenter.heroku.com/categories/reference)  
[Learning](https://devcenter.heroku.com/categories/learning)  

