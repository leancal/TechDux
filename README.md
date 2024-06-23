DUX SOFTWARE | PRUEBA TÉCNICA 
=======

## Instrucciones

Podras acceder a la aplicación en http://localhost:8080 

## Swagger
En http://localhost:8080/swagger-ui/index.html observamos la documentación de la aplicación.

### Autenticación
La autenticación se realizo mediante JWT restringiendo el acceso a los endpoints. Por lo tanto antes de utilizar las operaciones debemos iniciar sesión en /auth/login con el siguiente usuario.

```bash
{
  "username": "test",
  "password": "12345"
}
```
Tambien podremos registrar nuestro mismo usuario en /auth/register completando el siguiente body (obligatorios):

```bash
{
  "username": "string",
  "password": "string"
}
```

### Ingresar el token
Debemos copiar el token que nos da como respuesta y colocarlo en el encabezado de autorización(esquina superior derecha). Finalmente ya podemos probar todos los servicios.
```bash
{
  "token": token
}
```

## Base de Datos H2
Las consultas las podemos realizar en http://localhost:8080/h2-console. Iniciando sesión con la configuracion establecida en application.properties.

```bash
{
  JDBC URL: jdbc:h2:mem:testdb
  User Name: sa
  Password: 
}
```
