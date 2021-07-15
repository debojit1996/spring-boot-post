package com.debo.springbootpost.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class DataSetupService implements CommandLineRunner {

    @Value("classpath:init/init.sql")
    private Resource initResource;

    private final R2dbcEntityTemplate entityTemplate;

    @Override
    public void run(String... args) throws IOException {
        var query = StreamUtils.copyToString(initResource.getInputStream(), StandardCharsets.UTF_8);
        log.info("********** ".concat(query).concat(" **********"));

        this.entityTemplate
                .getDatabaseClient()
                .sql(query)
                .then()
                .subscribe();
    }
}
