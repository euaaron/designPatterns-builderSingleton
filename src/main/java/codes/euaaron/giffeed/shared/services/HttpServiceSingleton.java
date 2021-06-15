package codes.euaaron.giffeed.shared.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpServiceSingleton {
    private static HttpServiceSingleton instance = new HttpServiceSingleton(new RestTemplateBuilder());

    private final RestTemplate rest;

    public HttpServiceSingleton(RestTemplateBuilder restTemplateBuilder) {
        this.rest = restTemplateBuilder.build();
    }

    public static HttpServiceSingleton getInstance() { return instance; }

    public String doGet(String url) {
        try {
            String data = this.rest.getForObject(url, String.class);
            return data;
        } catch (HttpStatusCodeException ex) {
            System.out.println(ex.getStatusCode().toString());
            System.out.println(ex.getResponseBodyAsString());
         return null;
        }
    }
}
