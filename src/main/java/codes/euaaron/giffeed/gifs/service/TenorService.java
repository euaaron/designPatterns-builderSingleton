package codes.euaaron.giffeed.gifs.service;

import codes.euaaron.giffeed.gifs.model.Gif;
import codes.euaaron.giffeed.gifs.model.GifListDTO;
import codes.euaaron.giffeed.shared.services.HttpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenorService {
    private static final TenorService instance = new TenorService();
    private final String BASE_URL;

    private TenorService() {
        BASE_URL = "https://tenor.googleapis.com/v2/search?platform=web&key=AIzaSyAl41UDG1pzJTekrzByCoOGASvk-j8VzkE&locale=en&client_key=tenor_web";
    }

    public static TenorService getInstance() { return instance; }

    public List<Gif> GetGif(String search, Integer limit) {
        String gifs = HttpService.getInstance().doGet( BASE_URL + "&q=" + search + "&limit=" + limit);
        try {
            ObjectMapper mapper = new ObjectMapper();
            GifListDTO item = mapper.readValue(gifs, GifListDTO.class);
            System.out.println(gifs);
            return item.getResults();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
