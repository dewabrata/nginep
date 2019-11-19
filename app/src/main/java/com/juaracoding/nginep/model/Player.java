
package com.juaracoding.nginep.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player implements Serializable, Parcelable
{

    @SerializedName("id")

    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("handphone")

    private String handphone;
    @SerializedName("password")

    private String password;
    public final static Creator<Player> CREATOR = new Creator<Player>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        public Player[] newArray(int size) {
            return (new Player[size]);
        }

    }
    ;
    private final static long serialVersionUID = -85342069884655518L;

    protected Player(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.handphone = ((String) in.readValue((String.class.getClassLoader())));
        this.password = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Player() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHandphone() {
        return handphone;
    }

    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(username);
        dest.writeValue(email);
        dest.writeValue(handphone);
        dest.writeValue(password);
    }

    public int describeContents() {
        return  0;
    }

}
