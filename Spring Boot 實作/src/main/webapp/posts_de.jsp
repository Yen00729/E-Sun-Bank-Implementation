<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Posts</title>
    <h1>User Name: ${loggedInUser.user_name}</h1>
    <button onclick="location.href='logout'">Logout</button>
    <button onclick="location.href='posts'">Posts</button>
    <button onclick="location.href='posts_user'">User Posts</button>
</head>
<body>

<h2>Post</h2>

<table border="1">
    <thead>
        <tr>
            <th>Post ID</th>
            <th>User ID</th>
            <th>Content</th>
            <th>Created At</th>
        </tr>
    </thead>
    <tbody>
        
        <tr>
            <td>${post.postId}</td>
            <td>${post.userId}</td>
            <td>${post.content}</td>
            <td>${post.createdAt}</td>
        </tr>

    </tbody>

</table>

<table  border="1">
    <tbody>
        <tr>
            <!-- 評論 -->
            <td>
                <form action="comment_form_add_process" method="post">
                    <input type="hidden" id="post_id" name="post_id" value="${post.postId}">
                    <label for="content">內容:</label>
                    <input type="text" id="content" name="content" required>
                    <input type="submit" value="繳交">
                </form>
            </td>
        </tr>
        <tr>
            <th>Post ID</th>
            <th>User ID</th>
            <th>Content</th>
            <th>Created At</th>
        </tr>
        <tr>
            <c:forEach var="comment" items="${allComments}">
                <tr>
                    <td>${comment.commentId}</td>
                    <td>${comment.postId}</td>
                    <td>${comment.content}</td>
                    <td>${comment.createdAt}</td>
                </tr>
            </c:forEach>
        </tr>
    </tbody>
</table>

</body>
</html>
