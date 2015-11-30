package es.polgomez.data.repository.datasources.api.entities.mapper;

import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestListItem;

public class ApiPointOfInterestMapper implements Mapper<PointOfInterestEntity, ApiPointOfInterestListItem>{

    @Override
    public ApiPointOfInterestListItem modelToData(PointOfInterestEntity model) {
        ApiPointOfInterestListItem apiPointOfInterest = new ApiPointOfInterestListItem();
        // TODO map
        return apiPointOfInterest;
    }

    @Override
    public PointOfInterestEntity dataToModel(ApiPointOfInterestListItem data) {
        PointOfInterestEntity pointOfInterestEntity = new PointOfInterestEntity();
        // TODO map
        return pointOfInterestEntity;
    }
}
