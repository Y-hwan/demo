package com.example.demo.entity;

/**
 * 异步调用返回json数据的实体bean
 **/
public class JsonResult<T> {
    private boolean success;
    private String code;
    private String message;
    private T data;
    private static final String SUCCESS_CODE = "success";
    private static final String ERROR_CODE = "error";

    public JsonResult(boolean success){
        this.success = success;
    }

    public JsonResult(boolean success, String code){
        this.success = success;
        this.code = code;
    }

    public JsonResult(boolean success, String code, T data){
        this.success = success;
        this.code = code;
        this.data = data;
    }

    public JsonResult(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> JsonResult<T> asTrue() {
        return asTrue(SUCCESS_CODE);
    }

    public static <T> JsonResult<T> asFalse() {
        return asFalse(ERROR_CODE);
    }

    public static <T> JsonResult<T> asTrue(String code) {
        return asTrueModel(code, null);
    }

    public static <T> JsonResult<T> asFalse(String code) {
        return asFalseModel(code, null);
    }

    public static <T> JsonResult<T> asTrue(String code, String message) {
        return asTrueModel(code, message, null);
    }

    public static <T> JsonResult<T> asFalse(String code, String message) {
        return asFalseModel(code, message, null);
    }

    public static <T> JsonResult<T> asTrueModel(String code, T data) {
        return asTrueModel(code, SUCCESS_CODE, data);
    }

    public static <T> JsonResult<T> asFalseModel(String code, T data) {
        return asFalseModel(code, ERROR_CODE, data);
    }

    public static <T> JsonResult<T> asTrueModel(String code, String message, T data) {
        return new JsonResult<>(true, code, message, data);
    }

    public static <T> JsonResult<T> asFalseModel(String code, String message, T data) {
        return new JsonResult<>(false, code, message, data);
    }

    public static <T> JsonResult<T> asTrueModel(T data) {
        return asTrueModel(SUCCESS_CODE, data);
    }

    public static <T> JsonResult<T> asFalseModel(T data) {
        return asFalseModel(ERROR_CODE, data);
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static String getSuccessCode() {
        return SUCCESS_CODE;
    }

    public static String getErrorCode() {
        return ERROR_CODE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
