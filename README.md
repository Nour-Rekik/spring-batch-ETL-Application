# doqtoor-admin-kpi-etl

## Dependencies
- Liquibase migration
- Hibernate-entitymanager
- Hibernate-Core
- Jaxb-api
- Spring-boot-starter-web

## DataBases connection
### Project hierarchy
![img.png](img.png)

### Configuration Logic

### 1- Application.properties
```
#Doqtoor_Admin_KPI
app.datasource1.url=jdbc:postgresql://localhost:5432/doqtoor_admin_kpi
app.datasource1.username=postgres
app.datasource1.password=doqtoor
app.datasource1.driver-class-name=org.postgresql.Driver

#Doqtoor_App
app.datasource2.url=jdbc:postgresql://localhost:5432/exemple1
app.datasource2.username=postgres
app.datasource2.password=doqtoor
app.datasource2.driver-class-name=org.postgresql.Driver


spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.database=postgresql
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL95Dialect
```

Each datasource is configured separately and given a unique prefix.

### 2- Config
Each datasource has its own configuration file. The file contains 4 functions:

**1- Configuration of dataSource properties**
```
    @Bean
    @ConfigurationProperties("app.datasource1")
    public DataSourceProperties appDataSourceProperties() {
    return new DataSourceProperties();
}
```

**2- Creation of dataSource**
```
    @Bean
    @ConfigurationProperties("app.datasource1.configuration")
    public DataSource appDataSource() {
        return appDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }
```
**3- Entity Manager Factory Bean Definition**

Our application will be using Spring Data JPA for data access through its repository interfaces that abstract us from the EM(Entity Manager). We use the EMF bean to obtain instances of EMs which interact with the JPA entities
```
    @Bean(name = "appEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean appEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(appDataSource())
                .packages(Entity.class) //add all tables in the DB
                .build();
    }
```

**4- Transaction manager Definition**

The bean definition of a transaction manager requires a reference to the entity manager factory bean.
```
    @Bean
    public PlatformTransactionManager appTransactionManager(
            final @Qualifier("appEntityManagerFactory") LocalContainerEntityManagerFactoryBean appEntityManagerFactory) {
        return new JpaTransactionManager(appEntityManagerFactory.getObject());
    }
```

Since we are going to have multiple data sources we must provide the specific information for each data source repository using Spring’ s  "@EnableJpaRepositoriesannotation" . In this annotation, we are going to set the reference to an entity manager, the repositories location and the reference to the transaction manager.

```
    @Configuration
    @EnableTransactionManagement
    @EnableJpaRepositories(
         entityManagerFactoryRef = "appEntityManagerFactory",
         basePackages = 
         {"com.example.doqtooradminkpietl.Repositories.doqtoor_app"}, 
         transactionManagerRef = "appTransactionManager"
    )
```


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







