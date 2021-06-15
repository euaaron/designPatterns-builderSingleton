package codes.euaaron.giffeed;

import codes.euaaron.giffeed.gifs.model.Gif;
import codes.euaaron.giffeed.gifs.model.GifBuilder;
import codes.euaaron.giffeed.gifs.service.TenorServiceSingleton;
import codes.euaaron.giffeed.shared.services.HttpServiceSingleton;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GifFeedApplicationTests {

    @Test
    void CanCreateGifObjectWithBuilder() {
        List<String> tags = new ArrayList<>();
        tags.add("flintstone");

        Gif flintstone = new GifBuilder()
                .setId("123456789")
                .setLong_Title("Fred Flintsone jogando boliche com o Barney")
                .setUrl("https://tenor.com/uzA7.gif")
                .setShares(1234)
                .setTags(tags)
                .build();

        assertEquals("Fred Flintsone jogando boliche com o Barney", flintstone.long_title);
    }

    @Test
    void CantCreateGifObjectWithBuilder() {
        List<String> tags = new ArrayList<>();
        tags.add("flintstone");
        try {
            new GifBuilder()
                    .setId("123456789")
                    .setLong_Title("Fred Flintsone jogando boliche com o Barney")
                    .setShares(1234)
                    .setTags(tags)
                    .build();
            fail();
        } catch(NullPointerException e) {
            assertEquals("URL cannot be empty", e.getMessage());
        }
    }

    @Test
    void CanServeData() {
        try{
            String response = HttpServiceSingleton.getInstance().doGet("http://localhost:8080");
            assertNotNull(response);
        } catch (Exception e) {
            System.err.println("Este teste depende que a API esteja em execução. Inicie a API e teste novamente.");
            fail();
        }
    }

    @Test
    void CanReceiveGifDataFromTenor() {
        List<Gif> response = TenorServiceSingleton.getInstance().GetGif("popeye", 2);
        assertNotNull(response.get(1).getLong_Title());
    }

}
