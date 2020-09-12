package com.mygdx.game.News;

import java.io.Serializable;

public class ServerNews implements Serializable {

    int quantyti = 0;

    public ServerNews(){

    }

    public int getQuantyti() {
        return quantyti;
    }

    public void setQuantyti(int quantyti) {
        this.quantyti = quantyti;
    }

    String title;
    String shortDescription;
    String fullDescription;

    public ServerNews(String title, String shortDescription, String fullDescription) {
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}