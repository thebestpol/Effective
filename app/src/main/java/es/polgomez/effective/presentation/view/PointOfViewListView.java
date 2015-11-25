package es.polgomez.effective.presentation.view;

import java.util.Collection;

import es.polgomez.effective.presentation.model.PointOfViewModel;

/**
 * View that represents a list of PointOfViewModel
 */
public interface PointOfViewListView extends ProgressView {

    void renderPointOfViewList(Collection<PointOfViewModel> pointOfViews);

    void showPointOfView(PointOfViewModel pointOfView);
}
