package com.javabycode.springboot.repository;

import com.javabycode.springboot.model.posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<posts, Integer> {
    
    @Query(value = "SELECT * FROM posts WHERE post_id = :postId", nativeQuery = true)
    posts findByPostId(@Param("postId") int postId);

    @Query(value = "SELECT * FROM posts WHERE user_id = :userId", nativeQuery = true)
    List<posts> findByUserId(@Param("userId") int userId);

}

// @Repository
// public interface PostsRepository extends JpaRepository<posts, Long> { // 使用改进后的类名和合适的泛型参数类型

//     posts findByPostId(int postId); 

//     List<posts> findByUserId(int userId); 

//     void deleteByPostId(int postId);
// }



