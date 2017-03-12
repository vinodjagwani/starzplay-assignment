package ae.starzplay.assignment.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Jagwani on 3/1/2017.
 */

@Getter
@Setter
public class Content
{
    private Releases[] releases;
    private String width;
    private String streamingUrl;
    private String downloadUrl;
    private String format;
    private String[] assetTypeIds;
    private String id;
    private String guid;
    private String duration;
    private String height;
    private String[] assetTypes;
    private String bitrate;
    private String serverId;
    private String language;
    private String protectionScheme;

}


