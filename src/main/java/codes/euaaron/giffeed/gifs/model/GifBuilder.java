package codes.euaaron.giffeed.gifs.model;

import java.util.List;

public class GifBuilder {
    private final Gif gif;

    public GifBuilder() { gif = new Gif(); }

    public Gif build() {
        if(gif.getId() == null) {
            throw new NullPointerException("GIF id cannot be empty");
        }
        if(gif.getUrl() == null) {
            throw new NullPointerException("URL cannot be empty");
        }
        return gif;
    }

    public GifBuilder setId(String id) {
        gif.setId(id);
        return this;
    }

    public GifBuilder setLong_Title(String long_Title) {
        gif.setLong_Title(long_Title);
        return this;
    }

    public GifBuilder setUrl(String url) {
        gif.setUrl(url);
        return this;
    }

    public GifBuilder setTags(List<String> tags) {
        gif.setTags(tags);
        return this;
    }

    public GifBuilder setShares(int shares) {
        gif.setShares(shares);
        return this;
    }
}
