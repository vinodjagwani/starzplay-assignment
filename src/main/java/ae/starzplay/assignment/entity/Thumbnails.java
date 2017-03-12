package ae.starzplay.assignment.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Jagwani on 3/1/2017.
 */
@Getter
@Setter
public class Thumbnails {

    @JsonProperty("thumb-614x1536")
    private Thumb_614x1536 thumb_614x1536;

    @JsonProperty("thumb-677x474")
    private Thumb_677x474 thumb_677x474;

    @JsonProperty("thumb-613x1536")
    private Thumb_613x1536 thumb_613x1536;

    @JsonProperty("thumbc-677x474")
    private Thumbc_677x474 thumbc_677x474;

    @JsonProperty("thumb-615x1536")
    private Thumb_615x1536 thumb_615x1536;

    @JsonProperty("thumbc-613x1536")
    private Thumbc_613x1536 thumbc_613x1536;

    @JsonProperty("thumbc-614x1536")
    private Thumbc_614x1536 thumbc_614x1536;

    @JsonProperty("thumbc-615x1536")
    private Thumbc_615x1536 thumbc_615x1536;

}


