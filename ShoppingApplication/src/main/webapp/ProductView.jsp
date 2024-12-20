<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    .content {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        width: 300px;
    }
    h1 {
        text-align: center;
        color: #333333;
        font-size: 24px;
        margin-bottom: 20px;
    }
    label {
        font-size: 14px;
        color: #555555;
        display: block;
        margin-bottom: 5px;
    }
    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 15px;
        border: 1px solid #cccccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
<meta charset="UTF-8">
<title>Product Page</title>
</head>
<body>
<form action="ProductController" method="post">
    <div class="content">
        <h1>Product Page</h1>
        <label for="pid">Product Id:</label>
        <input type="text" name="pid" id="pid">

        <label for="pname">Product Name:</label>
        <input type="text" name="pname" id="pname">

        <label for="pprice">Product Price:</label>
        <input type="text" name="pprice" id="pprice">

        <label for="pqty">Product Quantity:</label>
        <input type="text" name="pqty" id="pqty">

        <input type="submit" value="Save">
    </div>
</form>
</body>
</html>
