<%--
  Created by IntelliJ IDEA.
  User: Virtue Nguyen
  Date: 10/26/2024
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Phòng Ban</title>
    <style>
        body { font-family: Arial, sans-serif; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { padding: 8px 12px; border: 1px solid #ddd; text-align: left; }
        th { background-color: #f4f4f4; }
    </style>
</head>
<body>
<h2>Danh Sách Phòng Ban</h2>
<a href="phongban?action=addForm">Thêm Phòng Ban Mới</a>
<table>
    <thead>
    <tr>
        <th>Mã Phòng Ban</th>
        <th>Tên Phòng Ban</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="pb" items="${phongBans}">
        <tr>
            <td>${pb.maPhongBan}</td>
            <td>${pb.tenPhongBan}</td>
            <td>
                <a href="phongban?action=delete&id=${pb.maPhongBan}" onclick="return confirm('Bạn có chắc muốn xóa phòng ban này?');">Xóa</a>
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

