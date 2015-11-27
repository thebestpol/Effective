package es.polgomez.data.mapper;

import es.polgomez.data.mapper.sources.ApiPointsOfInterestMapper;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestList;
import es.polgomez.domain.PointsOfInterest;

/**
 * Class to map data
 */
public class DataMapper {

    public PointsOfInterest transform(ApiPointOfInterestList apiPointOfInterestList) {
        ApiPointsOfInterestMapper mapper = new ApiPointsOfInterestMapper();
        return mapper.dataToModel(apiPointOfInterestList);
    }
}
