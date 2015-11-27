package es.polgomez.domain;

import java.util.List;

public class PointsOfInterest {

    private List<PointOfInterest> pointsOfInterest;

    public List<PointOfInterest> getPointsOfInterest() {
        return pointsOfInterest;
    }

    public void setPointsOfInterest(List<PointOfInterest> pointsOfInterest) {
        this.pointsOfInterest = pointsOfInterest;
    }

    @Override
    public String toString() {
        return "PointsOfInterest{" +
                "pointsOfInterest=" + pointsOfInterest +
                '}';
    }
}
