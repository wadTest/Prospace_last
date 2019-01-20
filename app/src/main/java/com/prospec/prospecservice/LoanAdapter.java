package com.prospec.prospecservice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prospec.prospecservice.status.LoanOfficerActivity;

import java.util.ArrayList;

public class LoanAdapter extends RecyclerView.Adapter<LoanAdapter.LoanViewHolder> {

    private Context context;
    private ArrayList<String> jobNoStringsArrayList, jobEventStringsArrayList, susNameStringsArrayList;
    private OnClickItem onClickItem;
    private LayoutInflater layoutInflater;

    public LoanAdapter(Context context, ArrayList<String> jobNoStringsArrayList, ArrayList<String> jobEventStringsArrayList, ArrayList<String> susNameStringsArrayList, OnClickItem onClickItem) {
        this.layoutInflater = LayoutInflater.from(context);
        this.jobNoStringsArrayList = jobNoStringsArrayList;
        this.jobEventStringsArrayList = jobEventStringsArrayList;
        this.susNameStringsArrayList = susNameStringsArrayList;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public LoanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.recyclerview_loan, parent, false);
        LoanViewHolder loanViewHolder = new LoanViewHolder(view);

        return loanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final LoanViewHolder holder, int position) {

        String jonNoString = jobNoStringsArrayList.get(position);
        String joEventString = jobNoStringsArrayList.get(position);
        String cusNameString = jobNoStringsArrayList.get(position);

        holder.jomNoTextView.setText(jonNoString);
        holder.jobEventTextView.setText(joEventString) ;
        holder.cumNameTextView.setText(cusNameString);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.onClickItem(v, holder.getAdapterPosition());
            }
        });


    }

    @Override
    public int getItemCount() {
        return jobNoStringsArrayList.size();
    }

    public class LoanViewHolder extends RecyclerView.ViewHolder {

        private TextView jomNoTextView, jobEventTextView, cumNameTextView;

        public LoanViewHolder(View itemView) {
            super(itemView);

            jomNoTextView = itemView.findViewById(R.id.txtJobNo);
            jobEventTextView = itemView.findViewById(R.id.txtJobEvent);
            cumNameTextView = itemView.findViewById(R.id.txtCustomerName);
        }
    }//Second Class


}//Main Class
