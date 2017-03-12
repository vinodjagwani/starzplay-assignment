package ae.starzplay.assignment.service.Impl;

import ae.starzplay.assignment.config.MediaConstant;
import ae.starzplay.assignment.entity.*;
import ae.starzplay.assignment.service.MediaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.*;
/**
 * Created by Jagwani on 2/28/2017.
 */

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public List<MovieMetaData> getMediaByContentClassification(final String filter, final String level) throws IOException{
        List<MovieMetaData> result = new ArrayList<>();
        if(MediaConstant.filterType.contains(filter.toLowerCase()) && !level.isEmpty()) {
            MovieMetaData jsonResponse =  getFileData() ;
            result = convertMetaData(jsonResponse, level);
        }
        return result;
    }

    private List<MovieMetaData> convertMetaData(final MovieMetaData jsonResponse,final String level){

        List<MovieMetaData> response= new ArrayList<>();
        MovieMetaData movieMetaData = new MovieMetaData();
        movieMetaData.setTitle(jsonResponse.getTitle());
        movieMetaData.setStartIndex(jsonResponse.getStartIndex());
        Xmlns xmlns = new Xmlns();
        xmlns.setPeg(jsonResponse.get$xmlns().getPeg());
        movieMetaData.set$xmlns(xmlns);
        movieMetaData.setItemsPerPage(jsonResponse.getItemsPerPage());
        List<Entries> entries = new ArrayList<>();
        List<Media> medias = new ArrayList<>();
        for(Entries entry: jsonResponse.getEntries()){
            if(level.equals(entry.getPeg$contentClassification().toLowerCase())){
                for(Media media : entry.getMedia()){
                    if(media.getGuid().endsWith("C")){
                        medias.add(media);
                    }
                }
                entry.setMedia(medias);
                entries.add(entry);
            }
        }
        movieMetaData.setEntryCount(entries.size());
        movieMetaData.setEntries(entries);
        response.add(movieMetaData);
        return response;
    }

    private MovieMetaData getFileData() throws IOException{
        String content = IOUtils.toString(resourceLoader.getResource("classpath:content.json").getInputStream());
        ObjectMapper mapper = new ObjectMapper();
        MovieMetaData movieMetaData = mapper.readValue(content,MovieMetaData.class);
        return movieMetaData;
    }

}
