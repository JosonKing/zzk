package com.zphzs.zzk.pojo;

import java.sql.Timestamp;

/**
 * Created by root5 on 2017/8/24.
 */
public class ExpenseAccount {
    private Integer id;
    private String name;
    private String type;
    private Timestamp time;
    private String desc;
    private String photo;

    public ExpenseAccount() {
    }

    public ExpenseAccount(Integer id, String name, String type, Timestamp time, String desc, String photo) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.time = time;
        this.desc = desc;
        this.photo = photo;
    }

    public ExpenseAccount(String name, String type, Timestamp time, String desc, String photo) {
        this.name = name;
        this.type = type;
        this.time = time;
        this.desc = desc;
        this.photo = photo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpenseAccount that = (ExpenseAccount) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        return photo != null ? photo.equals(that.photo) : that.photo == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ExpenseAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", desc='" + desc + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
