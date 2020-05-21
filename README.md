# Api test Desarrollo


# Back End Api Test
Servicio correspondiente al backend

## Variables de entorno
	export PORT=8080

## Compilar y generar el ensamblado
    Gradle : ./gradlew build
    Test   : java -jar build/libs/test-desarrollo-0.0.1-SNAPSHOT.jar

URL: http://localhost:8080/api/people

# Json para crear Persona

{
	"name": "Nombre",
	"lastName": "ApellidoPaterno ApellidoMaterno",
    "dateOfBirth": "2010-01-09"
}
