package ua.social.network;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Mykola Yashchenko
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackageClasses = CommunityQueryServiceApplication.class)
public class CommunityQueryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityQueryServiceApplication.class, args);
    }
}
