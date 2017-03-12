package ae.starzplay.assignment.client;

import ae.starzplay.assignment.entity.MovieMetaData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Jagwani on 3/2/2017.
 */

@FeignClient("starzplay-assignment")
public interface MediaClient {

    @RequestMapping(value = "/media", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieMetaData> media(@RequestParam("filter") String filter, @RequestParam("level") String level) throws Exception;

}
