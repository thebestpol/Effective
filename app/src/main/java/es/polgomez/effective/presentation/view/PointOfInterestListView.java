package es.polgomez.effective.presentation.view;

import es.polgomez.effective.presentation.model.PointOfInterestModel;
import es.polgomez.effective.presentation.model.PointsOfInterestModel;

/**
 * View that represents a list of PointOfInterestModel
 */
public interface PointOfInterestListView extends ProgressView {

    void renderPointsOfInterest(PointsOfInterestModel pointOfViews);

    void showPointOfInterest(PointOfInterestModel pointOfView);
}
