package de.cordulagloge.android.tourguideaugsburg;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class ListBinder {

    @BindingAdapter("bind:imageRes")
    public static void bindImage(ImageView view, int r) {
        view.setImageResource(r);
    }

    @BindingAdapter("bind:items")
    public static void bindList(ListView view, ArrayList<Places> placesList) {
        ListAdapter adapter = new PlacesAdapter(view.getContext(), placesList);
        view.setAdapter(adapter);
    }
}
