package codes.euaaron.giffeed.gifs.service.dto;

import codes.euaaron.giffeed.gifs.model.Gif;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GifListDTO {
    private List<Gif> results;

    GifListDTO() {}

    public List<Gif> getResults() {
        return results;
    }

    public void setResults(List<Gif> results) {
        this.results = results;
    }
}
