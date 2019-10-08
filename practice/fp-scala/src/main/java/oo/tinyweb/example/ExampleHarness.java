package oo.tinyweb.example;

import oo.tinyweb.*;

import java.util.*;

public class ExampleHarness {

    public static void main(String[] args) {

        JavaTinyWeb tinyWeb = new JavaTinyWeb(makeRoutes(), makeFilters());

        JavaHttpRequest testRequest = JavaHttpRequest.Builder.newBuilder()
                .path("greeting/")
                .body("Mike,Joe,John,Steve")
                .addHeader("X-Example", "exampleHeader")
                .build();

        JavaHttpResponse testResponse = tinyWeb.handleRequest(testRequest);

        System.out.println("responseCode: " + testResponse.getResponseCode());
        System.out.println("responseBody: ");
        System.out.println(testResponse.getBody());
    }

    private static Map<String, JavaController> makeRoutes() {
        GreetingRenderingStrategy viewRenderer = new GreetingRenderingStrategy();
        StrategyView greetingView = new StrategyView(viewRenderer);
        GreetingController greetingController = new GreetingController(greetingView);

        Map<String, JavaController> controllers = new HashMap<>();

        controllers.put("greeting/", greetingController);

        return Collections.unmodifiableMap(controllers);
    }

    private static List<Filter> makeFilters() {
        List<Filter> filters = new ArrayList<>();

        filters.add(new LoggingFilter());

        return filters;
    }
}
