package oo.tinyweb.example;


import oo.tinyweb.RenderingStrategy;

import java.util.List;
import java.util.Map;

public class GreetingRenderingStrategy implements RenderingStrategy {

    @Override
    public String renderView(Map<String, List<String>> model) {
        List<String> greetings = model.get("greetings");
        StringBuffer responseBody = new StringBuffer();
        responseBody.append("<h1>Friendly Greetings:</h1>\n");
        for (String greeting : greetings) {
            responseBody.append(
                    String.format("<h2>%s</h2>\n", greeting));

        }
        return responseBody.toString();
    }

}
