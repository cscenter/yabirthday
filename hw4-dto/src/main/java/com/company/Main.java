package com.company;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import service.TempDB;
import service.UserApiService;

import java.util.Collections;

public class Main {

    static class Server {
        public Server() throws Exception {
            JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
            sf.setResourceClasses(UserApiService.class);
            sf.setResourceProvider(UserApiService.class,
                    new SingletonResourceProvider(new UserApiService()));
            sf.setAddress("http://localhost:9000/");
            sf.setProviders(Collections.singletonList(new JacksonJsonProvider(new ObjectMapper())));
            sf.create();
        }
}

    public static void main(String[] args) throws Exception {
        new Server();
        System.out.println("Server ready...");

        TempDB.init();

        Thread.sleep(5 * 6000 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
}
