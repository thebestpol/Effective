package es.polgomez.effective.presentation.view;

import java.util.Collection;

import es.polgomez.effective.presentation.model.PointOfInterestModel;

/**
 * View that represents a list of PointOfInterestModel
 */
public interface PointOfInterestListView extends ProgressView {

    void renderPointOfViewList(Collection<PointOfInterestModel> pointOfViews);

    void showPointOfView(PointOfInterestModel pointOfView);
}
