
package com.juaracoding.nginep.model;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable, Parcelable
{

    @SerializedName("player")
    @Expose
    private List<Player> player = null;
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6495453896807681208L;

    protected Data(Parcel in) {
        in.readList(this.player, (com.juaracoding.nginep.model.Player.class.getClassLoader()));
    }

    public Data() {
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(player);
    }

    public int describeContents() {
        return  0;
    }

}
