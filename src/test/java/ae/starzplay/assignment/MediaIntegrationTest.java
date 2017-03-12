package ae.starzplay.assignment;

/**
 * Created by Jagwani on 3/1/2017.
 */
import ae.starzplay.assignment.entity.MovieMetaData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class MediaIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testMediaWithUncensored() throws Exception {
        ResponseEntity<MovieMetaData[]> jsonResponse = restTemplate.getForEntity("/api/v1/media?filter=censoring&level=uncensored", MovieMetaData[].class);
        Assert.assertNotNull(jsonResponse);
        Assert.assertEquals(HttpStatus.OK, jsonResponse.getStatusCode());
        Assert.assertEquals(jsonResponse.getBody()[0].getEntryCount().toString(),"2");
    }

    @Test
    public void testMediaWithCensored() throws Exception {
        ResponseEntity<MovieMetaData[]> jsonResponse = restTemplate.getForEntity("/api/v1/media?filter=censoring&level=censored", MovieMetaData[].class);
        Assert.assertNotNull(jsonResponse);
        Assert.assertEquals(HttpStatus.OK, jsonResponse.getStatusCode());
        Assert.assertEquals(jsonResponse.getBody()[0].getEntryCount().toString(),"1");
    }

    @Test
    public void testMediaWithInValidFilter() throws Exception {
        ResponseEntity<MovieMetaData[]> jsonResponse = restTemplate.getForEntity("/api/v1/media?filter=uncensoring&level=censored", MovieMetaData[].class);
        Assert.assertEquals(HttpStatus.OK, jsonResponse.getStatusCode());
        Assert.assertEquals(jsonResponse.getBody().length, 0);
    }

    @Test
    public void testMediaWithInValidLevel() throws Exception {
        ResponseEntity<MovieMetaData[]> jsonResponse = restTemplate.getForEntity("/api/v1/media?filter=uncensoring&level=kfkfk", MovieMetaData[].class);
        Assert.assertEquals(HttpStatus.OK, jsonResponse.getStatusCode());
        Assert.assertEquals(jsonResponse.getBody().length, 0);
    }

}
