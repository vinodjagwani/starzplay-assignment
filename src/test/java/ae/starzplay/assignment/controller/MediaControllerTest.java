package ae.starzplay.assignment.controller;

import ae.starzplay.assignment.AbstractMediaTest;
import ae.starzplay.assignment.entity.MovieMetaData;
import ae.starzplay.assignment.service.MediaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


/**
 * Created by Jagwani on 3/1/2017.
 */
public class MediaControllerTest extends AbstractMediaTest {

    @Mock
    private MediaService mediaService;


    @InjectMocks
    private MediaController mediaController;


    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(mediaController).build();
    }

    @Test
    public void testMediaWithFilter() throws Exception {
        when(mediaService.getMediaByContentClassification("censoring", "censored")).thenReturn(createMovieMetaData());
        MvcResult response = this.mockMvc.perform(get("/api/v1/media?filter=censoring&level=censored"))
                .andReturn();
        ObjectMapper mapper = new ObjectMapper();
        MovieMetaData[] movieMetaData = mapper.readValue(response.getResponse().getContentAsString(), MovieMetaData[].class);
        Assert.assertEquals(movieMetaData[0].getEntryCount(), Integer.valueOf(1));
    }

    @Test
    public void testMediaWithInValidFilter() throws Exception {
        when(mediaService.getMediaByContentClassification("censoring", "uncensored")).thenReturn(createMovieMetaData());
        MvcResult response = this.mockMvc.perform(get("/api/v1/media?filter=abc&level=uncensored"))
                .andReturn();
        ObjectMapper mapper = new ObjectMapper();
        MovieMetaData[] movieMetaData = mapper.readValue(response.getResponse().getContentAsString(), MovieMetaData[].class);
        Assert.assertEquals(movieMetaData.length, 0);
    }

    @Test
    public void testMediaWithInValidLevel() throws Exception {
        when(mediaService.getMediaByContentClassification("censoring", "uncensored")).thenReturn(createMovieMetaData());
        MvcResult response = this.mockMvc.perform(get("/api/v1/media?filter=abc&level=test"))
                .andReturn();
        ObjectMapper mapper = new ObjectMapper();
        MovieMetaData[] movieMetaData = mapper.readValue(response.getResponse().getContentAsString(), MovieMetaData[].class);
        Assert.assertEquals(movieMetaData.length, 0);
    }

}
