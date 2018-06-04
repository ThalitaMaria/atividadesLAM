package com.example.alunos.androidtoolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SettingsFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup contrainer, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings_layout,
                contrainer, false);
        return v;
    }
}
