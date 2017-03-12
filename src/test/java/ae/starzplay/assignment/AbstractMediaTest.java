package ae.starzplay.assignment;

import ae.starzplay.assignment.entity.Entries;
import ae.starzplay.assignment.entity.Media;
import ae.starzplay.assignment.entity.MovieMetaData;
import ae.starzplay.assignment.entity.Xmlns;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jagwani on 3/2/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AbstractMediaTest {



    @Test
    public void testCommandBehavior(){
        // Method for any common Behavior can be written here
    }

    public List<MovieMetaData> createMovieMetaData(){
        MovieMetaData movieMetaData = new MovieMetaData();
        Xmlns xmlns = new Xmlns();
        xmlns.setPeg("test");
        movieMetaData.set$xmlns(xmlns);
        Entries entry = new Entries();
        entry.setPeg$contentClassification("censored");
        List<Entries> entries = new ArrayList();
        List<Media> mediaList = new ArrayList<>();
        Media media = new Media();
        media.setGuid("ABC");
        mediaList.add(media);
        entry.setMedia(mediaList);
        entries.add(entry);
        movieMetaData.setEntries(entries);
        movieMetaData.setEntryCount(1);
        movieMetaData.setItemsPerPage("10");
        movieMetaData.setStartIndex("1");
        movieMetaData.setTitle("Test");
        List<MovieMetaData> movieMetaDataList = new ArrayList<>();
        movieMetaDataList.add(movieMetaData);
        return movieMetaDataList;
    }

}
