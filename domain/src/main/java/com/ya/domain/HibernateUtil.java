package com.ya.domain;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.io.File;


/**
 * Created by MAX on 13.04.2015.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    static {
        sessionFactory = buildSessionFactory();
    }

    private static SessionFactory buildSessionFactory() {
/*
        File directory = new File (".");
        try {
            System.out.println ("Current directory's canonical path: "
                    + directory.getCanonicalPath());
            System.out.println ("Current directory's absolute  path: "
                    + directory.getAbsolutePath());
        }catch(Exception e) {
            System.out.println("Exceptione is ="+e.getMessage());
        }
*/

        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure(new File("domain/src/main/java/hibernate.cfg.xml")).buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
