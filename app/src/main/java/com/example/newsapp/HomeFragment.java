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

public class HomeFragment extends Fragment {
    String api = "2a1a8c6564114b3eb59f17a30ea0dcd4";
    private RecyclerView recyclerViewofhome;
    Adapter adapter;
    ArrayList<Model>modelArrayList;
    String country = "in";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
       recyclerViewofhome = view.findViewById(R.id.recyclerviewofhome);
       modelArrayList = new ArrayList<>();
       recyclerViewofhome.setLayoutManager(new LinearLayoutManager(getContext()));
       adapter = new Adapter(getContext(),modelArrayList);
       recyclerViewofhome.setAdapter(adapter);

       findNews();
       return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getNews(country,100,api).enqueue(new Callback<MainNews>() {
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