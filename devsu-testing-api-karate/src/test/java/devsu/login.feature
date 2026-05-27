Feature: Login API DemoBlaze

  Background:
    * url baseUrl
    * header Content-Type = 'application/json'

  Scenario: Login exitoso

    # Usuario único
    * def username = 'user_' + java.util.UUID.randomUUID()
    * def password = 'Password123'

    # Crear usuario
    Given path 'signup'
    And request
    """
  {
  "username": "#(username)",
  "password": "#(password)"
  }
  """
    When method POST
    Then status 200

    # Login
    Given path 'login'
    And request
    """
  {
  "username": "#(username)",
  "password": "#(password)"
  }
  """
    When method POST
    Then status 200

    * print response
    And match response contains 'Auth_token'

  Scenario: Login usuario o password incorrecto

    Given path 'login'
    And request
    """
  {
  "username": "usuario_fake",
  "password": "password_fake"
  }
  """
    When method POST
    Then status 200

    * print response
    And match response.errorMessage == 'User does not exist.'