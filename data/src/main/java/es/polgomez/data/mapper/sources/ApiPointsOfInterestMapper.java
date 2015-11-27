package es.polgomez.data.mapper.sources;

import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestList;
import es.polgomez.domain.PointsOfInterest;

public class ApiPointsOfInterestMapper implements Mapper<PointsOfInterest, ApiPointOfInterestList> {

    @Override
    public ApiPointOfInterestList modelToData(PointsOfInterest model) {
        ApiPointOfInterestList apiPointOfInterestList = new ApiPointOfInterestList();
        return null;
    }

    @Override
    public PointsOfInterest dataToModel(ApiPointOfInterestList data) {
        return null;
    }
}
