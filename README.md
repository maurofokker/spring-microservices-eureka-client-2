# Eureka client

* created just like the [spring-microservices-eureka-client](https://github.com/maurofokker/spring-microservices-eureka-client) 
* this project is created to learn about discovery between clients 
* add a rest endpoint `/serviceinfo` to test client integration
* inject `EurekaClient` object to get info of instances registered in eureka server
* change application properties (like the port because default one is being occupied by client 1)
* after run the app and check that is registered in eureka server check the url `http://localhost:8888/serviceinfo` and client 1 address info is displayed