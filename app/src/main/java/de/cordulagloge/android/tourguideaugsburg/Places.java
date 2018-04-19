package de.cordulagloge.android.tourguideaugsburg;

import android.os.Parcel;
import android.os.Parcelable;

public class Places implements Parcelable {
    private int mName, mDistance, mLink, mMapLink = -1;
    private int mImageResourceId, mDescription;

    public Places(int name, int distance, int description, int ImageResourceId, int link, int mapLink ){
        mName = name;
        mDistance = distance;
        mDescription = description;
        mImageResourceId = ImageResourceId;
        mLink = link;
        mMapLink = mapLink;
    }

    public Places(int name, int distance, int description, int ImageResourceId, int link){
        mName = name;
        mDistance = distance;
        mDescription = description;
        mImageResourceId = ImageResourceId;
        mLink = link;
    }

    public int getDescription() {
        return mDescription;
    }

    public int getLink() {
        return mLink;
    }

    /**
     * Get name of  place
     * @return places name
     */
    public int getName() {
        return mName;
    }

    /**
     * Get distance of  place
     * @return distance name
     */
    public int getDistance() {
        return mDistance;
    }

    /**
     * Get image rsource id of  place
     * @return Image resource id
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getMapLink() {
        return mMapLink;
    }

    public boolean checkForMapLink(){
        return mMapLink != -1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mName);
        dest.writeInt(this.mDistance);
        dest.writeInt(this.mMapLink);
        dest.writeInt(this.mImageResourceId);
        dest.writeInt(this.mDescription);
        dest.writeInt(this.mLink);
    }

    protected Places(Parcel in) {
        this.mName = in.readInt();
        this.mDistance = in.readInt();
        this.mMapLink = in.readInt();
        this.mImageResourceId = in.readInt();
        this.mDescription = in.readInt();
        this.mLink = in.readInt();
    }

    public static final Parcelable.Creator<Places> CREATOR = new Parcelable.Creator<Places>() {
        @Override
        public Places createFromParcel(Parcel source) {
            return new Places(source);
        }

        @Override
        public Places[] newArray(int size) {
            return new Places[size];
        }
    };
}
