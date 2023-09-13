package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScienceFragment extends Fragment {


    String api = "2a1a8c6564114b3eb59f17a30ea0dcd4";
    private RecyclerView recyclerViewofscience;
    Adapter adapter;
    ArrayList<Model> modelArrayList;
    String country = "in";
    private String category = "science";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_science, container, false);

        recyclerViewofscience = v.findViewById(R.id.recyclerviewofscience);
        modelArrayList= new ArrayList<>();
        adapter = new Adapter(getContext(),modelArrayList);
        recyclerViewofscience.setAdapter(adapter);
        recyclerViewofscience.setLayoutManager(new LinearLayoutManager(getContext()));

        findNews();
        return v;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {

                if (response.isSuccessful()){
                    modelArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}