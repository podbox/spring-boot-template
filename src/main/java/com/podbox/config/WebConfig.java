package com.podbox.config;

import org.apache.catalina.core.AprLifecycleListener;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
class WebConfig extends WebMvcConfigurerAdapter {

    @Bean
    @Profile("prod")
    ConnectorServerFactoryBean serverConnector() {
        return new ConnectorServerFactoryBean();
    }

    @Bean
    @Profile("prod")
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer() {
        final AprLifecycleListener aprLifecycleListener = new AprLifecycleListener();
        aprLifecycleListener.setSSLEngine("off");

        return container -> {
            final TomcatEmbeddedServletContainerFactory tomcatContainer = (TomcatEmbeddedServletContainerFactory) container;
            tomcatContainer.addContextLifecycleListeners(aprLifecycleListener);
            tomcatContainer.setProtocol("HTTP/1.1");
        };
    }

    @Bean
    @Profile("prod")
    ShallowEtagHeaderFilter etagFilter() {
        return new ShallowEtagHeaderFilter();
    }
}
