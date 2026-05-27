# devsu-test-e2e-api
Pruebas para Devsu E2E y API

# Link de Github
https://github.com/jdavidzt9003/devsu-test-e2e-api.git

# QA Automation Exercise — Serenity BDD + Karate Framework

Proyecto de automatización de pruebas que implementa:

- **Pruebas UI** con **Serenity BDD + Screenplay + Java + Cucumber**
- **Pruebas API** con **Karate Framework**

---

# Tecnologías utilizadas

## UI Automation

- Java 17
- Serenity BDD
- Screenplay Pattern
- Cucumber
- JUnit 5
- Maven

## API Automation

- Karate Framework
- Maven
- JUnit 5

---

# Estructura del proyecto
Screenplay - SerenityBDD

---

# Configuración previa

Instalar:

- Java 17+
- Maven 3.9+
- Chrome Browser

Validar instalación:

```bash
java -version
mvn -version
```

---

# Ejecución de pruebas UI — Serenity BDD

## Ejecutar todas las pruebas UI

```bash
mvn clean verify
```

## Ejecutar runner específico

Ejemplo:

```bash
mvn test -Dtest=RunnerTest
```

---

## Generar reporte Serenity

```bash
mvn serenity:aggregate
```

Reporte generado en:

```text
target/site/serenity/index.html
```

Abrir en navegador:

```bash
open target/site/serenity/index.html
```

Windows:

```bash
start target/site/serenity/index.html
```

---

# Ejecución de pruebas API — Karate Framework

## Ejecutar pruebas API

Ejecutar runner Karate:

```bash
mvn test -Dtest=RunnerTest
```

o ejecutar todos los features:

```bash
mvn test
```

---

## Features implementados

### Signup API

Endpoint:

```text
POST https://api.demoblaze.com/signup
```

Escenarios automatizados:

- Crear usuario exitosamente
- Crear usuario ya existente

---

### Login API

Endpoint:

```text
POST https://api.demoblaze.com/login
```

Escenarios automatizados:

- Login exitoso
- Login con credenciales inválidas

---

# Evidencias y reportes

## Serenity Report

Ubicación:

```text
target/site/serenity/index.html
```

---

## Karate Reports

Ubicación:

```text
target/karate-reports/
```

---

# Buenas prácticas implementadas

✔ Screenplay Pattern

✔ Reutilización de componentes

✔ Datos dinámicos usando UUID

✔ Validaciones API desacopladas

✔ Separación UI / API Testing

✔ Maven como gestor de dependencias

---

# Autor

David Zaraza
QA Automation Engineer
