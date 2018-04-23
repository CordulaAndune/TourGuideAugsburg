package de.cordulagloge.android.tourguideaugsburg;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NightlifeFragment extends Fragment {


    public NightlifeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        final ArrayList<Places> sightsList = new ArrayList<>();
        sightsList.add(new Places(R.string.ballonfabrik, R.string.oberhausen, R.string.ballonfabrik_description,
                R.string.ballonfabrik_link, new double[]{48.389290, 10.887889}));
        sightsList.add(new Places(R.string.barfly, R.string.inner_city, R.string.barfly_description
                , R.string.barfly_link, new double[]{48.363892, 10.899569}));
        sightsList.add(new Places(R.string.enchilada, R.string.inner_city, R.string.enchilada_description,
                R.string.enchilada_link, new double[]{48.364581, 10.899115}));
        sightsList.add(new Places(R.string.glimmer_bar, R.string.inner_city, R.string.glimmer_bar_description
                , R.string.glimmer_bar_link, new double[]{48.371110, 10.898280}));
        sightsList.add(new Places(R.string.kantine, R.string.kriegshaber, R.string.kantine_description
                , R.string.kantine_link, new double[]{48.375460, 10.866770}));
        sightsList.add(new Places(R.string.kesselhaus, R.string.oberhausen, R.string.kesselhaus_description
                , R.string.kesselhaus_link, new double[]{48.385588, 10.891412}));
        sightsList.add(new Places(R.string.kradhalle, R.string.kriegshaber, R.string.kradhalle_description,
                R.string.kradhalle_link, new double[]{48.375515, 10.868137}));
        sightsList.add(new Places(R.string.kreuzweise, R.string.inner_city, R.string.kreuzweise_description
                , R.string.kreuzweise_link, new double[]{48.364440, 10.895790}));
        sightsList.add(new Places(R.string.kultstrand, R.string.spickel, R.string.kultstrand_description
                , R.string.kultstrand_link, new double[]{48.371822, 10.918162}));
        sightsList.add(new Places(R.string.flannigans, R.string.inner_city, R.string.flannigans_description,
                R.string.flannigans_link, new double[]{48.367358, 10.893391}));
        sightsList.add(new Places(R.string.haifischbar, R.string.inner_city, R.string.haifischbar_description
                , R.string.haifischbar_link, new double[]{48.361233, 10.902921}));
        sightsList.add(new Places(R.string.mahagoni_bar, R.string.inner_city, R.string.mahagoni_bar_description
                , R.string.mahagoni_bar_link, new double[]{48.363157, 10.900482}));
        sightsList.add(new Places(R.string.murdocks, R.string.inner_city, R.string.murdocks_description
                , R.string.murdocks_link, new double[]{48.360019, 10.902639}));
        sightsList.add(new Places(R.string.mo, R.string.spickel, R.string.mo_description
                , R.string.mo_link, new double[]{48.364190, 10.900529}));
        sightsList.add(new Places(R.string.murphys, R.string.inner_city, R.string.murphys_description
                , R.string.murphys_link, new double[]{48.375816, 10.894973}));
        sightsList.add(new Places(R.string.ostwerk, R.string.lechhausen, R.string.ostwerk_description
                , R.string.ostwerk_link, new double[]{48.367920, 10.933550}));
        sightsList.add(new Places(R.string.rockfabrik, R.string.oberhausen, R.string.rockfabrik_description
                , R.string.rockfabrik_link, new double[]{48.384483, 10.889629}));
        sightsList.add(new Places(R.string.rock_cafe, R.string.oberhausen, R.string.rock_cafe_description
                , R.string.rock_cafe_link, new double[]{48.379311, 10.850061}));
        sightsList.add(new Places(R.string.schwarzes_schaf, R.string.inner_city, R.string.schwarzes_schaf_description
                , R.string.schwarzes_schaf_link, new double[]{48.370933, 10.893300}));
        sightsList.add(new Places(R.string.spectrum, R.string.oberhausen, R.string.spectrum_description
                , R.string.spectrum_link, new double[]{48.380091, 10.849902}));

        GridView sightsListView = rootView.findViewById(R.id.listview);
        PlacesAdapter placesAdapter = new PlacesAdapter(getContext(), sightsList);
        sightsListView.setAdapter(placesAdapter);

        sightsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detailIntent = new Intent(getContext(), DetailsActivity.class);
                detailIntent.putExtra("currentPlace", sightsList.get(i));
                startActivity(detailIntent);
            }
        });

        return rootView;
    }
}
