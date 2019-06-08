package com.gzq.entity;

public class ShortSlogan {
    private Long id;

    private String secondTitle;

    private Integer status;

    private String firstTitle;

    private String href;

    private String src;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle == null ? null : secondTitle.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getFirstTitle() {
        return firstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        this.firstTitle = firstTitle == null ? null : firstTitle.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    @Override
    public String toString() {
        return "ShortSlogan{" +
                "id=" + id +
                ", secondTitle='" + secondTitle + '\'' +
                ", status=" + status +
                ", firstTitle='" + firstTitle + '\'' +
                ", href='" + href + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}