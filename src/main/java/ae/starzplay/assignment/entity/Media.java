package ae.starzplay.assignment.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Jagwani on 3/1/2017.
 */

@Getter
@Setter
public class Media {

    private String id;
    private String title;
    private String guid;
    private String ownerId;
    private String availableDate;
    private String expirationDate;
    private String[] ratings;
    private Content[] content;
    private String restrictionId;
    private String availabilityState;

}



