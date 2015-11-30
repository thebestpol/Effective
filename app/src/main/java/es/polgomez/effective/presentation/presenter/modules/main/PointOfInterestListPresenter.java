package es.polgomez.effective.presentation.presenter.modules.main;

import es.polgomez.domain.PointsOfInterest;
import es.polgomez.domain.interactors.pointofinterest.GetPointsOfInterest;
import es.polgomez.effective.presentation.mapper.PointsOfInterestModelMapper;
import es.polgomez.effective.presentation.model.PointOfInterestModel;
import es.polgomez.effective.presentation.presenter.Presenter;
import es.polgomez.effective.presentation.view.PointOfInterestListView;
import rx.Subscriber;

/**
 * Presenter created to show a list of points of interest.
 *
 * This class is attached to the Fragment lifecycle
 */
public class PointOfInterestListPresenter extends Presenter<PointOfInterestListView> {

    private GetPointsOfInterest getPointsOfInterest;

    public PointOfInterestListPresenter(GetPointsOfInterest getPointsOfInterest) {
        this.getPointsOfInterest = getPointsOfInterest;
    }

    public void onPointOfInterestClicked(PointOfInterestModel pointOfInterestModel) {
        view.showPointOfInterest(pointOfInterestModel);
    }

    @Override
    public void initialize() {
        checkVIewAlreadySetted();
        loadPointsOfInterest();
    }

    private void loadPointsOfInterest() {
        if (view.isReady()) {
            view.showProgress();
        }

        getPointsOfInterest.execute(new Subscriber<PointsOfInterest>() {
            @Override
            public void onCompleted() {
                view.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                view.hideProgress();
                view.showError(e.getMessage());
            }

            @Override
            public void onNext(PointsOfInterest pointsOfInterest) {
                showPointsOfInterest(pointsOfInterest);
            }
        });
    }

    private void showPointsOfInterest(PointsOfInterest pointsOfInterest) {
        PointsOfInterestModelMapper mapper = new PointsOfInterestModelMapper();
        view.renderPointsOfInterest(mapper.dataToModel(pointsOfInterest));
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
