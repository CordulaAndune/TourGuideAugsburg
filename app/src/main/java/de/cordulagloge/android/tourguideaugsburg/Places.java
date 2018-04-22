package de.cordulagloge.android.tourguideaugsburg;

import android.os.Parcel;
import android.os.Parcelable;

public class Places implements Parcelable {
    private int mName, mDistance, mLink;
    private int mImageResourceId, mImageSmallId, mDescription;
    private double[] mMapLink;
    private int hasMapLink;
    private int hasImages;

    public Places(int name, int distance, int description, int ImageResourceId, int ImageSmallId, int link, double[] mapLink ){
        mName = name;
        mDistance = distance;
        mDescription = description;
        mImageResourceId = ImageResourceId;
        mImageSmallId = ImageSmallId;
        mLink = link;
        mMapLink = mapLink;
        hasMapLink = 0;
        hasImages = 0;
    }

    public Places(int name, int distance, int description, int link, double[] mapLink ){
        mName = name;
        mDistance = distance;
        mDescription = description;
        mLink = link;
        mMapLink = mapLink;
        hasMapLink = 0;
        hasImages = 1;
    }

    public Places(int name, int distance, int description, int ImageResourceId, int ImageSmallId, int link){
        mName = name;
        mDistance = distance;
        mDescription = description;
        mImageResourceId = ImageResourceId;
        mImageSmallId = ImageSmallId;
        mLink = link;
        mMapLink = new double[2];
        hasMapLink = 1;
        hasImages = 0;
    }

    public int getDescription() {
        return mDescription;
    }

    public int getLink() {
        return mLink;
    }

    public int getImageSmallId() {
        return mImageSmallId;
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

    public double[] getMapLink() {
        return mMapLink;
    }

    public boolean checkForMapLink(){
        return hasMapLink == 0;
    }

    public boolean checkForImage(){
        return hasImages == 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mName);
        dest.writeInt(this.mDistance);
        dest.writeDoubleArray(this.mMapLink);
        dest.writeInt(this.mImageResourceId);
        dest.writeInt(this.mImageSmallId);
        dest.writeInt(this.mDescription);
        dest.writeInt(this.mLink);
        dest.writeInt(this.hasMapLink);
    }

    protected Places(Parcel in) {
        this.mName = in.readInt();
        this.mDistance = in.readInt();
        mMapLink = new double[2];
        in.readDoubleArray(this.mMapLink);
        this.mImageResourceId = in.readInt();
        this.mImageSmallId = in.readInt();
        this.mDescription = in.readInt();
        this.mLink = in.readInt();
        this.hasMapLink = in.readInt();
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
