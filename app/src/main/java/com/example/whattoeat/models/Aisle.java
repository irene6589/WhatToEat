
package com.example.whattoeat.models;

import java.util.List;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Aisle
{

    @SerializedName("aisle")
    @Expose
    private String aisle;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;



    public Aisle() {
    }

    public Aisle(String aisle, List<Item> items) {
        super();
        this.aisle = aisle;
        this.items = items;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


}
