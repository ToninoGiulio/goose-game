import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HttpGooseGameServiceTest {

    @BeforeClass
    public static void before() throws Exception {
        GooseApplication.start();
    }

    @Test
    public void should_post_add_one_player_return_string() throws Exception {
        HttpResponse<String> response = Unirest.post("http://localhost:9001/goose/players?name=pippo").asString();
        String body = response.getBody();
        assertEquals("pippo: already existing player", body);
    }

    @Test
    public void should_post_add_two_player_return_string() throws Exception {
        HttpResponse<String> response = Unirest.post("http://localhost:9001/goose/players?name=pluto").asString();
        String body = response.getBody();
        assertEquals("players: pippo", body);
    }

    @AfterClass
    public static void after() throws Exception {
        GooseApplication.stop();
    }


}