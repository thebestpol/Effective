package es.polgomez.effective.presentation.presenter;

import es.polgomez.effective.presentation.model.PointOfViewModel;
import es.polgomez.effective.presentation.view.PointOfViewListView;

public class PointOfViewListPresenter implements Presenter {

    private PointOfViewListView pointOfViewListView;

    public void setView(PointOfViewListView pointOfViewListView) {
        this.pointOfViewListView = pointOfViewListView;
    }

    public void onPointOfViewClicked(PointOfViewModel pointOfView) {
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
