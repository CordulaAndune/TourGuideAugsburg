package de.cordulagloge.android.tourguideaugsburg;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantsFragment extends Fragment {


    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_places, container, false);

        final ArrayList<Places> sightsList = new ArrayList<>();
        sightsList.add(new Places(R.string.al_theatro, R.string.inner_city, R.string.al_theatro_description,
                 R.string.al_theatro_link, new double[]{48.366177, 10.902402}));
        sightsList.add(new Places(R.string.anna_cafe, R.string.inner_city, R.string.anna_cafe_description
                , R.string.anna_cafe_link, new double[]{48.367757, 10.894701}));
        sightsList.add(new Places(R.string.anno_1578, R.string.inner_city, R.string.anno_1578_description,
                R.string.anno_1578_link, new double[]{48.367437, 10.896844}));
        sightsList.add(new Places(R.string.aposto, R.string.inner_city, R.string.aposto_description
                , R.string.aposto_link, new double[]{48.369010, 10.897160}));
        sightsList.add(new Places(R.string.azsteakas, R.string.inner_city, R.string.azsteakas_description
                , R.string.azsteakas_link, new double[]{48.370591, 10.919490099999962}));
        sightsList.add(new Places(R.string.bobs, R.string.oberhausen, R.string.bobs_description
                , R.string.bobs_link, new double[]{48.381245, 10.874450}));
        sightsList.add(new Places(R.string.bauerntanz, R.string.inner_city, R.string.bauerntanz_description,
                R.string.bauerntanz_link, new double[]{48.367703, 10.900569}));
        sightsList.add(new Places(R.string.himmelgruen, R.string.inner_city, R.string.himmelgruen_description
                , R.string.himmelgruen_link, new double[]{48.371951, 10.920673}));
        sightsList.add(new Places(R.string.kombinat, R.string.inner_city, R.string.kombinat_description
                , R.string.kombinat_link, new double[]{48.365400, 10.897290}));
        sightsList.add(new Places(R.string.flannigans, R.string.inner_city, R.string.flannigans_description,
                R.string.flannigans_link, new double[]{48.367358, 10.893391}));
        sightsList.add(new Places(R.string.haifischbar, R.string.inner_city, R.string.haifischbar_description
                , R.string.haifischbar_link, new double[]{48.361233, 10.902921}));
        sightsList.add(new Places(R.string.kahnfahrt, R.string.inner_city, R.string.kahnfahrt_description
                , R.string.kahnfahrt_link, new double[]{48.375290, 10.905690}));
        sightsList.add(new Places(R.string.murdocks, R.string.inner_city, R.string.murdocks_description
                , R.string.murdocks_link, new double[]{48.360019, 10.902639}));
        sightsList.add(new Places(R.string.parkhaeusl, R.string.spickel, R.string.parkhaeusl_description
                , R.string.parkhaeusl_link, new double[]{48.346638, 10.911004}));
        sightsList.add(new Places(R.string.ratskeller, R.string.inner_city, R.string.ratskeller_description
                , R.string.ratskeller_link, new double[]{48.368708, 10.898660}));
        sightsList.add(new Places(R.string.rheingold, R.string.spickel, R.string.rheingold_description
                , R.string.rheingold_link, new double[]{48.360760, 10.908008}));
        sightsList.add(new Places(R.string.thalia, R.string.inner_city, R.string.thalia_description
                , R.string.thalia_link, new double[]{48.370787, 10.896890}));

        ListView sightsListView = rootView.findViewById(R.id.listview);
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
