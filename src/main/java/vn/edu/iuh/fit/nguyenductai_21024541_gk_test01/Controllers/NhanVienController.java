package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.NhanVien;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.PhongBan;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.services.NhanVienService;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.services.PhongBanService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/nhanvien")
public class NhanVienController extends HttpServlet {

    private final NhanVienService nhanVienService = new NhanVienService();
    private final PhongBanService phongBanService = new PhongBanService();
    private static final Logger logger = Logger.getLogger(NhanVienController.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("delete".equals(action)) {
                String maNV = req.getParameter("id");
                nhanVienService.deleteNhanVien(maNV);
                resp.sendRedirect("nhanvien?action=list");
            } else if ("addForm".equals(action)) {
                List<PhongBan> phongBanList = phongBanService.getAllPhongBan();
                req.setAttribute("phongBanList", phongBanList);
                RequestDispatcher dispatcher = req.getRequestDispatcher("nhanvien/add.jsp");
                dispatcher.forward(req, resp);
            } else {
                List<NhanVien> nhanViens = nhanVienService.getAllNhanVien();
                req.setAttribute("nhanViens", nhanViens);
                RequestDispatcher dispatcher = req.getRequestDispatcher("nhanvien_list.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error processing request", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error occurred");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenNV = req.getParameter("tenNV");
        String email = req.getParameter("email");
        String diaChi = req.getParameter("diaChi");
        String dienThoai = req.getParameter("dienThoai");
        String maPhongBan = req.getParameter("maPhongBan");

        try {
            PhongBan phongBan = phongBanService.getPhongBanById(maPhongBan);
            if (phongBan != null) {
                NhanVien nhanVien = new NhanVien(tenNV, email, diaChi, dienThoai, phongBan);
                nhanVienService.addNhanVien(nhanVien);
            } else {
                logger.log(Level.WARNING, "Phòng ban không tồn tại: " + maPhongBan);
            }
            resp.sendRedirect("nhanvien?action=list");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error adding new NhanVien", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error occurred");
        }
    }
}
