package com.testjpa.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String emailID;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles> roles = new ArrayList<>();

    /*    @OneToMany
        private Collection<BlogMeta> blogMetas = new ArrayList<>();
        @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
        private Collection<BlogMeta> blogMetas = new ArrayList<>();
    */
    public Users(){}

    public Users(Integer id,
                 String username,
                 String firstName,
                 String lastName,
                 String password,
                 String emailID,
                 Collection<Roles> roles) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailID = emailID;
        this.roles = roles;
    //    this.blogMetas = blogs;
    }
    public Users(String username,
                 String firstName,
                 String lastName,
                 String password,
                 String emailID) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailID = emailID;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

 /*   public Collection<BlogMeta> getBlogMetas() {
        return blogMetas;
    }

    public void setBlogMetas(Collection<BlogMeta> blogMetas) {
        this.blogMetas = blogMetas;
    }
  */
}
