<%--
  Created by IntelliJ IDEA.
  User: Virtue Nguyen
  Date: 10/26/2024
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhân Viên</title>
    <style>
        body { font-family: Arial, sans-serif; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 8px 12px; border: 1px solid #ddd; text-align: left; }
        th { background-color: #f4f4f4; }
    </style>
</head>
<body>
<h2>Danh Sách Nhân Viên</h2>
<a href="nhanvien?action=addForm">Thêm Nhân Viên Mới</a>
<table>
    <thead>
    <tr>
        <th>Mã NV</th>
        <th>Tên NV</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Điện thoại</th>
        <th>Phòng Ban</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="nv" items="${nhanViens}">
        <tr>
            <td>${nv.maNV}</td>
            <td>${nv.tenNV}</td>
            <td>${nv.email}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.dienThoai}</td>
            <td>${nv.phongBan.tenPhongBan}</td>
            <td>
                <a href="nhanvien?action=delete&id=${nv.maNV}" onclick="return confirm('Bạn có chắc muốn xóa nhân viên này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="back-button">
    <a href="nhanvien_list.jsp">Quay lại màn hình chính</a>
</div>
</body>
</html>
