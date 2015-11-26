package es.polgomez.domain.repository;


import java.util.List;

import es.polgomez.domain.PointOfInterest;
import rx.Observable;

public interface PointOfInterestRepository {

    Observable<List<PointOfInterest>> getPointOfInterests();

    Observable<PointOfInterest> getPointOfInterest(int pointId);

}
