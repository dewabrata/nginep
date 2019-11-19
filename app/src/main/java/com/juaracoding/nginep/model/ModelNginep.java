package com.juaracoding.nginep.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ModelNginep implements Serializable, Parcelable
{

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Parcelable.Creator<ModelNginep> CREATOR = new Creator<ModelNginep>() {


        @SuppressWarnings({
                "unchecked"
        })
        public ModelNginep createFromParcel(Parcel in) {
            return new ModelNginep(in);
        }

        public ModelNginep[] newArray(int size) {
            return (new ModelNginep[size]);
        }

    }
            ;
    private final static long serialVersionUID = 5137931776858861165L;

    protected ModelNginep(Parcel in) {
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ModelNginep(String username, String email, String message) {
        this.username = username;
        this.email = email;
        this.message = message;
    }

    public ModelNginep() {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(username);
        dest.writeValue(email);
        dest.writeValue(message);
    }

    public int describeContents() {
        return 0;
    }

}