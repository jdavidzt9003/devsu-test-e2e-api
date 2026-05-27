# Conclusiones y Hallazgos

## Conclusiones

Durante el desarrollo del ejercicio se implementó una estrategia de automatización híbrida que combina **pruebas UI con Serenity BDD** y **pruebas API con Karate Framework**, permitiendo validar funcionalidades desde diferentes capas de la aplicación.

Las principales conclusiones obtenidas fueron:

- La automatización de **UI y API** proporciona mayor cobertura funcional y permite identificar fallos en distintas capas del sistema.

- El uso de **Serenity BDD bajo el patrón Screenplay** favorece la mantenibilidad, legibilidad y reutilización del código automatizado.

- **Karate Framework** simplifica significativamente la automatización de APIs gracias a su sintaxis declarativa, reduciendo la cantidad de código requerida para validar endpoints REST.

- La generación de **datos dinámicos mediante UUID** resultó necesaria para evitar dependencias entre ejecuciones y minimizar falsos negativos asociados a datos persistentes.

- La integración con **Maven** permitió centralizar la ejecución, dependencias y generación de reportes de forma consistente.

---

## Hallazgos encontrados

Durante la ejecución y automatización se identificaron algunos comportamientos relevantes del servicio DemoBlaze:

### 1. Respuesta inconsistente en endpoint Signup

Endpoint evaluado:

```text
POST /signup
```

Se identificó que la respuesta exitosa del servicio no retorna un objeto JSON estándar.

Comportamiento observado:

```text
""
```

Adicionalmente, en algunas ejecuciones se evidenció la presencia de caracteres de salto de línea (`\n`) dentro de la respuesta.

Esto obligó a ajustar las validaciones en Karate utilizando normalización de respuesta (`trim()`), evitando fallos por diferencias de formato.

---

### 2. Dependencia de datos persistidos para Login

Endpoint evaluado:

```text
POST /login
```

Para validar un login exitoso fue necesario crear previamente un usuario válido, debido a que el endpoint depende de usuarios existentes en el sistema.

Como estrategia de automatización se implementó:

- Creación dinámica de usuario.
- Ejecución posterior del login.
- Validación del token de autenticación retornado.

Esto reduce dependencias manuales y mejora la independencia de las pruebas.

---

### 3. Mensajería de error basada en lógica interna del servicio

Se observó que algunos escenarios negativos retornan mensajes específicos del backend, por ejemplo:

```json
{
  "errorMessage": "This user already exist."
}
```

y

```json
{
  "errorMessage": "Wrong password."
}
```

Las validaciones fueron construidas considerando la respuesta real del API.

---

### 4. Importancia de la inspección temprana de respuestas

Durante la implementación de Karate se evidenció la necesidad de inspeccionar las respuestas reales utilizando:

```gherkin
* print response
```

Esta práctica permitió identificar diferencias entre:

- String vacío
- JSON vacío
- Strings serializados
- Caracteres ocultos

reduciendo tiempos de depuración.

---

## Mejoras futuras

Como evolución del ejercicio podrían implementarse las siguientes mejoras:

- Externalización de datos de prueba mediante archivos JSON o CSV.
- Manejo de ambientes mediante variables (`dev`, `qa`, `prod`).
- Integración con pipeline CI/CD (GitHub Actions, Jenkins o GitLab CI).
- Ejecución paralela de pruebas.
- Integración con herramientas de visual testing y cloud execution (Percy / BrowserStack).
- Generación consolidada de reportes UI + API.

---

## Resultado general

El ejercicio permitió validar exitosamente:

### UI Automation

✔ Navegación y validaciones funcionales usando Serenity BDD.

### API Automation

✔ Signup exitoso.

✔ Validación de usuario existente.

✔ Login exitoso.

✔ Login con credenciales inválidas.

El resultado final evidencia una implementación funcional de automatización QA aplicando buenas prácticas de diseño, reutilización y validación automatizada.