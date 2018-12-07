package com.samirk433.ekindness;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


public class AppPrefManager {
    private static final String TAG = AppPrefManager.class.getSimpleName();

    private Context mContext;
    private SharedPreferences mPreference;
    private SharedPreferences.Editor mEditor;

    public AppPrefManager(Context context) {
        Log.d(TAG, "AppPrefManager()");

        this.mContext = context;
        mPreference = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mPreference.edit();
    }

}
