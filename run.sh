(
    sudo mvn install -Dmaven.test.skip=true 

    export DB_HOST=localhost:5431
    export DB_USER=postgres
    export DB_PASS=postgres
    export DB_NAME=demo

    mvn test 
    mvn spring-boot:run -e
)