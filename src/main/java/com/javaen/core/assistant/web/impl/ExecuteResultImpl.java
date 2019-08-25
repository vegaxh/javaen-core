package com.javaen.core.assistant.web.impl;

import com.javaen.core.assistant.web.ExecuteResult;

/**
 * <p>
 * Project Name: javaen-core
 * <br>
 * Description: response impl class
 * <br>
 * File Name: ExecuteResultImpl
 * <br>
 * Copyright: Copyright (C) 2019 All Rights Reserved.
 * <br>
 *
 * @author: vegaxh
 * @email: vegaxh@gmail.com
 * @create time：2019/8/25 10:37
 * @version: v1.0
 * <p>
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2019/8/25 10:37     |vegaxh      |v1.0       |Create
 */
public class ExecuteResultImpl<T> implements ExecuteResult<T> {

    private Boolean succeed;

    private String code;

    private String message;

    private String requestId;

    private T data;

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
