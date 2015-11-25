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
import es.polgomez.effective.presentation.model.PointOfViewModel;

public class PointsOfViewAdapter extends RecyclerView.Adapter<PointsOfViewAdapter.PointsOfViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<PointOfViewModel> pointsOfView;
    private PointOfViewClickListener pointOfViewClickListener;

    public PointsOfViewAdapter(LayoutInflater layoutInflater, Collection<PointOfViewModel> pointsOfView) {
        this.layoutInflater = layoutInflater;
        this.pointsOfView = (List<PointOfViewModel>) pointsOfView;
    }

    public void setOnPointOfViewClickListener(PointOfViewClickListener pointOfViewClickListener) {
        this.pointOfViewClickListener = pointOfViewClickListener;
    }

    @Override
    public PointsOfViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

        return new PointsOfViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PointsOfViewHolder holder, int position) {
        final PointOfViewModel pointOfView = pointsOfView.get(position);
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
        return pointsOfView == null ? 0 : pointsOfView.size();
    }

    public void updatePointsOfView(Collection<PointOfViewModel> pointsOfView) {
        if (pointsOfView != null) {
            this.pointsOfView = (List<PointOfViewModel>) pointsOfView;
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

        void onPointOfViewClick(PointOfViewModel pointOfViewModel);
    }
}
