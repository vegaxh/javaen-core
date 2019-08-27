package com.javaen.core.assistant.web;

/**
 * <p>
 * Project Name: javaen-core
 * <br>
 * Description: response interface
 * <br>
 * File Name: ExecuteResult
 * <br>
 * Copyright: Copyright (C) 2019 All Rights Reserved.
 * <br>
 *
 * @author: vegaxh
 * <p>
 * Date                 Author      Version     Description
 * ------------------------------------------------------------------
 * 2019/8/25 10:18     |vegaxh      |v1.0.0       |Create
 */
public interface ExecuteResult<T> extends java.io.Serializable {

    void setSucceed(Boolean succeed);

    Boolean getSucceed();

    void setCode(String code);

    String getMessage();

    void setMessage(String message);

    String getRequestId();

    void setRequestId(String requestId);

    T getData();

    void setData(T t);
}
