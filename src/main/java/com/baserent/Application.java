package com.baserent;

import io.micronaut.context.env.Environment;
import io.micronaut.runtime.Micronaut;
import org.slf4j.LoggerFactory;

public class Application {

    public static void main(String[] args) {
        Micronaut.build(args)
                .mainClass(Application.class)
                .defaultEnvironments(Environment.DEVELOPMENT)
                .start();
    }
}