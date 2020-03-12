package com.bshtef.hookah.data.core.interfaces;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface ITaskResult<T> {
    void result(@Nullable T result);
    void error(@NonNull String error);
}
