package es.polgomez.data.repository.datasources.database.entities;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Required;

public class PointsOfInterestDataBaseEntity extends RealmObject {

    @Required
    private RealmList<PointOfInterestDataBaseEntity> pointsOfInterest;

    public RealmList<PointOfInterestDataBaseEntity> getPointsOfInterest() {
        return pointsOfInterest;
    }

    public void setPointsOfInterest(RealmList<PointOfInterestDataBaseEntity> pointsOfInterest) {
        this.pointsOfInterest = pointsOfInterest;
    }
}
