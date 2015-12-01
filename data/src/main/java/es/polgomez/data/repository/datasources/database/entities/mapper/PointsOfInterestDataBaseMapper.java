package es.polgomez.data.repository.datasources.database.entities.mapper;

import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.database.entities.PointsOfInterestDataBaseEntity;

public class PointsOfInterestDataBaseMapper implements Mapper<PointsOfInterestEntity, PointsOfInterestDataBaseEntity> {
    @Override
    public PointsOfInterestDataBaseEntity modelToData(PointsOfInterestEntity model) {
        return null;
    }

    @Override
    public PointsOfInterestEntity dataToModel(PointsOfInterestDataBaseEntity data) {
        return null;
    }
}
