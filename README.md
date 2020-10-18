# materialtemplate
materialtemplate template para material design
#Execute docker compose
docker-compose up -d

java -jar -Xmx512m target/autentificacion.jar 



Para ejecutar uberjar
java -jar payara-micro-5.2020.4.jar --deploy autentificacion.war --outputUberJar autentificacion.jar

#Crear  el Uberjar
java -jar   /home/avbravo/software/payara/payara-micro-5.2020.4.jar --deploy /home/avbravo/NetBeansProjects/jconfperu/mongodbatlas/target/mongodbatlas.war --outputUberJar /home/avbravo/Descargas/mongodbatlas.jar 


subirlo a raspberryPi
scp  mongodbatlas.jar pi@192.168.0.5:/home/pi




#Ejecutar el war

java -jar -Xmx512m /home/avbravo/software/payara/payara-micro-5.2020.4.jar  --deploy /home/avbravo/NetBeansProjects/jconfperu/mongodbatlas/target/mongodbatlas.war --nocluster --logo --port 9001


JAR

 java -jar -Xmx512m mongodbatlas.jar --nocluster --logo --port 8080

Swagger
http://avbravo:9001/autentificacion/resources/openapi-ui/index.html