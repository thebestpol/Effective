package es.polgomez.data.repository.datasources.database.entities.mapper;

import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.database.entities.PointOfInterestDataBaseEntity;

public class PointOfInterestDataBaseMapper implements Mapper<PointOfInterestEntity, PointOfInterestDataBaseEntity> {
    @Override
    public PointOfInterestDataBaseEntity modelToData(PointOfInterestEntity model) {
        return null;
    }

    @Override
    public PointOfInterestEntity dataToModel(PointOfInterestDataBaseEntity data) {
        return null;
    }
}
