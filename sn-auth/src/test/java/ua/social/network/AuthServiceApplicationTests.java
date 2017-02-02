package ua.social.network;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * @author Mykola Yashchenko
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(value = "server.port:0", classes = AuthApplication.class)
public class AuthServiceApplicationTests {

    @Value("${local.server.port}")
    private int port;

    private RestTemplate template = new TestRestTemplate();

    @Ignore
    @Test
    public void homePageProtected() {
        ResponseEntity<String> response = template.getForEntity("http://localhost:"
                + port + "/uaa/", String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        String auth = response.getHeaders().getFirst("WWW-Authenticate");
        assertTrue("Wrong header: " + auth, auth.startsWith("Bearer realm=\""));
    }

    @Ignore
    @Test
    public void userEndpointProtected() {
        ResponseEntity<String> response = template.getForEntity("http://localhost:"
                + port + "/uaa/user", String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        String auth = response.getHeaders().getFirst("WWW-Authenticate");
        assertTrue("Wrong header: " + auth, auth.startsWith("Bearer realm=\""));
    }

    @Ignore
    @Test
    public void authorizationRedirects() {
        ResponseEntity<String> response = template.getForEntity("http://localhost:"
                + port + "/uaa/oauth/authorize", String.class);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        String auth = response.getHeaders().getFirst("WWW-Authenticate");
        assertTrue("Wrong header: " + auth, auth.startsWith("Basic realm=\""));
    }

}