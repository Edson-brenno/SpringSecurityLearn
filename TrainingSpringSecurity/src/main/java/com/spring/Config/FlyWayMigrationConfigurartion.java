package com.spring.Config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlyWayMigrationConfigurartion {
    @Bean
    public FlywayMigrationStrategy flywayMigrationStrategy(){
        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };
    }
}
