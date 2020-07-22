package com.example.demo;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.jetty.JettyClientMetrics;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private final MeterRegistry registry;

    public HomeController(MeterRegistry registry) {
        this.registry = registry;
    }

    private static String uriPattern(Result result) {
        return result.getRequest().getURI().getPath();
    }

    @RequestMapping("/home")
    public String home() throws Exception {

        HttpClient httpClient = createClient();
        ContentResponse httpResponse = httpClient.GET("http://postman-echo.com/get?foo1=bar1&foo2=bar2");

        String prettyJson = toPrettyJson(httpResponse);

        log.info(prettyJson);

        httpClient.stop();

        return "Hi from Spring Boot! :)";
    }

    private String toPrettyJson(ContentResponse contentResponse) throws JSONException {
        JSONObject jsonObject = new JSONObject(contentResponse.getContentAsString());
        return jsonObject.toString(4);
    }

    private HttpClient createClient() throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.getRequestListeners().add(JettyClientMetrics.builder(registry, HomeController::uriPattern).build());
        httpClient.start();
        return httpClient;
    }

}
