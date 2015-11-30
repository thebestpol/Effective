package es.polgomez.effective.presentation.presenter.modules.detail;

import es.polgomez.domain.PointOfInterestDetail;
import es.polgomez.domain.interactors.pointofinterest.GetPointOfInterestDetail;
import es.polgomez.effective.presentation.mapper.PointOfInterestDetailModelMapper;
import es.polgomez.effective.presentation.presenter.Presenter;
import es.polgomez.effective.presentation.view.PointOfInterestDetailView;
import rx.Subscriber;

/**
 * Presenter created to show detail view of a point of interest.
 *
 * This class is attached to the Fragment lifecycle.
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
            view.showProgress();
        }

        getPointOfInterestDetail.execute(new Subscriber<PointOfInterestDetail>() {
            @Override
            public void onCompleted() {
                view.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(PointOfInterestDetail pointOfInterestDetail) {
                showPointOfInterestDetail(pointOfInterestDetail);
            }
        });

    }

    private void showPointOfInterestDetail(PointOfInterestDetail pointOfInterestDetail) {
        PointOfInterestDetailModelMapper mapper = new PointOfInterestDetailModelMapper();
        view.renderPointOfInterest(mapper.dataToModel(pointOfInterestDetail));
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
