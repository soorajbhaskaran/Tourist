package com.example.tourist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReviewAdapter extends  RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>   {

    private Context context;
    private List<CustomerReview> reviewList;
    public ReviewAdapter(Context context, List<CustomerReview> reviewList){

        this.context = context;
        this.reviewList = reviewList;
    }
    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.review_item_layout, parent, false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        CustomerReview customerReview = reviewList.get(position);
        holder.customerName.setText(customerReview.getCustomerName());
        holder.reviewTxt.setText(customerReview.getCustomerReviewTxt());
        holder.reviewDate.setText(customerReview.getReviewDate());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView customerName, reviewTxt, reviewDate;
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            customerName = itemView.findViewById(R.id.customerNameTxt);
            reviewTxt = itemView.findViewById(R.id.customerReviewTxt);
            reviewDate = itemView.findViewById(R.id.customerReviewDate);
        }
    }
}
