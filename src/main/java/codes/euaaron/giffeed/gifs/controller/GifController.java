package codes.euaaron.giffeed.gifs.controller;

import codes.euaaron.giffeed.gifs.model.Gif;
import codes.euaaron.giffeed.gifs.service.TenorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GifController {

    @GetMapping("/")
    public String root() {
        return   "Welcome to GIFFeed!\n"
                + "<h1>Go to localhost:8080/gif?search=yourSearchTerm</h1>\n"
                + "You can also limit results to any number. Ex.: Limit to 15 by adding ?limit=15 to the end of the URL.";
    }

    @GetMapping("/gif")
    public List<Gif> gif(
            @RequestParam(value = "search", defaultValue = "simpsons") String search,
            @RequestParam(value = "limit", defaultValue = "5") Integer limit
    ) {
        return TenorService.getInstance().GetGif(search, limit);
    }

}
