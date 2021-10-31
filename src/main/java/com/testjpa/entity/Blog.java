package com.testjpa.entity;


import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Integer id;
    private String blogTitle;
    private String blogText;

    @ManyToOne
    private Users users;

    public Blog(Integer id, String blogTitle, String blogText, Users users) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.blogText = blogText;
        this.users = users;
    }

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}

