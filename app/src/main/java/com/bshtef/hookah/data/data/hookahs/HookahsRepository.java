package com.bshtef.hookah.data.data.hookahs;

import com.bshtef.hookah.data.data.BaseRepository;
import com.bshtef.hookah.data.data.dummy.DummyData;
import com.bshtef.hookah.data.model.Hookah;

public class HookahsRepository extends BaseRepository<Hookah> implements IHookahsRepository {

    private static HookahsRepository instance;

    public static HookahsRepository getInstance() {
        if (instance == null) instance = new HookahsRepository();
        return instance;
    }

    @Override
    public void getItems() {
        if (listCallback != null) listCallback.result(DummyData.getDummyHookahs());
    }

}
