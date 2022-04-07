package ru.petrenko.spring.config;

import org.springframework.context.annotation.*;
import ru.petrenko.spring.Computer;
import ru.petrenko.spring.Music;
import ru.petrenko.spring.MusicPlayer;
import ru.petrenko.spring.genres.ClassicalMusic;
import ru.petrenko.spring.genres.JazzMusic;
import ru.petrenko.spring.genres.PopMusic;
import ru.petrenko.spring.genres.RockMusic;

import java.util.Arrays;
import java.util.List;


@Configuration
//@ComponentScan("ru.petrenko.spring")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
    @Bean
    @Scope("prototype")
    public ClassicalMusic classicalMusic() {
        return new ClassicalMusic();
    }

    @Bean
    public JazzMusic jazzMusic() {
        return new JazzMusic();
    }

    @Bean
    public PopMusic popMusic() {
        return new PopMusic();
    }

    @Bean
    public RockMusic rockMusic() {
        return new RockMusic();
    }

    @Bean
    public List<Music> musicList() {
        // Этот лист неизменяемый (immutable)
        return Arrays.asList(classicalMusic(), rockMusic(), jazzMusic(), popMusic());
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicList());
    }

    @Bean
    public Computer computer() {
        return new Computer(musicPlayer());
    }
}
