package br.com.jccf.authentication.common;

import br.com.jccf.authentication.model.User;
import org.springframework.data.domain.Sort;

public class UserFilter {

    private User auth;
    private Integer page;
    private Integer size;
    private Sort.Direction direction;
    private String[] fields;

    public User getAuth() {
        return auth;
    }

    public void setAuth(User auth) {
        this.auth = auth;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Sort.Direction getDirection() {
        return direction;
    }

    public void setDirection(Sort.Direction direction) {
        this.direction = direction;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }
}
