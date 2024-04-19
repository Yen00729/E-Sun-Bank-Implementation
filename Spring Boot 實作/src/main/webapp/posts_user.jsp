<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>User Posts</title>
        <h1>User Name: ${loggedInUser.user_name}</h1>
        <button onclick="location.href='logout'">Logout</button>
        <button onclick="location.href='posts'">Posts</button>
        <button onclick="location.href='posts_user'">User Posts</button>
    </head>
    <body>

        <h2>User Posts</h2>

        <!-- 新增文章 -->
        <button onclick="location.href='posts_add'">新增文章</button>

        <table border="1">
            <thead>
                <tr>
                    <th>Post ID</th>
                    <th>User ID</th>
                    <th>Content</th>
                    <th>Created At</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="post" items="${allPosts}">
                    <tr>
                        <td>${post.postId}</td>
                        <td>${post.userId}</td>
                        <td>${post.content}</td>
                        <td>${post.createdAt}"></td>
                        <td>
                            <button onclick="window.location.href = 'posts_edit?post_id=${post.postId}'">修改</button>
                        </td>
                        <td>
                            <form method="post" action="posts_delete">
                                <input type="hidden" name="post_id" value="${post.postId}">
                                <button type="submit" class="button-link">刪除</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
