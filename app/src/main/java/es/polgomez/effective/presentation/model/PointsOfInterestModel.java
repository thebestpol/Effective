package es.polgomez.effective.presentation.model;

import java.util.List;

public class PointsOfInterestModel {

    private List<PointOfInterestModel> pointsOfInterest;

    public List<PointOfInterestModel> getPointsOfInterest() {
        return pointsOfInterest;
    }

    public void setPointsOfInterest(List<PointOfInterestModel> pointsOfInterest) {
        this.pointsOfInterest = pointsOfInterest;
    }

    @Override
    public String toString() {
        return "PointsOfInterestModel{" +
                "pointsOfInterest=" + pointsOfInterest +
                '}';
    }
}
