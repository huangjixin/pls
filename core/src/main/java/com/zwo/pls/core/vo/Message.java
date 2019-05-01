package com.zwo.pls.core.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 一句话描述该类功能：
 * Created by Tony(黄记新) in 2019/5/1
 */
@Data
public class Message implements Serializable {
    private Object data;
    private String msg ="success";
    private String code = "200";

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
