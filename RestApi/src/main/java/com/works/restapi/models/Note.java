package com.works.restapi.models;

public class Note {

    private Integer nid;
    private String title;
    private String detail;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Note{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
