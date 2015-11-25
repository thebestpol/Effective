package es.polgomez.effective.presentation.presenter;

import es.polgomez.effective.presentation.model.PointOfInterestModel;
import es.polgomez.effective.presentation.view.PointOfInterestListView;

public class PointOfInterestListPresenter implements Presenter {

    private PointOfInterestListView pointOfViewListView;

    public void setView(PointOfInterestListView pointOfViewListView) {
        this.pointOfViewListView = pointOfViewListView;
    }

    public void onPointOfViewClicked(PointOfInterestModel pointOfView) {
        pointOfViewListView.showPointOfView(pointOfView);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
