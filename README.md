# materialtemplate
materialtemplate template para material design
#Execute docker compose
docker-compose up -d

java -jar -Xmx512m target/autentificacion.jar 



Para ejecutar uberjar
java -jar payara-micro-5.2020.4.jar --deploy autentificacion.war --outputUberJar autentificacion.jar



#Crear  el Uberjar
java -jar   /home/avbravo/software/payara/payara-micro-5.2020.4.jar --deploy /home/avbravo/NetBeansProjects/jconfperu/mongodbatlas/target/mongodbatlas.war --outputUberJar /home/avbravo/Descargas/mongodbatlas.jar 


#Subirlo
Subirlo a raspberryPi
scp  mongodbatlas.jar pi@192.168.0.6:/home/pi


#Raspberry Pi
ssh pi@192.168.0.6
password: 

unama -a

uname -m

java -version

#Ejecutarlo
 java -jar -Xmx512m mongodbatlas.jar --nocluster --logo --port 8080









#Ejecutar el war

java -jar -Xmx512m /home/avbravo/software/payara/payara-micro-5.2020.4.jar  --deploy /home/avbravo/NetBeansProjects/jconfperu/mongodbatlas/target/mongodbatlas.war --nocluster --logo --port 9001


JAR

 java -jar -Xmx512m mongodbatlas.jar --nocluster --logo --port 8080

Swagger
http://avbravo:9001/autentificacion/resources/openapi-ui/index.html

#------------------------------------------------------
CREAR EL ARQUETIPO
#-----------------------------------------------------
PASOS:
1.
cd mongodbatlas
2.
mvn archetype:create-from-project

Genera
 Setting default groupId: com.avbravo
[INFO] Setting default artifactId: mongodbatlas
[INFO] Setting default version: 0.1.201
[INFO] Setting default package: com.material
3.
cd target/generated-sources/archetype/

4. ejecutar
mvn install

Genera
 Processing Archetype IT project: basic
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: mongodbatlas-archetype:0.1.201


#----------------------------------------------------------------------------------
CREAR PROYECTO EN BASE AL ARQUETIPO
#--------------------------------------------------------------------------------
PASOS:
Crear proyecto
mkdir webmongo
Entrar
cd webmongo
3 Ejeectuar:

mvn archetype:generate -Dfilter=mongodbatlas-archetype   -DarchetypeVersion=0.1 -DartifactId=nombre-proyecto -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=com.avbravo  -DgroupId=com.avbravo



#-----------------------------------------
# CONECTARSE A MONGODB
#--------------------------------------

#----
Before
#-*------------------------
// <editor-fold defaultstate="collapsed" desc="Boolean beforeSave()">
    public Boolean beforeSave() {
        try {
            //password nuevo no coincide
            if (!usuario.getPassword().equals(passwordnewrepeat)) {
                JsfUtil.warningMessage(rf.getMessage("warning.passwordnocoinciden"));
                return false;
            }
            
            usuario.setRol(rolList);
            usuario.setPassword(JsfUtil.encriptar(usuario.getPassword()));
            return true;
        } catch (Exception e) {
            errorServices.errorMessage(nameOfClass(), nameOfMethod(), e.getLocalizedMessage(), e);
        }
        return false;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean beforeEdit()">
    public Boolean beforeEdit() {
        try {
            usuario.setRol(rolList);
            usuario.setPassword(JsfUtil.encriptar(usuario.getPassword()));
            return true;
        } catch (Exception e) {
            errorServices.errorMessage(nameOfClass(), nameOfMethod(), e.getLocalizedMessage(), e);
        }
        return false;
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Boolean beforeDelete()">
    @Override
    public Boolean beforeDelete() {
        Boolean delete = usuarioServices.isDeleted(usuario);
        if (!delete) {
            JsfUtil.warningDialog(rf.getMessage("warning.advertencia"), rf.getMessage("warning.nosepuedeeliminar"));
        }
        return delete;
    }

    // </editor-fold>     
    // <editor-fold defaultstate="collapsed" desc="Boolean beforeDeleteFromListXhtml()">
    @Override
    public Boolean beforeDeleteFromListXhtml() {
        Boolean delete = usuarioServices.isDeleted(usuario);
        if (!delete) {
            JsfUtil.warningDialog(rf.getMessage("warning.advertencia"), rf.getMessage("warning.nosepuedeeliminar"));
        }
        return delete;
    }

    // </editor-fold>