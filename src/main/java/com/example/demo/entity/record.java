package com.example.demo.entity;

import java.util.Date;

/**
 * Created by wangzhenqin on 2019/7/22.
 */
public class record {
    private Integer id;
    private String reason;
    private Date time;
    private Integer money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
