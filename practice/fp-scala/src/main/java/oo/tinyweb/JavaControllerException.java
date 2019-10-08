package oo.tinyweb;

public class JavaControllerException extends RuntimeException {

    private Integer statusCode;

    public JavaControllerException(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
