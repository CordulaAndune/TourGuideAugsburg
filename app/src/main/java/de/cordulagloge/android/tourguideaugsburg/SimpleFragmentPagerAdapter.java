package de.cordulagloge.android.tourguideaugsburg;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private final String[] tabTitles;

    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabTitles = new String[]{context.getString(R.string.sights),
                context.getString(R.string.activities),
                context.getString(R.string.restaurants),
                context.getString(R.string.nightlife)};
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SightsFragment();
            case 1:
                return new ActivitiesFragment();
            case 2:
                return new RestaurantsFragment();
            case 3:
                return new NightlifeFragment();
            default:
                return new SightsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
