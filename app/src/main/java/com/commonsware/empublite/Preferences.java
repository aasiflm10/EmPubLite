package com.commonsware.empublite;

import android.app.Activity;
import android.preference.PreferenceFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;

public class Preferences extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(getFragmentManager().findFragmentById(R.id.content) == null) {
            getFragmentManager().beginTransaction().add(android.R.id.content, new Display()).commit();
        }
    }

    public static class Display extends PreferenceFragment {
        @Override
        public void onCreate( Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            addPreferencesFromResource(R.xml.pref_display);
        }
    }
}