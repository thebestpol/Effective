package es.polgomez.domain.repository;


import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.PointsOfInterest;
import rx.Observable;

public interface PointOfInterestRepository {

    Observable<PointsOfInterest> getPointsOfInterest();

    Observable<PointOfInterestDetail> getPointsOfInterest(int pointId);

}
