package es.polgomez.effective.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.polgomez.effective.presentation.model.PointOfInterestModel;
import es.polgomez.effective.presentation.model.PointsOfInterestModel;

public class PointsOfInterestAdapter extends RecyclerView.Adapter<PointsOfInterestAdapter.PointsOfViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<PointOfInterestModel> pointsOfInterest;
    private PointOfViewClickListener pointOfViewClickListener;

    public PointsOfInterestAdapter(LayoutInflater layoutInflater, Collection<PointOfInterestModel> pointsOfView) {
        this.layoutInflater = layoutInflater;
        this.pointsOfInterest = (List<PointOfInterestModel>) pointsOfView;
    }

    public void setOnPointOfViewClickListener(PointOfViewClickListener pointOfViewClickListener) {
        this.pointOfViewClickListener = pointOfViewClickListener;
    }

    @Override
    public PointsOfViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        return new PointsOfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PointsOfViewHolder holder, int position) {
        final PointOfInterestModel pointOfView = pointsOfInterest.get(position);
        holder.text1.setText(pointOfView.getTitle());
        if (pointOfViewClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pointOfViewClickListener.onPointOfViewClick(pointOfView);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return pointsOfInterest == null ? 0 : pointsOfInterest.size();
    }

    public void updatePointsOfView(PointsOfInterestModel pointsOfInterest) {
        if (pointsOfInterest != null) {
            this.pointsOfInterest = pointsOfInterest.getPointsOfInterest();
            notifyDataSetChanged();
        }
    }

    static class PointsOfViewHolder extends RecyclerView.ViewHolder {

        @Bind(android.R.id.text1)
        TextView text1;

        public PointsOfViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface PointOfViewClickListener {

        void onPointOfViewClick(PointOfInterestModel pointOfInterestModel);
    }
}
