package com.bshtef.hookah.data.data;

import com.bshtef.hookah.data.core.interfaces.ITaskResult;

import java.util.List;

public class BaseRepository<T> {

    protected ITaskResult<T> callback;
    protected ITaskResult<List<T>> listCallback;


    public void setCallback(ITaskResult<T> callback){
        this.callback = callback;
    }

    public void setListCallback(ITaskResult<List<T>> listCallback){
        this.listCallback = listCallback;
    }

}
