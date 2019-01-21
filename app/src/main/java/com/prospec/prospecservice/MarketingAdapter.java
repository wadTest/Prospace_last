package com.prospec.prospecservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class MarketingAdapter extends RecyclerView.Adapter<MarketingAdapter.LoanViewHolder>{

    private Context context;
    private ArrayList<String> jobNoStringArrayList, jobEventStringArrayList, cusNameStringArrayList;
    private OnClickItem onClickItem;
    private LayoutInflater layoutInflater;

    public MarketingAdapter(Context context, ArrayList<String> jobNoStringArrayList, ArrayList<String> jobEventStringArrayList, ArrayList<String> cusNameStringArrayList, OnClickItem onClickItem) {
        this.layoutInflater = LayoutInflater.from(context);
        this.jobNoStringArrayList = jobNoStringArrayList;
        this.jobEventStringArrayList = jobEventStringArrayList;
        this.cusNameStringArrayList = cusNameStringArrayList;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public LoanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recyclerview_marketing, parent, false);
        LoanViewHolder loanViewHolder = new LoanViewHolder(view);

        return loanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LoanViewHolder holder, int position) {

        String jobNoString = jobNoStringArrayList.get(position);
        String jobEventstring = jobEventStringArrayList.get(position);
        String cusNameString = cusNameStringArrayList.get(position);

        holder.jobNoTextView.setText(jobNoString);
        holder.jobEventTextView.setText(jobEventstring);
        holder.cusNameTextView.setText(cusNameString);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.onClickItem(v, holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return jobNoStringArrayList.size();
    }

    public class LoanViewHolder extends RecyclerView.ViewHolder {

        private TextView jobNoTextView, jobEventTextView, cusNameTextView;

        public LoanViewHolder(View itemView) {
            super(itemView);

            jobNoTextView = itemView.findViewById(R.id.txtJobNo);
            jobEventTextView = itemView.findViewById(R.id.txtJobEvent);
            cusNameTextView = itemView.findViewById(R.id.txtCusName);

        }
    }    //Second Class

}   // Main Class