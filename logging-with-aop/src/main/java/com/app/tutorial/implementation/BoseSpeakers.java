package com.app.tutorial.implementation;

import org.springframework.stereotype.Component;

import com.app.tutorial.interfaces.Speakers;
import com.app.tutorial.model.Song;

@Component
public class BoseSpeakers implements Speakers {

    @Override
    public String makeSound(Song song) {
        return "Playing the song "+ song.getTitle()+ " by "
        + song.getSingerName()+
        " with Bose speakers";
    }
    
}
