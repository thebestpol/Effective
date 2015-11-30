package es.polgomez.data.repository.datasources.api.entities.mapper;

import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestListItem;

public class ApiPointOfInterestMapper implements Mapper<PointOfInterestEntity, ApiPointOfInterestListItem>{

    @Override
    public ApiPointOfInterestListItem modelToData(PointOfInterestEntity model) {
        ApiPointOfInterestListItem apiPointOfInterest = new ApiPointOfInterestListItem();
        apiPointOfInterest.setId(model.getId());
        apiPointOfInterest.setTitle(model.getTitle());
        apiPointOfInterest.setGeocoordinates(null);

        return apiPointOfInterest;
    }

    @Override
    public PointOfInterestEntity dataToModel(ApiPointOfInterestListItem data) {
        PointOfInterestEntity pointOfInterestEntity = new PointOfInterestEntity();
        pointOfInterestEntity.setId(data.getId());
        pointOfInterestEntity.setTitle(data.getTitle());

        return pointOfInterestEntity;
    }
}
