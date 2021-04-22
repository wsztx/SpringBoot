package com.universe.springboot.common.exception;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.universe.springboot.common.enums.ResultCodeEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Response implements Serializable {

    /**
     * 返回码
     */
    private String code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 时间戳
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    public Response() {
        super();
    }

    public Response(Boolean success, ResultCodeEnum renum) {
        super();
        this.success = success;
        this.code = renum.getCode();
        this.timestamp = LocalDateTime.now();
    }

    public Response(Boolean success, String code, String message) {
        super();
        this.success = success;
        this.code = code;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

    @Override
    public String toString() {
        return toJSONString();
    }
}
