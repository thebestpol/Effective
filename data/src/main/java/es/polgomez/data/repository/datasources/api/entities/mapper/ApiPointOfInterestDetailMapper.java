package es.polgomez.data.repository.datasources.api.entities.mapper;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterest;

public class ApiPointOfInterestDetailMapper implements Mapper<PointOfInterestDetailEntity, ApiPointOfInterest>{

    @Override
    public ApiPointOfInterest modelToData(PointOfInterestDetailEntity model) {
        ApiPointOfInterest apiPointOfInterest = new ApiPointOfInterest();
        apiPointOfInterest.setAddress(model.getAddress());
        apiPointOfInterest.setGeocoordinates(null);
        apiPointOfInterest.setId(model.getId());
        apiPointOfInterest.setTitle(model.getTitle());
        apiPointOfInterest.setDescription(model.getDescription());
        apiPointOfInterest.setEmail(model.getEmail());
        apiPointOfInterest.setPhone(model.getPhone());
        apiPointOfInterest.setTransport(model.getTransport());

        return apiPointOfInterest;
    }

    @Override
    public PointOfInterestDetailEntity dataToModel(ApiPointOfInterest data) {
        PointOfInterestDetailEntity pointOfInterestDetailEntity = new PointOfInterestDetailEntity();
        pointOfInterestDetailEntity.setAddress(data.getAddress());
        pointOfInterestDetailEntity.setId(data.getId());
        pointOfInterestDetailEntity.setTitle(data.getTitle());
        pointOfInterestDetailEntity.setDescription(data.getDescription());
        pointOfInterestDetailEntity.setEmail(data.getEmail());
        pointOfInterestDetailEntity.setPhone(data.getPhone());
        pointOfInterestDetailEntity.setTransport(data.getTransport());

        return pointOfInterestDetailEntity;
    }
}
