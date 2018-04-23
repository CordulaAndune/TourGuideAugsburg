package de.cordulagloge.android.tourguideaugsburg;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PlacesAdapter extends ArrayAdapter<Places> {
    private LayoutInflater layoutInflater;

    public PlacesAdapter(@NonNull Context context, @NonNull List<Places> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // check if convertView can be recycled, else inlate new view
        if (convertView == null) {
            layoutInflater = (LayoutInflater) parent.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert layoutInflater != null;
            convertView = layoutInflater.inflate(R.layout.list_item, parent, false);
        }

        //add place into convertView
        Places currentPlace = getItem(position);
        TextView name = convertView.findViewById(R.id.name);
        assert currentPlace != null;
        name.setText(getContext().getString(currentPlace.getName()));

        TextView distance = convertView.findViewById(R.id.distance);
        distance.setText(getContext().getString(currentPlace.getDistance()));

        //if imageresource id is avaible, show image, else hide view
        ImageView image = convertView.findViewById(R.id.place_image);
        if (currentPlace.checkForImage()) {
            image.setImageResource(currentPlace.getImageSmallId());
        } else {
            image.setVisibility(View.GONE);
        }

        return convertView;
    }
}
