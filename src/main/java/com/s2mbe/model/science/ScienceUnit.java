package com.s2mbe.model.science;

import com.s2mbe.model.BasicEntity;
import com.s2mbe.model.user.User;
import lombok.Data;

import java.util.List;

@Data
public abstract class ScienceUnit extends BasicEntity {
    private String name;
    private String title;
    private String year;
    private String url;
    private String unitType;
    // TODO: Maybe not needed
    private String author;
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
