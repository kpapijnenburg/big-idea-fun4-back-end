package fitnessapp.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            try {
                // Create new registry with StandardServiceRegistry
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

                // Create meta sources
                MetadataSources sources = new MetadataSources(registry);

                Metadata metadata = sources.getMetadataBuilder()
                        .build();

                // Create session factory
                sessionFactory = metadata.getSessionFactoryBuilder()
                        .build();
            } catch (Exception e){
                e.printStackTrace();

                // If a registry is made but the session creation failed
                // it needs to be destroyed.
                if (registry != null){
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }

        }

        return sessionFactory;

    }

    public void shutdown(){
        if (sessionFactory != null) {
            getSessionFactory().close();
        }

    }
}