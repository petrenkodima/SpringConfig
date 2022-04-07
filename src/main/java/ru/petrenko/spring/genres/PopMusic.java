package ru.petrenko.spring.genres;

//import org.springframework.stereotype.Component;
import ru.petrenko.spring.Music;

//@Component
public class PopMusic implements Music {
    @Override
    public String getSong() {
        return "Rampampam";
    }
}
