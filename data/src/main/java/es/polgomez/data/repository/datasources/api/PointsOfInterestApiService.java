package es.polgomez.data.repository.datasources.api;

import es.polgomez.data.repository.datasources.api.entity.ApiPointOfInterest;
import es.polgomez.data.repository.datasources.api.entity.ApiPointOfInterestList;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Retrofit API declaration
 */
public interface PointsOfInterestApiService {

    @GET("/points")
    Call<ApiPointOfInterestList> getPointsOfInterestList();

    @GET("/points/{id}")
    Call<ApiPointOfInterest> getPointOfInterest(@Path("id") int id);

}
