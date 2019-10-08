package oo.tinyweb;

import java.util.List;
import java.util.Map;

public class JavaTinyWeb {

    private Map<String, JavaController> controllers;
    private List<Filter> filters;

    public JavaTinyWeb(Map<String, JavaController> controllers, List<Filter> filters) {
        this.controllers = controllers;
        this.filters = filters;
    }

    public JavaHttpResponse handleRequest(JavaHttpRequest httpRequest) {

        JavaHttpRequest currentRequest = httpRequest;

        for (Filter filter : filters) {
            currentRequest = filter.doFilter(currentRequest);
        }

        JavaController controller = controllers.get(currentRequest.getPath());

        if (null == controller)
            return null;

        return controller.handleRequest(currentRequest);
    }
}
