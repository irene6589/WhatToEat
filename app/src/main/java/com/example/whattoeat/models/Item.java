
package com.example.whattoeat.models;

import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Item implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("measures")
    @Expose
    private Measures measures;
    @SerializedName("usages")
    @Expose
    private List<Object> usages = null;
    @SerializedName("pantryItem")
    @Expose
    private Boolean pantryItem;
    @SerializedName("aisle")
    @Expose
    private String aisle;
    @SerializedName("cost")
    @Expose
    private Double cost;



    /**
     * No args constructor for use in serialization
     * 
     */
    public Item() {
    }

    /**
     * 
     * @param measures
     * @param cost
     * @param name
     * @param pantryItem
     * @param id
     * @param usages
     * @param aisle
     */
    public Item(Integer id, String name, Measures measures, List<Object> usages, Boolean pantryItem, String aisle, Double cost) {
        super();
        this.id = id;
        this.name = name;
        this.measures = measures;
        this.usages = usages;
        this.pantryItem = pantryItem;
        this.aisle = aisle;
        this.cost = cost;
    }

    protected Item(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        measures = in.readParcelable(Measures.class.getClassLoader());
        byte tmpPantryItem = in.readByte();
        pantryItem = tmpPantryItem == 0 ? null : tmpPantryItem == 1;
        aisle = in.readString();
        if (in.readByte() == 0) {
            cost = null;
        } else {
            cost = in.readDouble();
        }
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
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

    public Measures getMeasures() {
        return measures;
    }

    public void setMeasures(Measures measures) {
        this.measures = measures;
    }

    public List<Object> getUsages() {
        return usages;
    }

    public void setUsages(List<Object> usages) {
        this.usages = usages;
    }

    public Boolean getPantryItem() {
        return pantryItem;
    }

    public void setPantryItem(Boolean pantryItem) {
        this.pantryItem = pantryItem;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeParcelable(measures, flags);
        dest.writeByte((byte) (pantryItem == null ? 0 : pantryItem ? 1 : 2));
        dest.writeString(aisle);
        if (cost == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(cost);
        }
    }
}
