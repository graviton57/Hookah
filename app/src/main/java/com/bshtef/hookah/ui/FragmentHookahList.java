package com.bshtef.hookah.ui;

import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bshtef.hookah.R;
import com.bshtef.hookah.data.core.interfaces.ITaskResult;
import com.bshtef.hookah.data.model.Hookah;
import com.bshtef.hookah.data.data.hookahs.HookahsRepository;
import com.bshtef.hookah.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentHookahList extends BaseFragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private HookahAdapter adapter;
    private HookahsRepository repository;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hookah_list;
    }

    @Override
    protected void init() {
        recyclerView = findView(R.id.rv);
        progressBar = findView(R.id.progress);

        initList();
        initRepository();
    }

    private void initList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new HookahAdapter(new ArrayList<>(), hookah -> {
        });
        recyclerView.setAdapter(adapter);
    }

    private void initRepository() {
        repository = HookahsRepository.getInstance();
        repository.setListCallback(new ITaskResult<List<Hookah>>() {
            @Override
            public void result(@Nullable List<Hookah> result) {
                adapter.setArticles(result);
            }

            @Override
            public void error(@NonNull String error) {

            }
        });
        repository.getItems();
    }
}
