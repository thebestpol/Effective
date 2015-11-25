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
import java.util.Collection;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.polgomez.effective.R;
import es.polgomez.effective.presentation.model.PointOfViewModel;
import es.polgomez.effective.presentation.presenter.PointOfViewListPresenter;
import es.polgomez.effective.presentation.view.PointOfViewListView;
import es.polgomez.effective.presentation.view.adapter.PointsOfViewAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements PointOfViewListView {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Bind(R.id.progressView)
    View progressView;

    private PointsOfViewAdapter pointsOfViewAdapter;

    PointOfViewListPresenter pointOfViewListPresenter;

    public MainActivityFragment() {
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

        pointsOfViewAdapter = new PointsOfViewAdapter(LayoutInflater.from(getActivity()),
                new ArrayList<PointOfViewModel>());
        pointsOfViewAdapter.setOnPointOfViewClickListener(
                new PointsOfViewAdapter.PointOfViewClickListener() {
                    @Override
                    public void onPointOfViewClick(PointOfViewModel pointOfViewModel) {
                        if (pointOfViewListPresenter != null && pointOfViewModel != null) {
                            pointOfViewListPresenter.onPointOfViewClicked(pointOfViewModel);
                        }
                    }
                });
        recyclerView.setAdapter(pointsOfViewAdapter);
    }


    @Override
    public void renderPointOfViewList(Collection<PointOfViewModel> pointOfViews) {
        pointsOfViewAdapter.updatePointsOfView(pointOfViews);
    }

    @Override
    public void showPointOfView(PointOfViewModel pointOfView) {
        // TODO detail view
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
}
