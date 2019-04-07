package com.sahar.recyclerviewapp.Model;

public class Place {
    String placeName ;
    int imgRec ;
    public Place(){

    }
    public Place(String placeName , int imgRec){
        this.imgRec = imgRec;
        this.placeName = placeName ;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public int getImgRec() {
        return imgRec;
    }

    public void setImgRec(int imgRec) {
        this.imgRec = imgRec;
    }

}
