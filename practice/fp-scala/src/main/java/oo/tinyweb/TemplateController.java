package oo.tinyweb;

import java.util.List;
import java.util.Map;

public abstract class TemplateController implements JavaController {
    private JavaView view;

    public TemplateController(JavaView view) {
        this.view = view;
    }

    public JavaHttpResponse handleRequest(JavaHttpRequest request) {
        Integer responseCode = 200;
        String responseBody = "";

        try {
            Map<String, List<String>> model = doRequest(request);
            responseBody = view.render(model);
        } catch (JavaControllerException e) {
            responseCode = e.getStatusCode();
        } catch (JavaRenderingException e) {
            responseCode = 500;
            responseBody = "Exception while rendering.";
        } catch (Exception e) {
            responseCode = 500;
        }

        return JavaHttpResponse.Builder.newBuilder().body(responseBody)
                .responseCode(responseCode).build();
    }

    protected abstract Map<String, List<String>> doRequest(JavaHttpRequest request);
}
