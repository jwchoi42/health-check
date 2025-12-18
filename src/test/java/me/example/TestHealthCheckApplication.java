package me.example;

import org.springframework.boot.SpringApplication;

public class TestHealthCheckApplication {

    public static void main(String[] args) {
        SpringApplication.from(HealthCheckApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
