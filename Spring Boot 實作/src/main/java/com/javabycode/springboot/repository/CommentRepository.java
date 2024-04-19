package com.javabycode.springboot.repository;

import com.javabycode.springboot.model.comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<comment, Long> {  // 使用驼峰命名法并修正类名

    @Query(value = "SELECT * FROM comment WHERE post_id = :postId", nativeQuery = true)  // 使用实体属性名而非数据库列名
    List<comment> findByPostId(@Param("postId") int postId);  // 方法名遵循 JavaBeans 命名规范
    
}
// @Repository
// public interface CommentRepository extends JpaRepository<comment, Long> {
    
//         @Query("SELECT c FROM comment c WHERE c.post_id = :postId")
//         List<comment> findByPost_id(@Param("postId") int post_id);

// }
