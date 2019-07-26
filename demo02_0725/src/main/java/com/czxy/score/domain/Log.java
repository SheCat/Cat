package com.czxy.score.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tab_log")
public class Log {
    @Id
    private Integer id;
    private Integer uid;
    private String username;
    private String operat;
    private Date time;

    public Log() {
    }

    public Log(Integer id, Integer uid, String username, String operat, Date time) {
        this.id = id;
        this.uid = uid;
        this.username = username;
        this.operat = operat;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOperat() {
        return operat;
    }

    public void setOperat(String operat) {
        this.operat = operat;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", operat='" + operat + '\'' +
                ", time=" + time +
                '}';
    }
}
