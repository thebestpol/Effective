package es.polgomez.effective.presentation.mapper;

import java.util.ArrayList;
import java.util.List;

import es.polgomez.data.mapper.Mapper;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.domain.PointsOfInterest;
import es.polgomez.effective.presentation.model.PointOfInterestModel;
import es.polgomez.effective.presentation.model.PointsOfInterestModel;

public class PointsOfInterestModelMapper implements Mapper<PointsOfInterestModel, PointsOfInterest> {

    @Override
    public PointsOfInterest modelToData(PointsOfInterestModel model) {
        PointOfInterestModelMapper mapper = new PointOfInterestModelMapper();

        List<PointOfInterest> pointsOfInterestList = new ArrayList<>();

        PointsOfInterest pointsOfInterest = new PointsOfInterest();

        for (PointOfInterestModel pointOfInterestModel : model.getPointsOfInterest()) {
            pointsOfInterestList.add(mapper.modelToData(pointOfInterestModel));
        }
        pointsOfInterest.setPointsOfInterest(pointsOfInterestList);

        return pointsOfInterest;
    }

    @Override
    public PointsOfInterestModel dataToModel(PointsOfInterest data) {
        PointOfInterestModelMapper mapper = new PointOfInterestModelMapper();

        List<PointOfInterestModel> pointsOfInterestList = new ArrayList<>();

        PointsOfInterestModel pointsOfInterestModel = new PointsOfInterestModel();

        for (PointOfInterest pointOfInterest : data.getPointsOfInterest()) {
            pointsOfInterestList.add(mapper.dataToModel(pointOfInterest));
        }
        pointsOfInterestModel.setPointsOfInterest(pointsOfInterestList);

        return pointsOfInterestModel;
    }
}
