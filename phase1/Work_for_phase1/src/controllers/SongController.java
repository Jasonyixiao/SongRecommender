package controllers;

import usecases.SongManager;

import java.util.List;

public class SongController {
    private final SongManager songManager;
    private final int recommandAmount = 9;
    public SongController(SongManager songManager){
        this.songManager = songManager;
    }
    public String Listen(String name){
        return songManager.getURL(name);
    }
    public List<String> getRecommend(){
        return songManager.getRecommand(recommandAmount);
    }
    public float getRatting(String name){
        return songManager.displayCurrentRating(name);
    }

}
