package com.testjpa.entity;

import javax.persistence.*;

@Entity
public class BlogContent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer blogContentId;

    private Integer sequenceNumber;
    private String blogSubHeader;

    @Column(columnDefinition = "TEXT")
    private String blogText;

/*  @ManyToOne(optional = false)
    @JoinColumn(name = "blogId")
    private BlogMeta blogMeta;
*/
    public BlogContent() {}

    public BlogContent(Integer blogContentId,
                       Integer sequenceNumber,
                       String blogSubHeader,
                       String blogText) {
        this.blogContentId = blogContentId;
        this.sequenceNumber = sequenceNumber;
        this.blogSubHeader = blogSubHeader;
        this.blogText = blogText;
    //    this.blogMeta = blogMeta;
    }

    public BlogContent(Integer sequenceNumber,
                       String blogSubHeader,
                       String blogText) {
        this.sequenceNumber = sequenceNumber;
        this.blogSubHeader = blogSubHeader;
        this.blogText = blogText;
    //    this.blogMeta = blogMeta;
    }

    public Integer getBlogContentId() {
        return blogContentId;
    }

    public void setBlogContentId(Integer blogContentId) {
        this.blogContentId = blogContentId;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getBlogSubHeader() {
        return blogSubHeader;
    }

    public void setBlogSubHeader(String blogSubHeader) {
        this.blogSubHeader = blogSubHeader;
    }

    public String getBlogText() {
        return blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

/*    public BlogMeta getBlogMeta() {
        return blogMeta;
    }

    public void setBlogMeta(BlogMeta blogMeta) {
        this.blogMeta = blogMeta;
    }*/
}