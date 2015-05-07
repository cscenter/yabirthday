package com.ya.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by olya on 07.05.15.
 */
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
