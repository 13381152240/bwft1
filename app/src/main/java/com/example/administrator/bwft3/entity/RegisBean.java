package com.example.administrator.bwft3.entity;

/**
 * Created by Administrator on 2018/4/12.
 */

public class RegisBean {


    /**
     * status : 1
     * msg : 注册成功！
     * result : null
     */

    private int status;
    private String msg;
    private Object result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
