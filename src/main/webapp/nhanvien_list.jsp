<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Nhân Viên</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }
        .container {
            width: 80%;
            margin: 20px auto;
            text-align: center;
        }
        .header {
            text-align: right;
            margin-bottom: 20px;
            font-size: 14px;
        }
        .title {
            font-weight: bold;
            font-size: 24px;
            margin-bottom: 20px;
            text-align: center;
        }
        .links {
            text-align: center;
            margin-bottom: 10px;
        }
        .links a {
            text-decoration: none;
            margin-right: 10px;
            color: #007bff;
        }
        .links a:hover {
            text-decoration: underline;
        }
        .back-button {
            text-align: center;
            margin-top: 20px;
        }
        .back-button a {
            text-decoration: none;
            color: #333;
            padding: 8px 16px;
            border: 1px solid #007bff;
            border-radius: 4px;
        }
        .back-button a:hover {
            background-color: #007bff;
            color: #fff;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            border: 1px solid #000;
            padding: 8px 12px;
            text-align: left;
        }
        th {
            background-color: #f0f0f0;
            font-weight: bold;
        }
        .footer {
            text-align: right;
            margin-top: 10px;
            font-style: italic;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="header">
        SoMay-NguyenDucTai-21024541
    </div>

    <div class="links">
        <a href="nhanvien?action=list">Danh sách Nhân Viên</a> |
        <a href="nhanvien?action=addForm">Thêm mới Nhân Viên</a>|
        <a href="phongban?action=list">Danh sách Phòng Ban</a> |
    </div>

    <div class="title">
        DANH SÁCH NHÂN VIÊN
    </div>

    <table>
        <thead>
        <tr>
            <th>Tên phòng ban</th>
            <th>MANV</th>
            <th>Tên NV</th>
            <th>Email</th>
            <th>Địa chỉ</th>
            <th>Điện thoại</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="nv" items="${nhanViens}">
            <tr>
                <td>${nv.phongBan.tenPhongBan}</td>
                <td>${nv.maNV}</td>
                <td>${nv.tenNV}</td>
                <td>${nv.email}</td>
                <td>${nv.diaChi}</td>
                <td>${nv.dienThoai}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="back-button">
        <a href="nhanvien_list.jsp">Quay lại màn hình chính</a>
    </div>

    <div class="footer">
        Tổ
    </div>
</div>

</body>
</html>
