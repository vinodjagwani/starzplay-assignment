package ae.starzplay.assignment.service;

import ae.starzplay.assignment.entity.Entries;
import ae.starzplay.assignment.entity.MovieMetaData;

import java.util.Collection;
import java.util.List;

/**
 * Created by Jagwani on 2/28/2017.
 */

public interface MediaService {

    List<MovieMetaData> getMediaByContentClassification(final String filter, final String level) throws Exception;
}
