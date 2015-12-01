package es.polgomez.data.repository.datasources.database.entities.mapper;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.database.entities.PointOfInterestDetailDataBaseEntity;

public class PointOfInterestDetailDataBaseMapper implements Mapper<PointOfInterestDetailEntity, PointOfInterestDetailDataBaseEntity> {
    @Override
    public PointOfInterestDetailDataBaseEntity modelToData(PointOfInterestDetailEntity model) {
        PointOfInterestDetailDataBaseEntity pointOfInterestDetailDataBaseEntity = new PointOfInterestDetailDataBaseEntity();
        pointOfInterestDetailDataBaseEntity.setId(Integer.valueOf(model.getId()));
        pointOfInterestDetailDataBaseEntity.setTitle(model.getTitle());
        pointOfInterestDetailDataBaseEntity.setAddress(model.getAddress());
        pointOfInterestDetailDataBaseEntity.setDescription(model.getDescription());
        pointOfInterestDetailDataBaseEntity.setEmail(model.getEmail());
        pointOfInterestDetailDataBaseEntity.setGeocoordinates(null);
        pointOfInterestDetailDataBaseEntity.setPhone(model.getPhone());
        pointOfInterestDetailDataBaseEntity.setTransport(model.getTransport());

        return pointOfInterestDetailDataBaseEntity;
    }

    @Override
    public PointOfInterestDetailEntity dataToModel(PointOfInterestDetailDataBaseEntity data) {
        PointOfInterestDetailEntity pointOfInterestDetailEntity = new PointOfInterestDetailEntity();
        pointOfInterestDetailEntity.setId(Integer.toString(data.getId()));
        pointOfInterestDetailEntity.setTitle(data.getTitle());
        pointOfInterestDetailEntity.setTransport(data.getTransport());
        pointOfInterestDetailEntity.setAddress(data.getAddress());
        pointOfInterestDetailEntity.setPhone(data.getPhone());
        pointOfInterestDetailEntity.setDescription(data.getDescription());
        pointOfInterestDetailEntity.setEmail(data.getEmail());

        return pointOfInterestDetailEntity;
    }
}
