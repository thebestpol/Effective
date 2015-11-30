package es.polgomez.effective.presentation.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.polgomez.effective.R;
import es.polgomez.effective.presentation.model.PointOfInterestModel;
import es.polgomez.effective.presentation.model.PointsOfInterestModel;
import es.polgomez.effective.presentation.presenter.modules.main.PointOfInterestListPresenter;
import es.polgomez.effective.presentation.view.PointOfInterestListView;
import es.polgomez.effective.presentation.view.adapter.PointsOfInterestAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements PointOfInterestListView {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.progressView)
    View progressView;

    private PointsOfInterestAdapter pointsOfInterestAdapter;

    private PointOfInterestListPresenter pointOfInterestListPresenter;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);
        initUI();

        return view;
    }

    private void initUI() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        pointsOfInterestAdapter = new PointsOfInterestAdapter(LayoutInflater.from(getActivity()),
                new ArrayList<PointOfInterestModel>());
        pointsOfInterestAdapter.setOnPointOfViewClickListener(
                new PointsOfInterestAdapter.PointOfViewClickListener() {
                    @Override
                    public void onPointOfViewClick(PointOfInterestModel pointOfInterestModel) {
                        if (pointOfInterestListPresenter != null && pointOfInterestModel != null) {
                            pointOfInterestListPresenter.onPointOfInterestClicked(pointOfInterestModel);
                        }
                    }
                });
        recyclerView.setAdapter(pointsOfInterestAdapter);
    }


    @Override
    public void renderPointsOfInterest(PointsOfInterestModel pointOfViews) {
        pointsOfInterestAdapter.updatePointsOfView(pointOfViews);
    }

    @Override
    public void showPointOfInterest(PointOfInterestModel pointOfView) {
        // TODO detail view navigate to detail
    }

    @Override
    public void showProgress() {
        progressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressView.setVisibility(View.GONE);
    }

    @Override
    public void showError(String errorMessage) {
        Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isReady() {
        return isAdded();
    }

    @Override
    public boolean isAlreadyLoaded() {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        return adapter != null && adapter.getItemCount() != 0;
    }

    @Override
    public void showEmptyCase() {
        // TODO show empty view
    }
}
