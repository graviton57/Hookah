package com.bshtef.hookah.data.repository.dummy;

import android.os.Handler;

import com.bshtef.hookah.data.model.Hookah;

import java.util.ArrayList;
import java.util.List;

public class HookahsRepository implements IHookahsRepository {

    ItemsListener listener;

    public HookahsRepository(ItemsListener listener) {
        this.listener = listener;
    }

    @Override
    public void getItems() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.success(initFakeData());
            }
        }, 3000);
    }


    private List<Hookah> initFakeData(){
        List<Hookah> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Hookah hookah = new Hookah();
            hookah.setName("KALIAN " + i);
            hookah.setDescription("KALIAN dec " + i);
            list.add(hookah);
        }

        return list;
    }

    public interface ItemsListener {
        void success(List<Hookah> hookahs);
        void error(String message);
    }
}
