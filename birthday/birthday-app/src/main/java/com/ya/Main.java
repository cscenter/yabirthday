package com.ya;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.spring.SpringResourceFactory;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.inject.Inject;
import javax.ws.rs.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by olya on 07.05.15.
 */

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource({"classpath:META-INF/cxf/cxf.xml", "classpath:META-INF/cxf/cxf-servlet.xml"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Inject
    private ApplicationContext ctx;

    @Bean
    public ServletRegistrationBean cxfServletRegistrationBean() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new CXFServlet(), "/api/*");
        registrationBean.setLoadOnStartup(1);
        registrationBean.setName("CXFServlet");
        return registrationBean;
    }

    @Bean
    public Server jaxRsServer() {
        List<ResourceProvider> resourceProviders = Arrays.stream(ctx.getBeanNamesForAnnotation(Path.class))
                .map(beanName -> {
                    SpringResourceFactory factory = new SpringResourceFactory(beanName);
                    factory.setApplicationContext(ctx);
                    return factory;
                }).collect(Collectors.toList());
        if (resourceProviders.isEmpty()) {
            return null;
        }
        JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
        factory.setBus(ctx.getBean(SpringBus.class));
        JacksonJsonProvider jsonProvider = getJsonProvider();
        factory.setProviders(Collections.singletonList(jsonProvider));
        factory.setResourceProviders(resourceProviders);
        return factory.create();
    }

    private JacksonJsonProvider getJsonProvider() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JSR310Module());
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return new JacksonJsonProvider(mapper);
    }
}
