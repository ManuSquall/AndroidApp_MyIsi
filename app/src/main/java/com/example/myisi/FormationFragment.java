package com.example.myisi;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FormationFragment extends Fragment {

    private ListView listFormation;
    private String[] tabFormation, tabDetails;
    private String formation, details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_formation, container, false);
        listFormation = view.findViewById(R.id.listFormation);
        tabFormation = getResources().getStringArray(R.array.tab_formation);
        tabDetails = getResources().getStringArray(R.array.tab_details);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tabFormation);

        //chargement des données au niveau de la liste
        listFormation.setAdapter(adapter);

        listFormation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                formation = tabFormation[position];
                details = tabDetails[position];

                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setIcon(R.mipmap.ic_launcher);
                dialog.setTitle(formation);
                dialog.setMessage(details);
                dialog.setNegativeButton(getString(R.string.back), null);
                dialog.setPositiveButton(getString(R.string.sign_up), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                // affiche la boite de dialogue
                dialog.show();
            }
        });

        return view;
    }
}