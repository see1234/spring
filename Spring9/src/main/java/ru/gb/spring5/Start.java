package ru.gb.spring5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class Start {

    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("1",r->r.path("/1/**")
                        .uri("http://localhost:8081/"))
                .route("2",r->r.path("/2/**")
                        .uri("http://localhost:8082/"))
                .route("3",r->r.path("/3/**")
                        .uri("http://localhost:8083/")).build();
    }
}
