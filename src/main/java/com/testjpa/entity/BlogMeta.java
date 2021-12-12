package com.testjpa.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
public class BlogMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer blogId;
    private String blogTitle;
    private String blogSubTitle;

    @Temporal(TemporalType.DATE)
    private Date publishedDate;

    private String Category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users users;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "blogId")
    private Collection<BlogContent> blogContent = new ArrayList<>();

    public BlogMeta(){}

    public BlogMeta(String blogTitle,
                    String blogSubTitle,
                    Date publishedDate,
                    String category,
                    Users users,
                    Collection<BlogContent> blogContent) {
        this.blogTitle = blogTitle;
        this.blogSubTitle = blogSubTitle;
        this.publishedDate = publishedDate;
        this.Category = category;
        this.users = users;
        this.blogContent = blogContent;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogSubTitle() {
        return blogSubTitle;
    }

    public void setBlogSubTitle(String blogSubTitle) {
        this.blogSubTitle = blogSubTitle;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Collection<BlogContent> getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(Collection<BlogContent> blogContent) {
        this.blogContent = blogContent;
    }

}