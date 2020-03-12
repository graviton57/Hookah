package com.bshtef.hookah.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class UtilKeyboard {

    private static final String TAG = UtilKeyboard.class.getSimpleName();

    public static void show(Context context, View view) {
        if (context != null && view != null) {
            try {
                InputMethodManager input = getInputManager(context);
                IBinder token = view.getWindowToken();
                if(input != null && token != null) {
                    input.hideSoftInputFromWindow(token, 0);
                    input.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
                }
            }
            catch (Exception e) { Log.e(TAG, "show", e); }
        }
    }

    public static void hide(Activity activity) {
        if(activity != null) {
            View view = activity.getCurrentFocus();
            if(view == null) {
                View contentView = activity.findViewById(android.R.id.content);
                if(contentView != null) view = contentView.getRootView();
            }
            hide(activity, view);
        }
    }

    public static void hide(Dialog dialog) {
        if(dialog != null) hide(dialog.getContext(), dialog.getCurrentFocus());
    }

    public static void hide(Context context, View view) {
        if(context != null && view != null) {
            try {
                InputMethodManager input = getInputManager(context);
                IBinder token = view.getWindowToken();
                if (input != null && token != null) input.hideSoftInputFromWindow(token, 0);
            } catch (Exception e) { Log.e(TAG, "hide", e); }
        }
    }

    private static InputMethodManager getInputManager(Context context) {
        return (InputMethodManager)context.getSystemService(Activity.INPUT_METHOD_SERVICE);
    }
}
