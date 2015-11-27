package es.polgomez.domain.repository;


import java.util.List;

import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointOfInterestDetail;
import rx.Observable;

public interface PointOfInterestRepository {

    Observable<List<PointOfInterest>> getPointsOfInterest();

    Observable<PointOfInterestDetail> getPointsOfInterest(int pointId);

}
