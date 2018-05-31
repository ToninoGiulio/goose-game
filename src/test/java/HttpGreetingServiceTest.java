import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@Ignore
public class HttpGreetingServiceTest {

    @BeforeClass
    public static void before() throws Exception {
        Application.start();
    }

    @Test
    @Ignore
    public void shouldSayHello() throws Exception {
        HttpResponse<String> response = Unirest.get("http://localhost:9001/greating").asString();
        String body = response.getBody();
        assertEquals("Hello world", body);
    }

    @Test
    public void should_post_say_hello() throws Exception {
        HttpResponse<String> response = Unirest.post("http://localhost:9001/greating").asString();
        String body = response.getBody();
        assertEquals("POST", body);
    }

    @AfterClass
    public static void after() throws Exception {
        Application.stop();
    }


}