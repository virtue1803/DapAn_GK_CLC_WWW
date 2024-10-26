package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.repositories;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.NhanVien;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.PhongBan;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.util.HibernateUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienRepository {

    private static final Logger logger = Logger.getLogger(NhanVienRepository.class.getName());

    public List<NhanVien> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        List<NhanVien> nhanViens = null;
        try {
            nhanViens = em.createQuery("FROM NhanVien", NhanVien.class).getResultList();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error finding all NhanVien", e);
        } finally {
            em.close();
        }
        return nhanViens;
    }

    public void save(NhanVien nhanVien) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            // Kiểm tra nếu phongBan của NhanVien là một entity đã tồn tại, thì dùng merge thay vì persist
            if (nhanVien.getPhongBan() != null) {
                PhongBan phongBan = em.find(PhongBan.class, nhanVien.getPhongBan().getMaPhongBan());
                if (phongBan != null) {
                    nhanVien.setPhongBan(em.merge(phongBan));  // Sử dụng merge nếu phongBan đã tồn tại
                } else {
                    em.persist(nhanVien.getPhongBan()); // Chỉ persist nếu phongBan chưa tồn tại
                }
            }

            em.persist(nhanVien);  // Thêm mới nhanVien sau khi đảm bảo PhongBan đã được xử lý
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw e;  // Có thể log lỗi và xử lý thêm nếu cần
        } finally {
            em.close();
        }
    }


    public void delete(String maNV) {
        EntityManager em = HibernateUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            NhanVien nhanVien = em.find(NhanVien.class, maNV);
            if (nhanVien != null) {
                em.remove(nhanVien);
            }
            transaction.commit();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error deleting NhanVien by ID", e);
            if (transaction.isActive()) transaction.rollback();
        } finally {
            em.close();
        }
    }
}

