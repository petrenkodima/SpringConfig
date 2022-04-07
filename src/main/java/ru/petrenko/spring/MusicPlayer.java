package ru.petrenko.spring;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

//@Component
public class MusicPlayer {

    @Value("${musicPlayer.name}")
    private String name;

    @Value("${musicPlayer.volume}")
    private int volume;

    private List<Music> musicList;

//    @Autowired
    public MusicPlayer(List<Music> musicList) {
        this.musicList = musicList;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public String playMusic() {
        Random random = new Random();

        return "Playing: " + musicList.get(random.nextInt(musicList.size())).getSong()
                + " with volume " + this.volume;
    }
}