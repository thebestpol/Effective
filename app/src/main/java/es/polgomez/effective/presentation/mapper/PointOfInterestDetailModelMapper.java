package es.polgomez.effective.presentation.mapper;

import es.polgomez.data.mapper.Mapper;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.effective.presentation.model.PointOfInterestDetailModel;

public class PointOfInterestDetailModelMapper implements Mapper<PointOfInterestDetailModel, PointOfInterestDetail> {

    @Override
    public PointOfInterestDetail modelToData(PointOfInterestDetailModel model) {
        PointOfInterestDetail pointOfInterestDetail = new PointOfInterestDetail();

        return pointOfInterestDetail;
    }

    @Override
    public PointOfInterestDetailModel dataToModel(PointOfInterestDetail data) {
        PointOfInterestDetailModel pointOfInterestDetailModel = new PointOfInterestDetailModel();

        return pointOfInterestDetailModel;
    }
}
