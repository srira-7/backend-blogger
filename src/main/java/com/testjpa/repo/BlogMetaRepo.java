package com.testjpa.repo;

import com.testjpa.entity.BlogMeta;
import com.testjpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogMetaRepo extends JpaRepository<BlogMeta, Integer> {

    @Query(value = "SELECT bm.* FROM blog_meta bm INNER JOIN users u " +
            "on bm.users_id = u.id WHERE u.username = ?1",
            nativeQuery = true)
    List<BlogMeta> findBlogByUser(String username);

    @Query(value = "SELECT bm.* FROM blog_meta bm WHERE bm.blog_title like %?1% " +
            "or bm.blog_sub_title like %?1% or bm.category like %?1%",
            nativeQuery = true)
    List<BlogMeta> findBlogBySearch(String keyword);
}
