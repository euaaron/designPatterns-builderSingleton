package codes.euaaron.giffeed.shared.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpService {
    private static HttpService instance = new HttpService(new RestTemplateBuilder());

    private final RestTemplate rest;

    public HttpService(RestTemplateBuilder restTemplateBuilder) {
        this.rest = restTemplateBuilder.build();
    }

    public static HttpService getInstance() { return instance; }

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
