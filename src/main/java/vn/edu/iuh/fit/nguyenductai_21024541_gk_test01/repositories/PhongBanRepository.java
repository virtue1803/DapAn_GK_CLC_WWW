package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.repositories;

import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.PhongBan;
import jakarta.persistence.EntityManager;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.util.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhongBanRepository {
    private static final Logger logger = Logger.getLogger(PhongBanRepository.class.getName());

    public List<PhongBan> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        List<PhongBan> phongBans = null;
        try {
            phongBans = em.createQuery("SELECT p FROM PhongBan p", PhongBan.class).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error finding all PhongBan", e);
        } finally {
            em.close();
        }
        return phongBans;
    }

    public PhongBan findById(String maPhongBan) {
        EntityManager em = HibernateUtil.getEntityManager();
        PhongBan phongBan = null;
        try {
            phongBan = em.find(PhongBan.class, maPhongBan);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error finding PhongBan by ID", e);
        } finally {
            em.close();
        }
        return phongBan;
    }

    public void save(PhongBan phongBan) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(phongBan);
            transaction.commit();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error saving PhongBan", e);
            if (transaction.isActive()) transaction.rollback();
        } finally {
            em.close();
        }
    }

    public void deleteById(String maPhongBan) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            PhongBan phongBan = em.find(PhongBan.class, maPhongBan);
            if (phongBan != null) {
                em.remove(phongBan);
            }
            transaction.commit();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error deleting PhongBan by ID", e);
            if (transaction.isActive()) transaction.rollback();
        } finally {
            em.close();
        }
    }
}

