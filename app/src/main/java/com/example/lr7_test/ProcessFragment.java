package com.example.lr7_test;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProcessFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_process, container, false);

        ProgressBar indicatorBar = (ProgressBar) view.findViewById(R.id.indicator);
        TextView statusView = (TextView) view.findViewById(R.id.statusView);
        Button btnFetch = (Button) view.findViewById(R.id.progressBtn);

        MyViewModel model = new ViewModelProvider(requireActivity()).get(MyViewModel.class);

        model.getValue().observe(getViewLifecycleOwner(), value -> {
            indicatorBar.setProgress(value);
            statusView.setText("Статус: " + value);
        });
        btnFetch.setOnClickListener(v -> model.execute());
        return view;
    }
}