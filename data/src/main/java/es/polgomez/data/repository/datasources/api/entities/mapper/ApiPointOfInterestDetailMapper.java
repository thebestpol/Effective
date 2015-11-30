package es.polgomez.data.repository.datasources.api.entities.mapper;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterest;

public class ApiPointOfInterestDetailMapper implements Mapper<PointOfInterestDetailEntity, ApiPointOfInterest>{
    @Override
    public ApiPointOfInterest modelToData(PointOfInterestDetailEntity model) {
        ApiPointOfInterest apiPointOfInterest = new ApiPointOfInterest();
        // TODO map
        return null;
    }

    @Override
    public PointOfInterestDetailEntity dataToModel(ApiPointOfInterest data) {
        PointOfInterestEntity pointOfInterestEntity = new PointOfInterestEntity();
        // TODO map
        return null;
    }
}
