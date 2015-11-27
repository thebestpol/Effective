package es.polgomez.data.mapper.sources;

import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterest;
import es.polgomez.domain.PointOfInterest;

public class ApiPointOfInterestMapper implements Mapper<PointOfInterest, ApiPointOfInterest>{

    @Override
    public ApiPointOfInterest modelToData(PointOfInterest model) {
        ApiPointOfInterest apiPointOfInterest = new ApiPointOfInterest();
        // TODO mapping
        return apiPointOfInterest;
    }

    @Override
    public PointOfInterest dataToModel(ApiPointOfInterest data) {
        PointOfInterest pointOfInterest = new PointOfInterest();
        // TODO mapping
        return pointOfInterest;
    }
}
