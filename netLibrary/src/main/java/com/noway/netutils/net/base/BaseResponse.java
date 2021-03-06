package com.noway.netutils.net.base;

import com.google.gson.annotations.SerializedName;

/**
 * 描述:    TODO  响应基类
 * 作者:    NoWay
 * 邮箱:    dingpengqiang@qq.com
 * 日期:    2017/12/6
 * 版本:    V-1.0.0
 */
public class BaseResponse<T> {


    @SerializedName("code")
    private String code;

    @SerializedName("msg")
    private String msg;

    @SerializedName("result")
    private T data;

    @SerializedName("charge")
    private boolean success;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
