package es.polgomez.data.repository.datasources.database.entities.mapper;

import java.util.ArrayList;
import java.util.List;

import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.database.entities.PointOfInterestDataBaseEntity;
import es.polgomez.data.repository.datasources.database.entities.PointsOfInterestDataBaseEntity;
import io.realm.RealmList;

public class PointsOfInterestDataBaseMapper implements Mapper<PointsOfInterestEntity, PointsOfInterestDataBaseEntity> {
    @Override
    public PointsOfInterestDataBaseEntity modelToData(PointsOfInterestEntity model) {
        PointOfInterestDataBaseMapper mapper = new PointOfInterestDataBaseMapper();

        RealmList<PointOfInterestDataBaseEntity> pointsOfInterest = new RealmList();

        for (PointOfInterestEntity pointOfInterestEntity : model.getPointsOfInterest()) {
            pointsOfInterest.add(mapper.modelToData(pointOfInterestEntity));
        }

        PointsOfInterestDataBaseEntity pointsOfInterestDataBaseEntity = new PointsOfInterestDataBaseEntity();
        pointsOfInterestDataBaseEntity.setPointsOfInterest(pointsOfInterest);

        return pointsOfInterestDataBaseEntity;
    }

    @Override
    public PointsOfInterestEntity dataToModel(PointsOfInterestDataBaseEntity data) {
        PointOfInterestDataBaseMapper mapper = new PointOfInterestDataBaseMapper();

        List<PointOfInterestEntity> pointsOfInterest = new ArrayList<>();

        for (PointOfInterestDataBaseEntity pointOfInterestDataBaseEntity : data.getPointsOfInterest()) {
            pointsOfInterest.add(mapper.dataToModel(pointOfInterestDataBaseEntity));
        }

        PointsOfInterestEntity pointsOfInterestEntity = new PointsOfInterestEntity();
        pointsOfInterestEntity.setPointsOfInterest(pointsOfInterest);

        return pointsOfInterestEntity;
    }
}
