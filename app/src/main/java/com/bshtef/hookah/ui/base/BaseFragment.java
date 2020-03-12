package com.bshtef.hookah.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.bshtef.hookah.util.UtilKeyboard;

public abstract class BaseFragment extends Fragment {

    protected View view;

    protected abstract @LayoutRes int getLayoutId();
    protected abstract void init();

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public final void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        init();
    }

    //FIND
    protected <T extends View> T findView(@IdRes int id) {
        return view.findViewById(id);
    }

    //TOAST
    protected void toast(@StringRes int text) {
        toast(getString(text));
    }

    protected void toast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    //KEYBOARD

    protected void keyboardShow(View view) {
        view.post(() -> UtilKeyboard.show(getActivity(), view));
    }

    protected void keyboardHide() {
        UtilKeyboard.hide(getActivity());
    }

    protected void keyboardHide(View view) {
        UtilKeyboard.hide(getActivity(), view);
    }

    //VISIBLE

    protected View visible(View view) {
        view.setVisibility(View.VISIBLE);
        return view;
    }

    protected View visible(View view, boolean visible) {
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return view;
    }

    protected View invisible(View view) {
        view.setVisibility(View.INVISIBLE);
        return view;
    }

    protected View gone(View view) {
        view.setVisibility(View.GONE);
        return view;
    }

    protected boolean isVisible(View view) {
        return view.getVisibility() == View.VISIBLE;
    }

    protected boolean isInvisible(View view) {
        return view.getVisibility() == View.INVISIBLE;
    }

    protected boolean isGone(View view) {
        return view.getVisibility() == View.GONE;
    }


}
