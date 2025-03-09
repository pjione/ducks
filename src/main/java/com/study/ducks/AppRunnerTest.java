package com.study.ducks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Profile({"local", "dev"})
public class AppRunnerTest implements ApplicationRunner {
    private final Environment environment;

    public AppRunnerTest(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void run(ApplicationArguments args) {
        log.info("=================== Property Test ===================");
        log.info("Active profiles : {}", Arrays.toString(environment.getActiveProfiles()));
        log.info("Datasource driver : {}", environment.getProperty("spring.datasource.driver-class-name"));
        log.info("Datasource url : {}", environment.getProperty("spring.datasource.url"));
        log.info("Datasource username : {}", environment.getProperty("spring.datasource.username"));
        log.info("Server Port : {}", environment.getProperty("server.port"));
        log.info("Server url : {}", environment.getProperty("server.url"));
        log.info("=====================================================");
    }
}
