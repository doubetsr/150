package Streams;

/********************************************************************
 //  CD.java       Author: Lewis/Loftus
 //
 //  Represents a compact disc.
 //********************************************************************/

import java.text.NumberFormat;

public class CD {
    private String title, artist;
    private double cost;
    private int tracks;
    private int ID;

    //-----------------------------------------------------------------
    //  Creates a new CD with the specified information.
    //-----------------------------------------------------------------
    public CD(String name, String singer, double price, int numTracks, int newID) {
        title = name;
        artist = singer;
        cost = price;
        tracks = numTracks;
        ID = newID;
    }

    public CD() {
        title = "unknown title";
        artist = "unknown artist";
        cost = 0;
        tracks = 0;
        ID = 0;
    }

    public CD(CD copy) {

        this(copy.getTitle(), copy.getArtist(), copy.getCost(), copy.getTracks(),copy.getID());
    }

    public double getCost() {       return cost;    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getTracks() {
        return tracks;
    }
    public void setTracks(int tracks) {
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getID() {
        return ID;
    }
    public void setID(int newId) {
        this.ID = newId;
    }


    //-----------------------------------------------------------------
    //  Returns a description of this CD.
    //-----------------------------------------------------------------
    public String toString() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String description = title + "\t" + artist+"\t"+ID+"\t";

        description += fmt.format(cost) + "\t" + tracks;

        return description;
    }
}
