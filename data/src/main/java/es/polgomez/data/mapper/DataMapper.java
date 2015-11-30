package es.polgomez.data.mapper;

import java.util.ArrayList;
import java.util.List;

import es.polgomez.data.entities.PointOfInterestDetailEntity;
import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointOfInterestDetail;
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

    public PointOfInterestDetail transformPointOfInterestDetail(PointOfInterestDetailEntity pointOfInterestDetailEntity) {
        PointOfInterestDetail pointOfInterestDetail = new PointOfInterestDetail();
        pointOfInterestDetail.setId(Integer.valueOf(pointOfInterestDetailEntity.getId()));
        pointOfInterestDetail.setAddress(pointOfInterestDetailEntity.getAddress());
        pointOfInterestDetail.setDescription(pointOfInterestDetailEntity.getDescription());
        pointOfInterestDetail.setEmail(pointOfInterestDetailEntity.getEmail());
        pointOfInterestDetail.setPhone(pointOfInterestDetailEntity.getPhone());
        pointOfInterestDetail.setTitle(pointOfInterestDetailEntity.getTitle());
        pointOfInterestDetail.setTransport(pointOfInterestDetailEntity.getTransport());

        return pointOfInterestDetail;
    }
}
