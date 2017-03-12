package ae.starzplay.assignment.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Jagwani on 3/1/2017.
 */


@Getter
@Setter
public class Entries {

    private String id;
    private String guid;
    private String updated;
    private String title;
    private String description;
    private String added;
    private String approved;
    private List<Credits> credits;
    private DescriptionLocalized descriptionLocalized;
    private String displayGenre;
    private String editorialRating;
    private List<ImageMediaIds> imageMediaIds;
    private Boolean isAdult;
    private String[] languages;
    private String longDescription;
    private DescriptionLocalized longDescriptionLocalized;
    private String programType;
    private List<String> ratings;
    private String seriesEpisodeNumber;
    private String seriesId;
    private String shortDescription;
    private DescriptionLocalized shortDescriptionLocalized;
    private List<String> tagIds;
    private List<Tags> tags;
    private Thumbnails thumbnails;
    private TitleLocalized titleLocalized;
    private String tvSeasonEpisodeNumber;
    private String tvSeasonId;
    private String tvSeasonNumber;
    private String year;
    private List<Media> media;
    private String peg$ISOcountryOfOrigin;
    private String peg$ExclusiveFrench;
    private String peg$arAgeRating;
    private String peg$arContentRating;
    private String peg$availableInSection;
    private String peg$contentClassification;
    private String peg$contractName;
    private String peg$countryOfOrigin;
    private String peg$priorityLevel;
    private String peg$priorityLevelActionandAdventure;
    private String peg$priorityLevelArabic;
    private String peg$priorityLevelChildrenandFamily;
    private String peg$priorityLevelComedy;
    private String peg$priorityLevelDisney;
    private String peg$priorityLevelDisneyKids;
    private String peg$priorityLevelDrama;
    private String peg$priorityLevelKids;
    private String peg$priorityLevelKidsAction;
    private String peg$priorityLevelKidsFunandAdventure;
    private String peg$priorityLevelKidsMagicandDreams;
    private String peg$priorityLevelKidsPreschool;
    private String peg$priorityLevelRomance;
    private String peg$priorityLevelThriller;
    private String peg$productCode;
    private String peg$programMediaAvailability;
    private String peg$testDefaultValue;

}