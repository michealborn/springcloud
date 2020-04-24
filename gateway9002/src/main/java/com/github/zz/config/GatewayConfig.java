package com.github.zz.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator myRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("javaRoutes1",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"));
//        routes.route("websocketRoute",r -> r.path("lb://payment").)

        /*routes.route("websocket_route",
                r -> r.path("/apitopic1/**")
                        .uri("ws://127.0.0.1:6605"));
        routes.route(r -> r.path("/userapi3/**")
                        .filters(f -> f.addResponseHeader("X-AnotherHeader", "testapi3"))
                        .uri("lb://user-service/"));*/

        RouteLocator routeLocator = routes.build();
        return routeLocator;
    }
}
