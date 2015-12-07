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
        PointsOfInterest pointsOfInterest = null;
        if (pointsOfInterestEntity != null) {
            List<PointOfInterest> pointsOfInterestList = null;

            pointsOfInterest = new PointsOfInterest();
            List<PointOfInterestEntity> pointsOfInterestEntityList = pointsOfInterestEntity.getPointsOfInterest();
            if (pointsOfInterestEntityList != null) {
                pointsOfInterestList = new ArrayList<>();
                for (PointOfInterestEntity pointOfInterestEntity : pointsOfInterestEntityList) {
                    pointsOfInterestList.add(transformPointOfInterest(pointOfInterestEntity));
                }
            }

            pointsOfInterest.setPointsOfInterest(pointsOfInterestList);
        }

        return pointsOfInterest;
    }

    private PointOfInterest transformPointOfInterest(PointOfInterestEntity pointOfInterestEntity) {
        PointOfInterest pointOfInterest = new PointOfInterest();
        String id = pointOfInterestEntity.getId();
        pointOfInterest.setId(id != null ? Integer.valueOf(id) : -1);
        pointOfInterest.setTitle(pointOfInterestEntity.getTitle());

        return pointOfInterest;
    }

    public PointOfInterestDetail transformPointOfInterestDetail(PointOfInterestDetailEntity pointOfInterestDetailEntity) {
        PointOfInterestDetail pointOfInterestDetail = null;
        if (pointOfInterestDetailEntity != null) {
            pointOfInterestDetail = new PointOfInterestDetail();
            String id = pointOfInterestDetailEntity.getId();
            pointOfInterestDetail.setId(id != null ? Integer.valueOf(id) : -1);
            pointOfInterestDetail.setAddress(pointOfInterestDetailEntity.getAddress());
            pointOfInterestDetail.setDescription(pointOfInterestDetailEntity.getDescription());
            pointOfInterestDetail.setEmail(pointOfInterestDetailEntity.getEmail());
            pointOfInterestDetail.setPhone(pointOfInterestDetailEntity.getPhone());
            pointOfInterestDetail.setTitle(pointOfInterestDetailEntity.getTitle());
            pointOfInterestDetail.setTransport(pointOfInterestDetailEntity.getTransport());
        }

        return pointOfInterestDetail;
    }
}
