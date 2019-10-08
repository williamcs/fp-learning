package oo.tinyweb.example;

import oo.tinyweb.Filter;
import oo.tinyweb.JavaHttpRequest;

public class LoggingFilter implements Filter {

    @Override
    public JavaHttpRequest doFilter(JavaHttpRequest request) {

        System.out.println("In Logging Filter - request for path: " + request.getPath());

        return request;
    }

}
