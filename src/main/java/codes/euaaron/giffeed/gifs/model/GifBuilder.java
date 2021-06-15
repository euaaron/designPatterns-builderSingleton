package codes.euaaron.giffeed.gifs.model;

import java.util.List;

public class GifBuilder {
    private final Gif gif;

    public GifBuilder() { gif = new Gif(); }

    public Gif build() {
        if(gif.getId().equals("empty")) {
            throw new IllegalArgumentException("Invalid gif id.");
        }
        if(gif.getUrl().equals("")) {
            throw new IllegalArgumentException("Invalid url.");
        }
        return gif;
    }

    public GifBuilder setId(String id) {
        gif.setId(id);
        return this;
    }

    public GifBuilder setTitle(String title) {
        gif.setTitle(title);
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
