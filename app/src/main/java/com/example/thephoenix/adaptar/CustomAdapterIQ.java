package com.example.thephoenix.adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.thephoenix.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.example.thephoenix.model.LearnerIQ;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapterIQ extends RecyclerView.Adapter<CustomAdapterIQ.CustomViewHolder> {
    private List<LearnerIQ> learnersListIQ;
    private Context context;


    public CustomAdapterIQ(Context context, List<LearnerIQ> dataList) {
        this.context = context;
        this.learnersListIQ = dataList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.txtLearnerName.setText(learnersListIQ.get(position).getName());
        holder.txtLeanerDetails.setText(learnersListIQ.get(position).getScore() + " skill IQ score, " + learnersListIQ.get(position).getCountry());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(learnersListIQ.get(position).getBadgeUrl())
                .placeholder((R.drawable.load))
                .error(R.drawable.image_error_icon_5)
                .into(holder.badgeID);

    }

    @Override
    public int getItemCount() {
        return learnersListIQ.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtLearnerName;
        TextView txtLeanerDetails;
        private ImageView badgeID;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtLearnerName = mView.findViewById(R.id.learnerName);
            txtLeanerDetails = mView.findViewById(R.id.learnerDetails);
            badgeID = mView.findViewById(R.id.badgeID);
        }
    }
}
