package com.example;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import service.TempDB;
import service.UserApiService;

public class Server {

    protected Server() throws Exception {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(UserApiService.class);
        sf.setResourceProvider(UserApiService.class,
                new SingletonResourceProvider(new UserApiService()));
        sf.setAddress("http://localhost:9000/");

        sf.create();
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
