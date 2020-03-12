package com.bshtef.hookah.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bshtef.hookah.R;
import com.bshtef.hookah.data.model.Hookah;
import com.bshtef.hookah.data.repository.dummy.HookahsRepository;

import java.util.ArrayList;
import java.util.List;

public class FragmentHookahList extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private HookahAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hookah_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView =  view.findViewById(R.id.rv);
        progressBar = view.findViewById(R.id.progress);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter = new HookahAdapter(new ArrayList<Hookah>(), new HookahAdapter.ClickListener(){
            @Override
            public void click(Hookah hookah) {

            }
        });

        recyclerView.setAdapter(adapter);

        HookahsRepository repository = new HookahsRepository(new HookahsRepository.ItemsListener() {
            @Override
            public void success(List<Hookah> hookahs) {
                adapter.setArticles(hookahs);
                recyclerView.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void error(String message) {

            }
        });

        repository.getItems();

    }
}
