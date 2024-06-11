# devsuTechChallenge
- En este proyecto se aplicó una arquitectura hexagonal, buscando tener arquitecturas más limpias en nuestros desarrollos.
- Se aplican los principios SOLID impulsando a un código más legible, autodescriptivo y fácil de mantener (de forma didáctica).
- En este fichero en la rama máster se podrá acceder a toda la información, ya que la rama main no debe tener commits ni push directos. A menos que sea un hotfix.
- Por temas de tiempo, se utilizó una base de datos Bootstrap H2
- El microservicio Person/Customer se ejecuta en el puerto 8080
- El microservicio Account/Transactions se ejecuta en el puerto 8081
- Toda la programación está en inglés a excepción de los endpoints y mensajes de error solicitados en español. Lo correcto sería tener un fichero de traducciones y trabajar de forma homogénea en un solo idioma.

## Collections en Postman
- Se agrega en cada microservicio en el fichero "resources/PostmanCollections" con la información para probar y testear a modo de integraciones los microservicios.

## DokerFile
- Se agrega en cada microservicio el Dockerfile para poder levantar la aplicación.
- Ejecutar en el siguiente orden:
- docker build -t "services-fbernal" #Construye la imagen
- docker run --name services-fbernal -p 8080:8080 -p 8081:8081 services-fbernal:latest #Levanta los servicios, mapeando los puertos del host local con el de docker

## Documentación Swagger
- Quedó incompleta por temas de tiempo, hubo inconvenientes con las nuevas anotaciones de la versión compatible con JAVA 17.
- Actualmente trabajo en Groovy basado en Spring y algunas anotaciones y dependencias debo seguirlas revisando.
