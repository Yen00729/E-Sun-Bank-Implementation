<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Post</title>
</head>
    <body>

        <form action="comment_form_add_process" method="post">
            <label for="content">內容:</label>
            <input type="text" id="content" name="content" required><br>

            <input type="submit" value="繳交">
        </form>
    </body>
</html>
