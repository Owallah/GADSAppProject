package com.mulutu.thephoenix;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.mulutu.thephoenix.model.LearnerHours;
import com.mulutu.thephoenix.util.ApiUtilsGet;
import com.mulutu.thephoenix.util.GetDataService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentLearningLeaders extends Fragment {

    private final String TAG = getClass().getSimpleName();

    private ViewGroup root;
    private ProgressDialog progressDialog;
    private com.example.thephoenix.adaptar.CustomAdapterHours learnerAdapter;
    private RecyclerView recyclerView;
    private List<LearnerHours> studentList = new ArrayList<>();

    private GetDataService getDataService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.fragment, null);

        getDataService = ApiUtilsGet.GetDataService();

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        //GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        //Call<List<LearnerHours>> call = service.getTopHoursLearners();
        getDataService.getTopHoursLearners().enqueue(new Callback<List<LearnerHours>>() {
            @Override
            public void onResponse(Call<List<LearnerHours>> call, Response<List<LearnerHours>> response) {
                progressDialog.dismiss();
                studentList = response.body();
                Collections.sort(studentList, Collections.reverseOrder());
                for (LearnerHours learner : studentList) {
                    learner.setCriteria(2); // learning leader
                }
                //Log.d(TAG, ">>>  studentList <<<" + studentList);
                generateDataList();
            }

            @Override
            public void onFailure(Call<List<LearnerHours>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList() {
        recyclerView = (RecyclerView) root.findViewById(R.id.recycler_view);
        learnerAdapter = new com.example.thephoenix.adaptar.CustomAdapterHours(this.getContext(), studentList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(learnerAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        //adapter.notifyDataSetChanged();
    }
}