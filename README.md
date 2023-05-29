### To start

Build and start each microservice separately from its root build. Default ports are defined in application.properties.
MySQL instance with "signist" scheme should be available on the local machine (as of application.properties). Please provide root password via MYSQL_PASS system variable. Also SINGIST_PATH variable should be define to store local files.
Swagger interface will be available at ${host}:${port}/swagger-ui/index.html.
For the local run follow the [link](http://localhost:7070/swagger-ui/index.html)
