package com.maurofokker.poc.cloud;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class SpringMicroservicesEurekaClient2Application {

    @Autowired
    private EurekaClient client; // in order to access information about different instances within eureka server
    // when a service register with the eureka server, first it registered in that server and it can query other
    // services within that server
    // when it queries to one of those services get an instance of that service

    @RequestMapping("/serviceinfo")
    public String serviceInfo() {
        // first parameter is the name of the instance in eureka server (remember spring.application.name)
        // second parameter if we want to recover in a secure mode
        InstanceInfo instanceInfo = client.getNextServerFromEureka("myClient", false);
        return instanceInfo.getHomePageUrl();
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringMicroservicesEurekaClient2Application.class, args);
    }
}
