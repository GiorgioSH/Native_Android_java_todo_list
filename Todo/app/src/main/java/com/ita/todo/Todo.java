package com.ita.todo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Todo implements Parcelable {
    long id;
    String Name;
    String Urgency;

    public Todo() {
    }

    public Todo(Parcel parcel) {
        this.id = parcel.readLong();
        this.Name = parcel.readString();
        this.Urgency = parcel.readString();
        //Urgency = urgency;
    }

    public static final Parcelable.Creator<Todo> CREATOR = new
            Parcelable.Creator<Todo>(){
                @Override
                public Todo createFromParcel(Parcel parcel) {
                    return new Todo(parcel);
                }

                @Override
                public Todo[] newArray(int size) {
                    return new Todo[size];
                }
            };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrgency() {
        return Urgency;
    }

    public void setUrgency(String urgency) {
        Urgency = urgency;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Urgency='" + Urgency + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(Name);
        parcel.writeString(Urgency);
    }
}
