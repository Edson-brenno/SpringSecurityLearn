package com.spring.Config;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;

/**
 * This class is responsible to implement the strategy of the flyway migrations
 * With this it'll avoid errors on new migrations cause of the migrations versions*/
public class FlywayMigrationConfig {

    public FlywayMigrationStrategy migrationStrategy() {
        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };
    }
}
