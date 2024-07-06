(
    sudo mvn install -Dmaven.test.skip=true 

    export DB_HOST=localhost:5431
    export DB_USER=postgres
    export DB_PASS=postgres
    export DB_NAME=demo

    # mvn test 
    # mvn spring-boot:run -e

    # generate db migration
    liquibase \
        --changeLogFile=changelog.xml \
        --url=jdbc:postgresql://${DB_HOST}/${DB_NAME} \
        --username=${DB_USER} \
        --password=${DB_PASS} \
        --driver=org.postgresql.Driver \
        --defaultSchemaName=${DB_NAME} \
        --diffTypes=data,structure \
        --packages=com.betest.gsolusindo.models
)