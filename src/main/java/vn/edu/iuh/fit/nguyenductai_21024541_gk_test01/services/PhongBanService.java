package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.services;

import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.PhongBan;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.repositories.PhongBanRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhongBanService {

    private final PhongBanRepository phongBanRepository = new PhongBanRepository();
    private static final Logger logger = Logger.getLogger(PhongBanService.class.getName());

    public List<PhongBan> getAllPhongBan() {
        try {
            return phongBanRepository.findAll();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error fetching all PhongBan", e);
            return null;
        }
    }

    public PhongBan getPhongBanById(String maPhongBan) {
        try {
            return phongBanRepository.findById(maPhongBan);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error fetching PhongBan by ID: " + maPhongBan, e);
            return null;
        }
    }

    public void addPhongBan(PhongBan phongBan) {
        try {
            phongBanRepository.save(phongBan);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error adding PhongBan", e);
        }
    }

    public void deletePhongBan(String maPhongBan) {
        try {
            phongBanRepository.deleteById(maPhongBan);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error deleting PhongBan with ID: " + maPhongBan, e);
        }
    }
}
