package es.polgomez.effective.presentation.view;

import es.polgomez.effective.presentation.model.PointOfInterestDetailModel;

public interface PointOfInterestDetailView extends ProgressView {

    void renderPointOfInterest(PointOfInterestDetailModel pointOfInterestDetailModel);

}
