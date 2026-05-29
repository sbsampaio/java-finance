# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Type

Jakarta EE 10 web application (Maven WAR project) using JSF 3.0, PrimeFaces, and AdminFaces.

## Build & Run

```bash
mvn clean package          # Build WAR
mvn wildfly:run           # Run on WildFly
mvn test                  # Run tests
```

## Architecture

- **Model**: JPA entities with Hibernate (auto-generates `_` metamodel classes in `target/generated-sources`)
- **DAO**: Interface + implementation pattern (extend `CrudDAO` from jbutler)
- **Service**: `@Service` beans extending `CrudService` or custom implementations
- **Controller**: `@Named` beans extending `CrudController` or custom implementations
- **View**: JSF XHTML pages using AdminFaces template

## Configuration Files

| File | Purpose |
|------|---------|
| `src/main/webapp/WEB-INF/web.xml` | Datasource (MySQL `java:app/datasources/finance`), JSF/FacesServlet config |
| `src/main/webapp/WEB-INF/faces-config.xml` | JSF resource bundles (`messages.properties` at `br.ufes.inf.labes.finance.messages`) |
| `src/main/webapp/WEB-INF/beans.xml` | CDI configuration (bean-discovery-mode="annotated") |
| `src/main/resources/admin-config.properties` | AdminFaces settings (`admin.ignoredResources`) |
| `src/main/resources/admin.properties` | AdminFaces messages |

## Key Dependencies

- **jbutler 2.1.2**: Base CRUD framework
- **admin-template 2.0**: AdminFaces UI template
- **jakarta.faces**: JSF 3.0
- **primefaces**: UI components
- **hibernate-jpamodelgen**: Auto-generate JPA metamodel
- **mysql-connector-java 8.0**: MySQL driver
- **jakarta.security**: Authentication/authorization

## Development Pattern (from LAB01.md)

1. Implement `@Entity` classes
2. Generate metamodel (`mvn package` then check `target/generated-sources`)
3. Implement `DAO` interface and `DAOImpl`
4. Implement service interfaces and `*ServiceImpl`
5. Create controllers with `@Named` scope
6. Create `*.xhtml` views in `src/main/webapp`

## Database

MySQL at `localhost:3306/finance` with user `labes`/`labes`.
