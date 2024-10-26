package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.util;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("GK_Test01");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        if (emf != null) {
            emf.close();
        }
    }
}

