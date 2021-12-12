package com.testjpa.service;

import com.testjpa.entity.*;
import com.testjpa.repo.BlogMetaRepo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public interface ServiceDao {
//    public Users saveUser(Users user);
    public BlogMeta saveBlog(BlogMeta blogMeta);
    public Roles saveRole(Roles role);
    public void addRoleToUser(String username, String roleName);
    public List<BlogMeta> getAllBlogs();
    public List<BlogMeta> getBlogByUser(String username);
    public List<BlogMeta> getBlogBySearch(String keyword);
    //  public BlogDTO savePost();
  //  public Collection<BlogContent> saveBlogContents(BlogContent blogContent);
}
