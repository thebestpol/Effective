package es.polgomez.data.mapper;

import java.util.ArrayList;
import java.util.List;

import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointsOfInterest;

/**
 * Class to map data
 */
public class DataMapper {

    public PointsOfInterest transformPointsOfInterest(PointsOfInterestEntity pointsOfInterestEntity) {
        List<PointOfInterest> pointsOfInterestList = new ArrayList<>();

        PointsOfInterest pointsOfInterest = new PointsOfInterest();
        for (PointOfInterestEntity pointOfInterestEntity : pointsOfInterestEntity.getPointsOfInterest()) {
            pointsOfInterestList.add(transformPointOfInterest(pointOfInterestEntity));
        }

        pointsOfInterest.setPointsOfInterest(pointsOfInterestList);

        return pointsOfInterest;
    }

    private PointOfInterest transformPointOfInterest(PointOfInterestEntity pointOfInterestEntity) {
        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(Integer.valueOf(pointOfInterestEntity.getId()));
        pointOfInterest.setTitle(pointOfInterestEntity.getTitle());

        return pointOfInterest;
    }
}
