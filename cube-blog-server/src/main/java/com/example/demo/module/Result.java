package com.example.demo.module;


import java.io.Serializable;

public class Result<T> implements Serializable {
    private int status;
    private String message;
    private T data;

    public static final int SUCCESS = 1;
    public static final int FAILURE = 0;

    public Result() {
        this.status = SUCCESS;
        this.message = "操作成功";
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

