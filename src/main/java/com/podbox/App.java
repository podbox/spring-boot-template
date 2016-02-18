package com.podbox;

import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.startup.VersionLoggerListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jmx.support.ConnectorServerFactoryBean;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class App {

    public static void main(final String... args) {
        run(App.class, args);
    }
}
