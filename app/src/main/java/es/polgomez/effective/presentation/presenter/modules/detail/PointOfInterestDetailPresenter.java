package es.polgomez.effective.presentation.presenter.modules.detail;

import es.polgomez.domain.interactors.pointofinterest.GetPointOfInterestDetail;
import es.polgomez.effective.presentation.presenter.Presenter;
import es.polgomez.effective.presentation.view.PointOfInterestDetailView;

/**
 * Created by PoL on 30/11/15.
 */
public class PointOfInterestDetailPresenter extends Presenter<PointOfInterestDetailView>{

    private final GetPointOfInterestDetail getPointOfInterestDetail;

    public PointOfInterestDetailPresenter(GetPointOfInterestDetail getPointOfInterestDetail) {
        this.getPointOfInterestDetail = getPointOfInterestDetail;
    }

    @Override
    public void initialize() {
        checkVIewAlreadySetted();
        loadPointOfInterestDetail();
    }

    private void loadPointOfInterestDetail() {
        if (view.isReady()) {
            v
        }
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
