package es.polgomez.effective.presentation.mapper;

import es.polgomez.data.mapper.Mapper;
import es.polgomez.domain.PointOfInterest;
import es.polgomez.effective.presentation.model.PointOfInterestModel;

public class PointOfInterestModelMapper implements Mapper<PointOfInterestModel, PointOfInterest> {

    @Override
    public PointOfInterest modelToData(PointOfInterestModel model) {
        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setId(model.getId());
        pointOfInterest.setTitle(model.getTitle());

        return pointOfInterest;
    }

    @Override
    public PointOfInterestModel dataToModel(PointOfInterest data) {
        PointOfInterestModel pointOfInterestModel = new PointOfInterestModel();
        pointOfInterestModel.setId(data.getId());
        pointOfInterestModel.setTitle(data.getTitle());

        return pointOfInterestModel;
    }
}
