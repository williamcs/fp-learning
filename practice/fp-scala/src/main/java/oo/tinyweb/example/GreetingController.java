package oo.tinyweb.example;

import oo.tinyweb.JavaHttpRequest;
import oo.tinyweb.JavaView;
import oo.tinyweb.TemplateController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class GreetingController extends TemplateController {

    private Random random;

    public GreetingController(JavaView view) {
        super(view);
        random = new Random();
    }

    @Override
    public Map<String, List<String>> doRequest(JavaHttpRequest httpRequest) {
        Map<String, List<String>> helloModel = new HashMap<>();

        helloModel.put("greetings", generateGreetings(httpRequest.getBody()));

        return helloModel;
    }

    private List<String> generateGreetings(String namesCommaSeparated) {
        String[] names = namesCommaSeparated.split(",");
        List<String> greetings = new ArrayList<>();

        for (String name : names) {
            greetings.add(makeGreeting(name));
        }

        return greetings;
    }

    private String makeGreeting(String name) {
        String[] greetings = { "Hello", "Greetings", "Salutations", "Hola" };

        String greetingPrefix = greetings[random.nextInt(4)];

        return String.format("%s, %s", greetingPrefix, name);
    }
}
