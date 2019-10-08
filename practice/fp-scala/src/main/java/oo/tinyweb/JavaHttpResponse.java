package oo.tinyweb;

public class JavaHttpResponse {

    private final String body;
    private final Integer responseCode;

    public String getBody() {
        return body;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    private JavaHttpResponse(Builder builder) {
        body = builder.body;
        responseCode = builder.responseCode;
    }

    public static class Builder {
        private String body;
        private Integer responseCode;

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder responseCode(Integer responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public JavaHttpResponse build() {
            return new JavaHttpResponse(this);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

    }
}
