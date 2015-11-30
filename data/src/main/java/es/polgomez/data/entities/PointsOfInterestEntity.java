package es.polgomez.data.entities;

import java.util.ArrayList;
import java.util.List;

public class PointsOfInterestEntity {

    private List<PointOfInterestEntity> pointsOfInterest = new ArrayList<>();

    public List<PointOfInterestEntity> getPointsOfInterest() {
        return pointsOfInterest;
    }

    public void setPointsOfInterest(List<PointOfInterestEntity> pointsOfInterest) {
        this.pointsOfInterest = pointsOfInterest;
    }

    @Override
    public String toString() {
        return "PointsOfInterestEntity{" +
                "pointsOfInterest=" + pointsOfInterest +
                '}';
    }
}
