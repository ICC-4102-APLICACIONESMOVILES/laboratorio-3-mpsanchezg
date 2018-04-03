package com.example.mpsan.laboratorio2;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.mpsan.laboratorio2.databases.FormDatabase;


public class FormSummaryFragment extends Fragment {
    private static final String DATABASE_NAME = "forms_db";
    private FormDatabase formsDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form_summary, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        formsDatabase = Room.databaseBuilder(view.getContext(),
                FormDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
        
    }


}
