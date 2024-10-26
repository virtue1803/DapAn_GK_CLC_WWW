<%--
  Created by IntelliJ IDEA.
  User: Virtue Nguyen
  Date: 10/26/2024
  Time: 7:46 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm Phòng Ban</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .form-container { max-width: 400px; margin: auto; padding: 20px; border: 1px solid #ddd; background-color: #f9f9f9; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; }
        .form-group input { width: 100%; padding: 8px; }
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
    </style>
</head>
<body>
<div class="form-container">
    <h2>Thêm Phòng Ban Mới</h2>
    <form action="phongban" method="post">
        <div class="form-group">
            <label for="tenPhongBan">Tên Phòng Ban:</label>
            <input type="text" id="tenPhongBan" name="tenPhongBan" required>
        </div>
        <button type="submit">Thêm Phòng Ban</button>
    </form>
    <div class="back-button">
        <a href="index.jsp">Quay lại màn hình chính</a>
    </div>
</div>
<div class="back-button">
    <a href="nhanvien_list.jsp">Quay lại màn hình chính</a>
</div>
</body>
</html>
