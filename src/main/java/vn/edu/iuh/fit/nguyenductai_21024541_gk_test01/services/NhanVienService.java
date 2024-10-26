package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.services;

import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.NhanVien;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.repositories.NhanVienRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhanVienService {

    private final NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private static final Logger logger = Logger.getLogger(NhanVienService.class.getName());

    public List<NhanVien> getAllNhanVien() {
        try {
            return nhanVienRepository.findAll();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error fetching all NhanVien", e);
            return null;
        }
    }

    public void addNhanVien(NhanVien nhanVien) {
        try {
            nhanVienRepository.save(nhanVien);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error adding NhanVien", e);
        }
    }

    public void deleteNhanVien(String maNV) {
        try {
            nhanVienRepository.delete(maNV);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error deleting NhanVien with ID: " + maNV, e);
        }
    }
}