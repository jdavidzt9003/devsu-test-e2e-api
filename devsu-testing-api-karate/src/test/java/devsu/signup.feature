Feature: Validación servicio Signup DemoBlaze

  Background:
    * url baseUrl
    * header Content-Type = 'application/json'

  Scenario: Crear un usuario exitosamente
    * def randomUser = 'user_' + java.util.UUID.randomUUID()

    Given path '/signup'
    And request
    """
    {
      "username": "#(randomUser)",
      "password": "Password123"
    }
    """
    When method POST
    Then status 200
    And match response contains '""'

  Scenario: Crear un usuario que ya existe

    * def existingUser = 'usuario_existente_qa'

    # Crear usuario por primera vez
    Given path '/signup'
    And request
    """
    {
      "username": "#(existingUser)",
      "password": "Password123"
    }
    """
    When method POST

    # Intentar crearlo nuevamente
    Given path '/signup'
    And request
    """
    {
      "username": "#(existingUser)",
      "password": "Password123"
    }
    """
    When method POST
    Then status 200
    And match response.errorMessage == 'This user already exist.'