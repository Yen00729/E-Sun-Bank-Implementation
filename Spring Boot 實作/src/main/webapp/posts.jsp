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

<h2>All Posts</h2>

<table border="1">
    <thead>
        <tr>
            <th>Post ID</th>
            <th>User ID</th>
            <th>Content</th>
            <th>Created At</th>
            <th>詳細內容</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="post" items="${allPosts}">
            <tr>
                <td>${post.postId}</td>
                <td>${post.userId}</td>
                <td>${post.content}</td>
                <td>${post.createdAt}</td>
                <td>
                    <button onclick="window.location.href = 'posts_detail?post_id=${post.postId}'">詳細內容</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
