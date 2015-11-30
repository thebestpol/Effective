package es.polgomez.effective.presentation.mapper;

import es.polgomez.data.mapper.Mapper;
import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.effective.presentation.model.PointOfInterestDetailModel;

public class PointOfInterestDetailModelMapper implements Mapper<PointOfInterestDetailModel, PointOfInterestDetail> {

    @Override
    public PointOfInterestDetail modelToData(PointOfInterestDetailModel model) {
        PointOfInterestDetail pointOfInterestDetail = new PointOfInterestDetail();
        pointOfInterestDetail.setId(Integer.valueOf(model.getId()));
        pointOfInterestDetail.setTitle(model.getTitle());
        pointOfInterestDetail.setAddress(model.getAddress());
        pointOfInterestDetail.setDescription(model.getDescription());
        return pointOfInterestDetail;
    }

    @Override
    public PointOfInterestDetailModel dataToModel(PointOfInterestDetail data) {
        PointOfInterestDetailModel pointOfInterestDetailModel = new PointOfInterestDetailModel();
        pointOfInterestDetailModel.setId(Integer.toString(data.getId()));
        pointOfInterestDetailModel.setDescription(data.getDescription());
        pointOfInterestDetailModel.setTitle(data.getTitle());
        pointOfInterestDetailModel.setAddress(data.getAddress());

        return pointOfInterestDetailModel;
    }
}
