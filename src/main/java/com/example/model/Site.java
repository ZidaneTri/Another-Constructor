package com.example.model;

import javax.persistence.*;


@Entity
@Table(name = "site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private long siteId;

    @Column
    private String siteName;

    @Column
    private String content;

    @Column
    private long idUser;

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public long getSiteId() {
        return siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
}

