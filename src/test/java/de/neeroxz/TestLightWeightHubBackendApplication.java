package de.neeroxz;

import org.springframework.boot.SpringApplication;

public class TestLightWeightHubBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(LightWeightHubBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
