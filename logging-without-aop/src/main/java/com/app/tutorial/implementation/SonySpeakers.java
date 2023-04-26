package com.app.tutorial.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.app.tutorial.interfaces.Speakers;
import com.app.tutorial.model.Song;

@Component
@Primary
public class SonySpeakers implements Speakers{

    @Override
    public String makeSound(Song song) {
        return "Playing the song "+ song.getTitle()+ " by "
                + song.getSingerName()+
                " with Sony speakers";
    }
    
}
