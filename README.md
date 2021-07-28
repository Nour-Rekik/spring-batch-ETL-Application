# doqtoor-admin-kpi-etl

## Dependencies
* Liquibase migration

## Liquibase-with-spring boot 

### Plugin
```
<plugin>
                <groupId>org.liquibase</groupId>
                <artifactId>liquibase-maven-plugin</artifactId>
                <configuration>
                    <propertyFile>src/main/resources/application.properties</propertyFile>
                    <propertyFileWillOverride>true</propertyFileWillOverride>
                </configuration>
            </plugin>
```
### Connexion to Database


Configuration of datasource properties in application.properties file :
 ``` 
 spring.datasource1.liquibase.enabled=true
spring.application.name=0
datasource.primaryliquibase.liquibase.change-log=classpath:db/changelog/changelog-master.xml
```
Configuration related to the database connection : 

```
@Bean
    @ConfigurationProperties(prefix = "datasource.primaryliquibase.liquibase")
    public LiquibaseProperties primaryLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public SpringLiquibase primaryLiquibase() {
        return springLiquibase(kpiDataSource(), primaryLiquibaseProperties());
    }

    private static SpringLiquibase springLiquibase(DataSource dataSource, LiquibaseProperties properties) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog(properties.getChangeLog());
        System.out.println(liquibase.getChangeLog());
        liquibase.setContexts(properties.getContexts());
        liquibase.setDefaultSchema(properties.getDefaultSchema());
        liquibase.setDropFirst(properties.isDropFirst());
        liquibase.setShouldRun(properties.isEnabled());
        liquibase.setLabels(properties.getLabels());
        liquibase.setChangeLogParameters(properties.getParameters());
        liquibase.setRollbackFile(properties.getRollbackFile());
        return liquibase;
    }

```
### Configuration of changelog files 
* Creating changelog-master.xml including every changelog file

### Liquibase work process
When Liquibase kicks in during the spring-boot app deployment, it performs (on a very high level) the following steps:

1) Lock the database (create a record in databasechangeloglock)
2) execute changeLogs;
3) remove database lock;

So if you interrupt application deployment while Liquibase is between steps 1 and 3, then your database will remain locked. So when you'll try to redeploy your app, Liquibase will fail, because it will treat your database as locked.
So you have to unlock the database before deploying the app again.
There is a way to fix it:

- Clear databasechangeloglock table or set locked to false. Which is ```DELETE FROM databasechangeloglock;``` or ```UPDATE databasechangeloglock SET locked=false;```







