package es.polgomez.data.repository.datasources.api.service;

import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterest;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestList;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Retrofit API declaration
 */
public interface PointsOfInterestApiService {

    // TODO continuar integrant retrofit

    String API_SERVICE_ENDPOINT = "http://t21services.herokuapp.com";

    @GET("/points")
    Call<ApiPointOfInterestList> getPointsOfInterestList();

    @GET("/points/{id}")
    Call<ApiPointOfInterest> getPointOfInterest(@Path("id") int id);

}
