package es.polgomez.data.repository.datasources.api.entities.mapper;

import java.util.ArrayList;
import java.util.List;

import es.polgomez.data.entities.PointOfInterestEntity;
import es.polgomez.data.entities.PointsOfInterestEntity;
import es.polgomez.data.mapper.Mapper;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestList;
import es.polgomez.data.repository.datasources.api.entities.ApiPointOfInterestListItem;

public class ApiPointsOfInterestMapper implements Mapper<PointsOfInterestEntity, ApiPointOfInterestList> {

    @Override
    public ApiPointOfInterestList modelToData(PointsOfInterestEntity model) {
        ApiPointOfInterestMapper mapper = new ApiPointOfInterestMapper();

        ApiPointOfInterestList apiPointOfInterestList = new ApiPointOfInterestList();

        List<ApiPointOfInterestListItem> apiPointsOfInterest = new ArrayList<>();
        for (PointOfInterestEntity pointOfInterestEntity : model.getPointsOfInterest()) {
            apiPointsOfInterest.add(mapper.modelToData(pointOfInterestEntity));
        }

        apiPointOfInterestList.setList(apiPointsOfInterest);

        return apiPointOfInterestList;
    }

    @Override
    public PointsOfInterestEntity dataToModel(ApiPointOfInterestList data) {
        ApiPointOfInterestMapper mapper = new ApiPointOfInterestMapper();

        List<PointOfInterestEntity> pointsOfInterestList = new ArrayList<>();

        PointsOfInterestEntity pointsOfInterest = new PointsOfInterestEntity();
        for (ApiPointOfInterestListItem apiPointOfInterestListItem : data.getList()) {
            pointsOfInterestList.add(mapper.dataToModel(apiPointOfInterestListItem));
        }

        pointsOfInterest.setPointsOfInterest(pointsOfInterestList);

        return pointsOfInterest;
    }
}
