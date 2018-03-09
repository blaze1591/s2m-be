package com.s2mbe.model.user;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Cathedra {
    private String name;
    private String post;
    private boolean key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public boolean isKey() {
        return key;
    }

    public void setKey(boolean key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        System.err.println(o);
        if (this == o) return true;

        if (!(o instanceof Cathedra)) return false;

        Cathedra cathedra = (Cathedra) o;

        return new EqualsBuilder()
                .append(name, cathedra.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .toHashCode();
    }
}