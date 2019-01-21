package com.prospec.prospecservice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarketingFragment extends Fragment {


        public MarketingFragment() {
            // Required empty public constructor
        }

        public static MarketingFragment marketingInstance(String jsonString) {

            MarketingFragment marketingFragment = new MarketingFragment();
            Bundle bundle = new Bundle();
            bundle.putString("json", jsonString);
            marketingFragment.setArguments(bundle);
            return marketingFragment;

        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

//        Create RecyclerView
            RecyclerView recyclerView = getView().findViewById(R.id.recyclerMarketing);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);

            try {

                JSONArray jsonArray = new JSONArray(getArguments().getString("json"));

                ArrayList<String> jobNoStringArrayList = new ArrayList<>();
                ArrayList<String> jobEventStringArrayList = new ArrayList<>();
                ArrayList<String> cutNameStringArrayList = new ArrayList<>();

                for (int i = 0; i < jsonArray.length(); i += 1) {

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    jobNoStringArrayList.add(jsonObject.getString("job_no"));
                    jobEventStringArrayList.add(jsonObject.getString("job_event"));
                    cutNameStringArrayList.add(jsonObject.getString("customer_name"));

                }

                MarketingAdapter marketingAdapter = new MarketingAdapter(getActivity(), jobNoStringArrayList, jobEventStringArrayList, cutNameStringArrayList, new OnClickItem() {
                    @Override
                    public void onClickItem(View view, int position) {

                    }
                });
                recyclerView.setAdapter(marketingAdapter);

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_marketing, container, false);
        }

    }