package vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.entities.PhongBan;
import vn.edu.iuh.fit.nguyenductai_21024541_gk_test01.services.PhongBanService;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/phongban")
public class PhongBanController extends HttpServlet {

    private final PhongBanService phongBanService = new PhongBanService();
    private static final Logger logger = Logger.getLogger(PhongBanController.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        try {
            if ("addForm".equals(action)) {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/phongban/add.jsp");
                dispatcher.forward(req, resp);
            } else if ("delete".equals(action)) {
                String maPhongBan = req.getParameter("id");
                phongBanService.deletePhongBan(maPhongBan);
                resp.sendRedirect("phongban");
            } else {
                List<PhongBan> phongBans = phongBanService.getAllPhongBan();
                req.setAttribute("phongBans", phongBans);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/phongban/list.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error processing PhongBan request", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error occurred");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenPhongBan = req.getParameter("tenPhongBan");

        try {
            PhongBan phongBan = new PhongBan(tenPhongBan);
            phongBanService.addPhongBan(phongBan);
            resp.sendRedirect("phongban");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error adding new PhongBan", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error occurred");
        }
    }
}
