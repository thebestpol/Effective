package es.polgomez.data.repository.datasources.api.service;

import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterest;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestList;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Retrofit API declaration
 */
public interface PointsOfInterestApiService {

    String API_SERVICE_ENDPOINT = "http://t21services.herokuapp.com";

    @GET("/points")
    Observable<ApiPointOfInterestList> getApiPointsOfInterestList();

    @GET("/points/{id}")
    Observable<ApiPointOfInterest> getApiPointOfInterest(@Path("id") int id);

}
