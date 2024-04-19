<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Post</title>
</head>
    <body>

        <form action="posts_edit_process" method="post">
            <label for="content">內容:</label>
            <input type="hidden" id="post_id" name="post_id" value="${post.postId}">
            <input type="text" id="content" name="content" required value="${post.content}"><br>

            <input type="submit" value="繳交">
        </form>
    </body>
</html>
