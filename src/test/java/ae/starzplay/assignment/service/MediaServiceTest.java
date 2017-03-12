package ae.starzplay.assignment.service;

import ae.starzplay.assignment.AbstractMediaTest;
import ae.starzplay.assignment.service.Impl.MediaServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ResourceLoader;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Jagwani on 3/2/2017.
 */
public class MediaServiceTest extends AbstractMediaTest {

    @Mock
    private ResourceLoader resourceLoader;

    @InjectMocks
    private MediaService mediaService = new MediaServiceImpl();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMediaWithFilter() {
        try {
            when(resourceLoader.getResource(anyString()).getInputStream()).thenReturn(null);
            mediaService.getMediaByContentClassification("censoring", "uncensored");
        }catch (Exception e){
            verify(resourceLoader, times(1)).getResource(anyString());
        }
    }

    @Test
    public void testMediaWithInvalidFilter() throws Exception {
        when(resourceLoader.getResource(anyString())).thenReturn(null);
        mediaService.getMediaByContentClassification("test", "uncensored");
        verify(resourceLoader, times(0)).getResource(anyString());
    }

}
