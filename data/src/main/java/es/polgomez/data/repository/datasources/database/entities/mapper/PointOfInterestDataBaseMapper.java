package es.polgomez.data.repository.datasources.database.entities.mapper;

import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.database.entities.PointOfInterestDataBaseEntity;

public class PointOfInterestDataBaseMapper implements Mapper<PointOfInterestEntity, PointOfInterestDataBaseEntity> {
    @Override
    public PointOfInterestDataBaseEntity modelToData(PointOfInterestEntity model) {
        PointOfInterestDataBaseEntity pointOfInterestDataBaseEntity = new PointOfInterestDataBaseEntity();
        pointOfInterestDataBaseEntity.setId(Integer.valueOf(model.getId()));
        pointOfInterestDataBaseEntity.setTitle(model.getTitle());

        return pointOfInterestDataBaseEntity;
    }

    @Override
    public PointOfInterestEntity dataToModel(PointOfInterestDataBaseEntity data) {
        PointOfInterestEntity pointOfInterestEntity = new PointOfInterestEntity();
        pointOfInterestEntity.setId(Integer.toString(data.getId()));
        pointOfInterestEntity.setTitle(data.getTitle());

        return pointOfInterestEntity;
    }
}
