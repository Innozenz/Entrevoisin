package com.openclassrooms.entrevoisins.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;

import java.util.List;
import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour implements Parcelable {

    /** Identifier */
    private Integer id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     */
    public Neighbour(Integer id, String name, String avatarUrl) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    protected Neighbour(Parcel in) {
        id = in.readInt();
        name = in.readString();
        avatarUrl = in.readString();
    }

    public static final Creator<Neighbour> CREATOR = new Creator<Neighbour>() {
        @Override
        public Neighbour createFromParcel(Parcel in) {
            return new Neighbour(in);
        }

        @Override
        public Neighbour[] newArray(int size) {
            return new Neighbour[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(avatarUrl);
    }
}
