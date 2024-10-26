<%--
  Created by IntelliJ IDEA.
  User: Virtue Nguyen
  Date: 10/26/2024
  Time: 7:46 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm Nhân Viên</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .form-container { max-width: 400px; margin: auto; padding: 20px; border: 1px solid #ddd; background-color: #f9f9f9; }
        .form-group { margin-bottom: 15px; }
        .form-group label { display: block; margin-bottom: 5px; }
        .form-group input, .form-group select { width: 100%; padding: 8px; }
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
    <h2>Thêm Nhân Viên Mới</h2>
    <form action="nhanvien" method="post">
        <div class="form-group">
            <label for="tenNV">Tên NV:</label>
            <input type="text" id="tenNV" name="tenNV" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="diaChi">Địa chỉ:</label>
            <input type="text" id="diaChi" name="diaChi" required>
        </div>
        <div class="form-group">
            <label for="dienThoai">Điện thoại:</label>
            <input type="text" id="dienThoai" name="dienThoai" required>
        </div>
        <div class="form-group">
            <label for="maPhongBan">Phòng Ban:</label>
            <select id="maPhongBan" name="maPhongBan" required>
                <c:forEach var="pb" items="${phongBanList}">
                    <option value="${pb.maPhongBan}">${pb.tenPhongBan}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Thêm Nhân Viên</button>
    </form>
    <div class="back-button">
        <a href="nhanvien_list.jsp">Quay lại màn hình chính</a>
    </div>
</div>

</body>
</html>
