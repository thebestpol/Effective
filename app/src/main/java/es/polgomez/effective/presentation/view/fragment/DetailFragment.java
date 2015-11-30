package es.polgomez.effective.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.polgomez.effective.R;
import es.polgomez.effective.presentation.model.PointOfInterestDetailModel;
import es.polgomez.effective.presentation.view.PointOfInterestDetailView;

public class DetailFragment extends Fragment implements PointOfInterestDetailView {

    private static final String ARGUMENT_KEY_POI_ID = "argumentKeyPoiId";
    @Bind(R.id.detail_top_text)
    TextView topText;
    @Bind(R.id.detail_middle_text)
    TextView middleText;
    @Bind(R.id.detail_bottom_text)
    TextView bottomText;

    @Bind(R.id.progressView)
    View progressView;

    public static DetailFragment newInstance(int pointOfInterestId) {
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_KEY_POI_ID, pointOfInterestId);

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(args);

        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void renderPointOfInterest(PointOfInterestDetailModel pointOfInterestDetailModel) {
        topText.setText(pointOfInterestDetailModel.getTitle());
        middleText.setText(pointOfInterestDetailModel.getAddress());
        bottomText.setText(pointOfInterestDetailModel.getDescription());
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
        return isAdded() && topText != null && bottomText != null && middleText != null;
    }

    @Override
    public boolean isAlreadyLoaded() {
        return topText.getText().toString() != null;
    }

    @Override
    public void showEmptyCase() {
        // TODO show empty view
    }
}
