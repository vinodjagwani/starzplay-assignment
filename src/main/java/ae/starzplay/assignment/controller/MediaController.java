package ae.starzplay.assignment.controller;

import ae.starzplay.assignment.entity.MovieMetaData;
import ae.starzplay.assignment.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jagwani on 3/1/2017.
 */
@RestController
@RequestMapping("/api/v1")
public class MediaController {


    @Autowired
    private MediaService mediaService;


    @RequestMapping(value = "/media", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MovieMetaData> media(@RequestParam("filter") String filter, @RequestParam("level") String level) throws Exception {
        return mediaService.getMediaByContentClassification(filter, level);
    }



}
