package io.study.deneb.controller;

public class CommonResponse<T> {

    private String message;

    private T data;

    private CommonError error;


    public CommonResponse() { }

    public CommonResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    /**
     * 처리 성공
     */
    public static <T> CommonResponse<T> ok(T data) {
        return new CommonResponse<>("", data);
    }


    /**
     * 처리 실패
     */
    public static <T> CommonResponse<T> error(String message) {
        return new CommonResponse<>(message, null);
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

}
