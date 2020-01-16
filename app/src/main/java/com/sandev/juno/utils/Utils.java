package com.sandev.juno.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.Objects;

public class Utils {
    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @SuppressWarnings("deprecation")
    public static boolean isConnected(Context cont){
        ConnectivityManager conmag = (ConnectivityManager)cont.getSystemService(Context.CONNECTIVITY_SERVICE);
        if ( conmag != null ) {
            conmag.getActiveNetworkInfo();
            if (Objects.requireNonNull(conmag.getNetworkInfo(ConnectivityManager.TYPE_WIFI)).isConnected()) {
                return true;
            }
            return Objects.requireNonNull(conmag.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)).isConnected();
        }
        return false;
    }
}
